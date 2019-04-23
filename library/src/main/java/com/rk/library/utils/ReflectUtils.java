package com.rk.library.utils;

import java.lang.reflect.Field;

/**
 * @author orange
 * @time 2019-04-23 22:37
 */
public class ReflectUtils {


    /**
     * 通过反射获取某对象，斌设置私有可访问
     *
     * @param object 该属性所属的而对象
     * @param clazz  该属性所属的类
     * @param field  该属性名
     * @return 该属性对象
     */
    private static Object getField(Object object, Class<?> clazz, String field) throws NoSuchFieldException, IllegalAccessException {
        Field localField = clazz.getDeclaredField(field);
        localField.setAccessible(true);
        return localField.get(object);
    }


    public static void setField(Object object, Class<?> clazz, Object value) throws NoSuchFieldException, IllegalAccessException {

        Field localField = clazz.getDeclaredField("dexElements");
        localField.setAccessible(true);
        localField.set(object, value);
    }
    /**
     * 通过反射获取baseDexClassLoader对象中的PathList对象
     *
     * @param baseDexClassLoader 该属性所属的而对象
     * @return PathList对象
     */
    public static Object getPathList(Object baseDexClassLoader) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return getField(baseDexClassLoader, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    /**
     * 通过反射获取baseDexClassLoader对象中的PathList对象,在获取dexElements对象
     *
     * @param paramObject PathList对象
     * @return dexElements对象
     */
    public static Object getDexElements(Object paramObject) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return getField(paramObject, paramObject.getClass(), "dexElements");
    }
}
