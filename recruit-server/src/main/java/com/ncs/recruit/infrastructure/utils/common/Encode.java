package com.ncs.recruit.infrastructure.utils.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class Encode {

    public static String getMD5Digest(String sourceData) {
        try {
            //此句话是采用MD5算法加密
            //MessageDigest alga = MessageDigest.getInstance("MD5");

            //此句话是采用SHA-1算法
            MessageDigest alga = MessageDigest.getInstance("SHA-1");
            alga.update(sourceData.getBytes());
            byte[] digesta = alga.digest();
            return byteToHexString(digesta);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * MD5算法或者SHA-1算法要用到的加密算法
     * 二进制数据转换成十六进制字符串
     *
     * @param b
     *     byte[] 字节流
     * @return String 十六进制字符串
     * @author Carry
     */
    public static String byteToHexString(byte[] b) {

        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1)
                hs = hs + "";
        }
        return hs;
    }

    /**
     * Base64加密算法
     *
     * @param sourceData
     *     明文
     * @return 密文
     */
    public static String encode(String sourceData) {
        String str = Base64.encodeBase64String(sourceData.getBytes());
        return str;
    }

    /**
     * Base64解密算法
     *
     * @param str
     *     密文
     * @return 明文
     */
    public static String decode(String str) {
        try {
            byte[] sourceData = Base64.decodeBase64(str);
            return new String(sourceData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
