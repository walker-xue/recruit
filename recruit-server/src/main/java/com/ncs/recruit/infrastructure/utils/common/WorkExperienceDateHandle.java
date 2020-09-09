package com.ncs.recruit.infrastructure.utils.common;

public class WorkExperienceDateHandle {

    public static String handleString(String str) {
        StringBuffer newDateStr = new StringBuffer();
        int count = 0;
        if (str != null && !"".equals(str) && !"null".equals(str)) {
            str = str.replaceAll(" ", "");
            str = str.replace(".", "-");
            str = str.replace("/", "-");
            String arrayDate[] = str.split("-");
            for (int i = 0; i < arrayDate.length; i++) {
                if (arrayDate[i].length() == 1) {
                    arrayDate[i] = "0" + arrayDate[i];
                }
                if (count >= 1 && (arrayDate[i].length() >= 3 || "至今".equals(arrayDate[i]))) {
                    newDateStr.deleteCharAt(newDateStr.length() - 1);
                    newDateStr.append("/");
                }
                if (!"".equals(arrayDate[i])) {
                    newDateStr.append(arrayDate[i] + "-");
                }
                if (i == (arrayDate.length - 1)) {
                    newDateStr.deleteCharAt(newDateStr.length() - 1);
                }
                if (arrayDate[i].length() >= 3) {
                    count++;
                }
            }
            return newDateStr.toString();
        }

        return null;
    }

}
