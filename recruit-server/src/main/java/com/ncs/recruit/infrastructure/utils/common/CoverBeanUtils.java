package com.ncs.recruit.infrastructure.utils.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.ncs.recruit.context.system.model.ChangeLog;

public class CoverBeanUtils {

    public static List<ChangeLog> coverBean2Bean(Object from, Object to) {
        Class<? extends Object> fClass = from.getClass();
        Class<? extends Object> tClass = to.getClass();
        List<ChangeLog> changeList = new ArrayList<ChangeLog>();
        // 拿到所有属性（如果有继承，父类属性拿不到）
        Field[] cFields = tClass.getDeclaredFields();

        try {
            for (Field field : cFields) {
                String cKey = field.getName();
                // 确定第一个字母大写
                String cKey_uc = cKey.substring(0, 1).toUpperCase() + cKey.substring(1);
                Method fMethod;
                Object fValue;
                Method tMethod;
                Object tValue;
                try {
                    fMethod = fClass.getMethod("get" + cKey_uc);// public方法
                    fValue = fMethod.invoke(from);// 取getfKey的值
                    tMethod = tClass.getMethod("get" + cKey_uc);
                    tValue = tMethod.invoke(to);
                } catch (Exception e) {
                    try {
                        fMethod = fClass.getMethod("is" + cKey_uc);
                        fValue = fMethod.invoke(from);
                        tMethod = tClass.getMethod("is" + cKey_uc);
                        tValue = tMethod.invoke(to);
                    } catch (Exception e1) { // 如果from没有此属性的get方法或is方法，跳过
                        continue;
                    }
                }
                if (fValue != null || tValue != null) {
                    if (fValue != null && tValue != null) {
                        if (fValue.equals(tValue))
                            continue;
                    }
                    try {
                        // 用fMethod.getReturnType()，而不用fValue.getClass()
                        // 为了保证get方法时，参数类型是基本类型而传入对象时会找不到方法
                        Method cMethod = tClass.getMethod("set" + cKey_uc, fMethod.getReturnType());
                        cMethod.invoke(to, fValue);
                        changeList.add(new ChangeLog(tValue, fValue, cKey));
                    } catch (Exception e) {
                        // 如果to没有此属性set方法，跳过
                        continue;
                    }
                } else {
                    continue; // 如果get方法返回空,或者两个属性相等则不填充
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return changeList;
    }

    /**
     * 复制list中对象的属性
     *
     * @param sourceList
     *     源List
     * @param targetList
     *     目标List
     * @param tgtClass
     *     目标List中对象的类
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void copyList2List(List sourceList, List targetList, Class tgtClass) {
        Assert.notEmpty(sourceList, "sourceList must not be empty");
        Assert.notNull(targetList, "targetList must not be null");

        int size = sourceList.size();
        Object source = null;
        try {
            for (int i = 0; i < size; i++) {
                source = sourceList.get(i);
                if (source == null)
                    continue;
                Object target = tgtClass.newInstance();
                BeanUtils.copyProperties(source, target);
                targetList.add(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ChangeLog> coverParent2Child(Object from, Object to) {
        Class<? extends Object> fClass = from.getClass();
        Class<? extends Object> tClass = to.getClass();
        // 拿to所有属性（如果有继承，父类属性拿不到）
        Field[] cFields = fClass.getDeclaredFields();
        List<ChangeLog> changeList = new ArrayList<ChangeLog>();
        try {
            for (Field field : cFields) {
                String cKey = field.getName();
                // 确定第一个字母大写
                String cKey_uc = cKey.substring(0, 1).toUpperCase() + cKey.substring(1);
                Method fMethod;
                Object fValue;
                Method tMethod;
                Object tValue;
                try {
                    fMethod = fClass.getMethod("get" + cKey_uc);// public方法
                    fValue = fMethod.invoke(from);// 取getfKey的值
                    tMethod = tClass.getMethod("get" + cKey_uc);
                    tValue = tMethod.invoke(to);

                } catch (Exception e) {
                    try {
                        fMethod = fClass.getMethod("is" + cKey_uc);
                        fValue = fMethod.invoke(from);
                        tMethod = tClass.getMethod("is" + cKey_uc);
                        tValue = tMethod.invoke(to);
                    } catch (Exception e1) { // 如果from没有此属性的get方法或is方法，跳过
                        continue;
                    }
                }
                if (fValue == null || fValue.equals(tValue)) {
                    try {
                        Method cMethod = tClass.getMethod("set" + cKey_uc, fMethod.getReturnType());
                        cMethod.invoke(to, "");
                    } catch (Exception e) {

                    }
                    continue; // 如果get方法返回空,或者两个属性相等则不填充
                }
                try {
                    // 用fMethod.getReturnType()，而不用fValue.getClass()
                    // 为了保证get方法时，参数类型是基本类型而传入对象时会找不到方法
                    Method cMethod = tClass.getMethod("set" + cKey_uc, fMethod.getReturnType());
                    cMethod.invoke(to, fValue);
                    changeList.add(new ChangeLog(tValue, fValue, cKey));
                } catch (Exception e) {
                    // 如果to没有此属性set方法，跳过
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return changeList;
    }

    public static String[] convertList2Array(List<Object> list) {
        String[] arrs = null;
        if (list != null && list.size() > 0) {
            arrs = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arrs[i] = list.get(i).toString();
            }
        }
        return arrs;
    }

}
