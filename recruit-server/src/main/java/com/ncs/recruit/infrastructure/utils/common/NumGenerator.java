package com.ncs.recruit.infrastructure.utils.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NumGenerator {

    /**
     * 需求编号生成器
     *
     * @return
     */
    public static String generateDemandNum() {
        StringBuffer number;
        String dateStr;
        //获得年月日字符串
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddhhmmss");
        //是不是严格按照指定的格式解析日期    
        format1.setLenient(false);
        ;
        dateStr = format1.format(new Date());

        //构造订单号   
        number = new StringBuffer("XQ");
        number.append(dateStr);
        return number.toString();

    }
    /**
     * 简历编号生成器
     *
     * @return
     */
    public static String generateResumeNum() {
        StringBuffer number;
        String dateStr;
        //获得年月日字符串
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddhhmmss");
        //是不是严格按照指定的格式解析日期    
        format1.setLenient(false);
        ;
        dateStr = format1.format(new Date());

        //构造订单号   
        number = new StringBuffer("JL");
        number.append(dateStr);
        return number.toString();

    }
	
/*	
	public static void main(String[] args) {
		System.out.println(generatorNum());
	}*/

}
