package com.ncs.recruit.infrastructure.utils.resumeparase;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParase {

    /**
     * 通过递归删除html标签
     *
     * @param content
     *     - 包含HTML标签的内容
     * @return 不带HTML标签的文本内容
     * @author Jack, 2014-05-15.
     */
    public static String removeHtmlTag(String content) {
        Pattern p = Pattern.compile("<([a-zA-Z]+)>(.*?)</\\1>");
        Matcher m = p.matcher(content);
        if (m.find()) {
            String subString = content.substring(content.indexOf("<style"), content.indexOf("</style>") + 8);
            content = content.replace(subString, "");
            content = content.replaceAll("<([^>]*)>", "");
            content = content.replaceAll("[\\n\\r]", "");
            content = content.replaceAll("&nbsp;", "");
            StringBuffer contentBuffer = new StringBuffer();
            for (int i = 0; i < content.length(); i++) {
                char arr = content.charAt(i);
                if (((int) arr <= 127 || (int) arr >= 255) && (int) arr != 8203 && arr != ' ')
                    contentBuffer.append(arr);
            }
            content = removeHtmlTag(contentBuffer.toString());
        }
        int remove_char1 = content.indexOf("简历");
        int romove_char2 = content.indexOf("简介");
        if ((remove_char1 > -1 || romove_char2 > -1) && remove_char1 <= 10 && romove_char2 <= 10) {
            int max_index = remove_char1 > romove_char2 ? remove_char1 : romove_char2;
            content = content.substring(max_index + 2);

        }
        return content;
    }

    /**
     * 按照字节读取输入流
     *
     * @param is
     * @return
     * @throws Exception
     */
    public static byte[] getBytes(String filePath) throws Exception {
        InputStream is = new FileInputStream(filePath);
        byte[] data = null;
        Collection chunks = new ArrayList();
        byte[] buffer = new byte[1024 * 1000];
        int read = -1;
        int size = 0;
        while ((read = is.read(buffer)) != -1) {
            if (read > 0) {
                byte[] chunk = new byte[read];
                System.arraycopy(buffer, 0, chunk, 0, read);
                chunks.add(chunk);
                size += chunk.length;
            }
        }
        if (size > 0) {
            ByteArrayOutputStream bos = null;
            try {
                bos = new ByteArrayOutputStream(size);
                for (Iterator itr = chunks.iterator(); itr.hasNext(); ) {
                    byte[] chunk = (byte[]) itr.next();
                    bos.write(chunk);
                }
                data = bos.toByteArray();
            } finally {
                if (bos != null) {
                    bos.close();
                }
            }
        }
        return data;
    }

}
