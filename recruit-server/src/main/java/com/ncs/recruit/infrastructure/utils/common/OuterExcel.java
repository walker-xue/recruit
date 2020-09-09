package com.ncs.recruit.infrastructure.utils.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import com.ncs.recruit.context.resume.dto.ResumeAndDetailDto;

/**
 * 应用泛型，代表任意一个符合javabean风格的类
 * 注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 * byte[]表jpg格式的图片数据
 *
 * @author leno, slieer
 * @version v1.0
 */
public class OuterExcel {

    @SuppressWarnings("unused")
    private static FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM-dd hh:mm:ss");

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     *
     * @param title
     *     表格标题名
     * @param headers
     *     表格属性列名数组
     * @param dataset
     *     需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *     javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out
     *     与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     */

    public static void exportExcel(String title, String[] headers, Collection<ResumeAndDetailDto> dataset, FileOutputStream out) {

        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);

        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);

        // 声明一个画图的顶级管理器
        //  HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(0, CellType.valueOf("1"));
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<ResumeAndDetailDto> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            ResumeAndDetailDto t = (ResumeAndDetailDto) it.next();

            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                //cell.setCellStyle(style);
                Field field = fields[i];
                Field fieldShang = fields[i - 1];
                ;
                String fieldName = field.getName();
                String fieldName2 = fieldShang.getName();
                if (fieldName.equals(fieldName2)) {
                    continue;
                }

                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                try {
                    @SuppressWarnings("rawtypes")
                    Class tCls = t.getClass();

                    @SuppressWarnings("unchecked")
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});

                    cell.setCellValue(value != null ? value.toString() : "");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 清理资源
                }
            }
        }
        try {
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
