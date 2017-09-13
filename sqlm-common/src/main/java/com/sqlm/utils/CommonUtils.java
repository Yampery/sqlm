package com.sqlm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @decription CommonUtils
 * <p>通用工具</p>
 * @author Yampery
 * @date 2017/9/13 10:43
 */
public class CommonUtils {

    /**
     * 对List中的元素去除重复
     * @param objects
     * @return
     */
    public static List removeDuplicate(List objects) {

        List<Object> newList = new ArrayList<>();
        if (isNull(objects))
            return null;
        for (Object obj : objects) {
            if (!newList.contains(obj))
                newList.add(obj);
        } /// for end~

        return newList;
    }

    /**
     * 判断list是否为空
     * @param list
     * @return
     */
    public static boolean isNull(List list) {
        return null == list || list.size() < 1;
    }

    /**
     * 判断数组是否为空
     * @param arr
     * @return
     */
    public static boolean isNullArray(Object[] arr) {
        return null == arr || 1 > arr.length;
    }

    /**
     * 将对象转化为字符串
     * <p>参数<tt>obj</tt>指定一个要转换为字符串的对象，通常是为了通用性，
     * 将返回结果设置为<tt>Map<String, Object></tt>的情况..<br>
     * 参数<tt>isTrim</tt>将决定是否对返回字符换做去除空格处理，false-不做处理，true-去除空格</p>
     * @param obj 对象
     * @param isTrim 是否去除空格
     * @return
     */
    public static String objectToString(Object obj, boolean isTrim) {

        String str = obj == null ? "" : obj.toString();
        if (isTrim) str = str.trim();

        return str;
    }

    /**
     * 默认返回去除空格的字符串
     * @param obj
     * @return
     */
    public static String objectToString(Object obj) {
        return objectToString(obj, true);
    }
}
