package com.ncs.recruit.infrastructure.utils.resumeparase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

/**
 * Hello world!
 */
public class WordAndExcelParase {

    /**
     * @param
     * @return String
     * @throws
     * @Method: extractTextFromDOCX
     * @Description: 从word 2003文档中提取纯文本  ， 图片不会被读取
     */
    public static String extractTextFromDOC(String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        WordExtractor extractor = new WordExtractor(is); //is是WORD文件的InputStream
        String text2003 = extractor.getText();
        String content = text2003.replace(" ", "");
        content = content.replaceAll("&nbsp;", "");
        String content2 = content.replaceAll("[\\n\\r\\t]*", "");
        StringBuffer contentBuffer = new StringBuffer();
        for (int i = 0; i < content2.length(); i++) {
            char arr = content2.charAt(i);
            if (((int) arr <= 127 || (int) arr >= 255) && (int) arr != 8203) {
                contentBuffer.append(arr);
            }
        }
        content = contentBuffer.toString();
        int remove_char1 = content.indexOf("简历");
        int romove_char2 = content.indexOf("简介");
        if ((remove_char1 > -1 || romove_char2 > -1) && remove_char1 <= 10 && romove_char2 <= 10) {
            int max_index = remove_char1 > romove_char2 ? remove_char1 : romove_char2;
            content = content.substring(max_index + 2);

        }
        return content;
    }

    /**
     * @param
     * @return String
     * @throws
     * @Method: extractTextFromDOCX
     * @Description: 从word 2007文档中提取纯文本 , 图片不会被读取， 表格中的数据会被放在字符串的最后
     */
    public static String extractTextFromDOC2007(String filePath) throws IOException, OpenXML4JException, XmlException {
        OPCPackage opcPackage = POIXMLDocument.openPackage(filePath);
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
        String text2007 = extractor.getText();
        String contentDocx = text2007.replace(" ", "");
        contentDocx = contentDocx.replaceAll("&nbsp;", "");
        contentDocx = contentDocx.replaceAll("[\\n\\r\\t]*", "");
        StringBuffer contentBufferDocx = new StringBuffer();
        for (int i = 0; i < contentDocx.length(); i++) {
            char arr = contentDocx.charAt(i);
            if (((int) arr <= 127 || (int) arr >= 255) && (int) arr != 8203) {
                contentBufferDocx.append(arr);
            }
        }
        contentDocx = contentBufferDocx.toString();
        //取出简历中含有前面几个字是简历、简介。
        //去除掉的目的是为了方便截取“姓名”字段
        int remove_char1 = contentDocx.indexOf("简历");
        int romove_char2 = contentDocx.indexOf("简介");
        if ((remove_char1 > -1 || romove_char2 > -1) && remove_char1 <= 10 && romove_char2 <= 10) {
            int max_index = remove_char1 > romove_char2 ? remove_char1 : romove_char2;
            contentDocx = contentDocx.substring(max_index + 2);
        }
        return contentDocx;
    }

    /**
     * @param
     * @return String
     * @throws
     * @Method: extractTextFromXLS
     * @Description: 从excel 2003文档中提取纯文本
     */
    private static String extractTextFromXLS(InputStream is)
        throws IOException {
        StringBuffer content = new StringBuffer();
        HSSFWorkbook workbook = new HSSFWorkbook(is); //创建对Excel工作簿文件的引用

        for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
            if (null != workbook.getSheetAt(numSheets)) {
                HSSFSheet aSheet = workbook.getSheetAt(numSheets); //获得一个sheet

                for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
                    if (null != aSheet.getRow(rowNumOfSheet)) {
                        HSSFRow aRow = aSheet.getRow(rowNumOfSheet); //获得一行

                        for (short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {
                            if (null != aRow.getCell(cellNumOfRow)) {
                                HSSFCell aCell = aRow.getCell(cellNumOfRow); //获得列值

                                if (aCell.getCellType() == CellType.NUMERIC) {
                                    content.append(aCell.getNumericCellValue());
                                } else if (aCell.getCellType() == CellType.BOOLEAN) {
                                    content.append(aCell.getBooleanCellValue());
                                } else {
                                    content.append(aCell.getStringCellValue());
                                }
                            }
                        }
                    }
                }
            }
        }

        return content.toString();
    }

    /**
     * @param
     * @return String
     * @throws
     * @Method: extractTextFromXLS2007
     * @Description: 从excel 2007文档中提取纯文本
     */
    private static String extractTextFromXLS2007(String fileName) throws Exception {
        StringBuffer content = new StringBuffer();
        //构造 XSSFWorkbook 对象，strPath 传入文件路径
        XSSFWorkbook xwb = new XSSFWorkbook(fileName);
        //循环工作表Sheet
        for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
            XSSFSheet xSheet = xwb.getSheetAt(numSheet);
            if (xSheet == null) {
                continue;
            }

            //循环行Row
            for (int rowNum = 0; rowNum <= xSheet.getLastRowNum(); rowNum++) {
                XSSFRow xRow = xSheet.getRow(rowNum);
                if (xRow == null) {
                    continue;
                }
                //循环列Cell
                for (int cellNum = 0; cellNum <= xRow.getLastCellNum(); cellNum++) {
                    XSSFCell xCell = xRow.getCell(cellNum);
                    if (xCell == null) {
                        continue;
                    }

                    if (xCell.getCellType() == CellType.BOOLEAN) {
                        content.append(xCell.getBooleanCellValue());
                    } else if (xCell.getCellType() == CellType.NUMERIC) {
                        content.append(xCell.getNumericCellValue());
                    } else {
                        content.append(xCell.getStringCellValue());
                    }
                }
            }
        }
        return content.toString();
    }
}
