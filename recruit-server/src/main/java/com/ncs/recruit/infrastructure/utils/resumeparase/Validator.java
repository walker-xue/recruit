package com.ncs.recruit.infrastructure.utils.resumeparase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验器：利用正则表达式校验邮箱、手机号等
 *
 * @author feizhanga
 */
public class Validator {

    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "(?<!\\d)(?:(?:1[358]\\d{9})|(?:861[358]\\d{9}))(?!\\d)";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "\\d{17}\\w|(\\d{14}\\w)";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }

    /**
     * 从字符串中提取电话号码
     *
     * @param sParam
     * @return
     */
    public static String getTelnum(String sParam) {
        if (sParam.length() <= 0)
            return null;
        Pattern pattern = Pattern.compile("(?<!\\d)(?:(?:1[3578]\\d{9})|(?:861[3578]\\d{9}))(?!\\d)");
        Matcher matcher = pattern.matcher(sParam);
        StringBuffer bf = new StringBuffer(sParam.length());
        //matcher.group();
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
            break;
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        System.out.println(bf.toString());
        return bf.toString();

    }
    /**
     * 从字符串中提取身份证号码
     *
     * @param sParam
     * @return
     */
    public static String getIdCard(String sParam) {
        if (sParam.length() <= 0)
            return null;
        Pattern pattern = Pattern.compile("\\d{17}\\w|(\\d{14}\\w)");
        Matcher matcher = pattern.matcher(sParam);
        StringBuffer bf = new StringBuffer(sParam.length());
        //matcher.group();
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
            break;
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        System.out.println(bf.toString());
        return bf.toString();

    }

    /**
     * 从字符串中提取出邮箱
     *
     * @param sParam
     * @return
     */
    public static String getEmail(String sParam) {

        if (sParam.length() <= 0)
            return null;

        Pattern pattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = pattern.matcher(sParam);
        StringBuffer bf = new StringBuffer(sParam.length());
        //matcher.group();
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
            break;
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        System.out.println(bf.toString());
        return bf.toString();

    }
    /**
     * 出生日期匹配：匹配规则是19xx（年，-，/，空）07（或者是7）月（或者没有月），20xx（年，-，/，空）07（或者是7）月（或者没有月）,或者从身份号中匹配出来
     *
     * @param sParam
     * @return
     */
    public static String getbirth(String sParam) {

        if (sParam.length() <= 0)
            return null;

        Pattern pattern = Pattern.compile("((19[0-9]{2}|20[0-9]{2})([年|[-]|.|//]+)(0[1-9]{1}|[1-9]{1}|1[012])([月]?))|(([1-7]{1}[0-9]{1})([岁]))");
        Matcher matcher = pattern.matcher(sParam);
        StringBuffer bf = new StringBuffer(sParam.length());
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
            break;
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        System.out.println("出生年月：" + bf.toString());
        return bf.toString();

    }
    /**
     * 工作经验匹配：匹配规则是xx年(多)工作经验，xx.xx年(多)工作经验，xx年xx月工作经验，xx年xx月(多)工作经验
     *
     * @param sParam
     * @return
     */
    public static String getWorkExprice(String sParam) {

        if (sParam.length() <= 0)
            return null;

        Pattern pattern = Pattern.compile("([0-9]{1,2}+(.[0-9]{1,3})?)年(([0-9]{1,2})?(月|多)?)?工作经验");
        Matcher matcher = pattern.matcher(sParam);
        StringBuffer bf = new StringBuffer();
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
            break;
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        } else {
            //工作年限：
        }

        return bf.toString();

    }
    /**
     * 工作经验匹配：匹配规则是xx年(多)工作经验，xx.xx年(多)工作经验，xx年xx月工作经验，xx年xx月(多)工作经验
     *
     * @param sParam
     * @return
     */
    public static String getWorkExpNum(String sParam) {

        if (sParam.length() <= 0)
            return null;

        Pattern pattern = Pattern.compile("[0-9]{1,2}+(.[0-9]{1,3})?");
        Matcher matcher = pattern.matcher(sParam);
        StringBuffer bf = new StringBuffer(20);

        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
            break;
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        } else {
            //工作年限：
        }
        System.out.println(bf.toString());
        return bf.toString();

    }

    /**
     * 找出简历中“|”字符的所有位置
     *
     * @param sParam
     * @return
     */
    public static int[] getSeparatorIndex(String sParam) {
        int i = 0;

        int[] indexArray1 = new int[sParam.length()];
        if (sParam.length() <= 0)
            return null;

        if (sParam.contains("|")) {
            for (int j = 0; j < sParam.length(); j++) {
                char arr = sParam.charAt(j);
                if ('|' == arr) {
                    indexArray1[i] = j;
                    i++;
                }
            }
            Arrays.sort(indexArray1);
            int[] indexArray = new int[i];
            for (int j = 0; j < indexArray.length; j++) {
                indexArray[j] = indexArray1[indexArray1.length - 1 - j];
            }
            Arrays.sort(indexArray);
            return indexArray;
        } else {
            return null;
        }

    }
    /**
     * 提取简历中的简历详情关键字
     *
     * @param sParam
     * @return
     */
    public static List<String> getDetailKeywords4Resume(String sParam) {

        if (sParam.length() <= 0)
            return null;
        List<String> keyWordsList = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(工作经历|工作经验|项目经验|教育经历|教育及培训经历|培训经历|证书)[1-2]{1}([0|9]{1})[0-9]{2}");
        Matcher matcher = pattern.matcher(sParam);
        while (matcher.find()) {
            keyWordsList.add(matcher.group());
        }
        System.out.println("工作经历+时间：" + keyWordsList);
        return keyWordsList;

    }

    /**
     * 判断字符串是否是整数
     *
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

}