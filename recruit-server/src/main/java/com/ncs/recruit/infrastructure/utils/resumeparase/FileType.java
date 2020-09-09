package com.ncs.recruit.infrastructure.utils.resumeparase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FileType {

    public final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();
    private FileType() {
    }
    //静态代码块，创建对象前首先加载
    static {
        getAllFileType(); //初始化文件类型信息     
    }

    /**
     * Discription:[getAllFileType,常见文件头信息]
     */
    private static void getAllFileType() {
        FILE_TYPE_MAP.put("3c68746d6c20786d6c6e", "htm");//猎聘、智联简历.htm
        FILE_TYPE_MAP.put("46726f6d3a3cd3c920cd", "mht");//51job简历.mht
        FILE_TYPE_MAP.put("504b0304140006000800", "docx");//2007版以上的word
        FILE_TYPE_MAP.put("504b0304140008080800", "docx");//2007版以上的word
        FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", "doc");//2003版以下的word

    }

    /**
     * 得到上传文件的文件头
     *
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 根据制定文件的文件头判断其文件类型
     *
     * @param filePaht
     * @return
     */
    public static String getFileType(String filePath) {
        String res = null;
        try {
            FileInputStream is = new FileInputStream(filePath);
            byte[] b = new byte[10];
            is.read(b, 0, b.length);
            String fileCode = bytesToHexString(b);
            System.out.println(fileCode);
            //这种方法在字典的头代码不够位数的时候可以用但是速度相对慢一点
            Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
            while (keyIter.hasNext()) {
                String key = keyIter.next();
                if (key.toLowerCase().startsWith(fileCode.toLowerCase()) || fileCode.toLowerCase().startsWith(key.toLowerCase())) {
                    res = FILE_TYPE_MAP.get(key);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    //测试方法
    public static void main(String[] args) throws Exception {

        String type = getFileType("E:\\简历样本\\isoftstone-企业服务-JAVA-陈明熙-9.20(1).docx");
        System.out.println("Except : " + type);

    }
}