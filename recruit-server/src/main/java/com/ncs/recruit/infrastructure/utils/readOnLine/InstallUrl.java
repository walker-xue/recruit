package com.ncs.recruit.infrastructure.utils.readOnLine;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class InstallUrl {

    //读取配置文件的信息
    public String installPath(String fieldName) {

        String fieldValue = "";
        Properties properties = new Properties();
        try {
            Enumeration<URL> configs = this.getClass().getClassLoader().getResources("properties/paramConfig.properties");
            while (configs.hasMoreElements()) {
                URL url = configs.nextElement();
                InputStream in = url.openStream();
                try {
                    properties.load(in);
                    fieldValue = properties.getProperty(fieldName);
                } finally {
                    in.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("when load AttributeType conf=", e);
        }

        System.out.println("获取配置文件中属性的值是：" + fieldValue);

        return fieldValue;

    }
    public static void main(String[] args) {
        InstallUrl il = new InstallUrl();
        il.installPath("openOffice.WinUrl");

    }

}
