package com.liu.library.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @作者：柳景兴
 * @时间：2020-3-17
 * @描述：各种数据类型之间的转化类
 * @技术：阿里巴巴的JSON转化器fastjson
 */
public class ConvertUtil {
    /**
     * 将bean对象转化为string对象
     * @param value
     * @param <T>
     * @return json字符串
     */
    public static <T> String bean2String(T value) {
        Class<?> currentClass = value.getClass();
        if (value == null) {
            return null;
        } else if (currentClass == int.class || currentClass == Integer.class || currentClass == Long.class || currentClass == long.class) {
            return "" + value;
        } else if (currentClass == String.class) {
            return (String) value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * 将string对象转化为bean对象
     * @param value
     * @param clazz
     * @param <T>
     * @return 指定的bean对象
     */
    public static <T> T string2Bean(String value, Class<T> clazz) {
        if (value == null || value.length() == 0 || clazz == null) {
            return null;
        } else if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(value);
        } else if (clazz == long.class || clazz == Integer.class) {
            return (T) Long.valueOf(value);
        } else if (clazz == String.class) {
            return (T) value;
        } else {
            return JSON.toJavaObject(JSON.parseObject(value), clazz);
        }
    }

    /**
     * 将任意对象转化为JSON对象
     * 虽然反射机制不仅拉低了效率，而且因为访问了私有变量，降低了安全性
     * 但是只能这样了。前端无法接受其他任何形式的JSON强转对象
     * @param t
     * @param <T>
     * @return
     */
    public static <T> JSONObject pojo2JSON(T t) {
        JSONObject json = new JSONObject();
        Class className = t.getClass();
        Field[] fields = className.getDeclaredFields();
        for (int i = 0; i < fields.length; i++){
            try {
                //得到属性
                Field field = fields[i];
                //打开私有访问
                field.setAccessible(true);
                //获取属性
                String name = field.getName();
                //获取属性值
                Object value = field.get(t);
                //一个个赋值
                json.put(name, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}
