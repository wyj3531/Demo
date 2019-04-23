package com.rk.library;

import android.content.Context;

import com.rk.library.utils.ArrayUtils;
import com.rk.library.utils.Constants;
import com.rk.library.utils.ReflectUtils;

import java.io.File;
import java.util.HashSet;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * @author orange
 * @time 2019-04-22 23:50
 */
public class FixDexUtils {
    //存放需要修复的dex集合

    private static HashSet<File> loadedDex=new HashSet<>();

    static {
        loadedDex.clear();
    }
    public static void loadFixedDex(Context context) {
        if (context == null) {
            return;
        }


        File fileDir=context.getDir(Constants.DEX_DIR,Context.MODE_PRIVATE);
        File[] files = fileDir.listFiles();
        for (File file : files) {
            if (file.getName().endsWith(Constants.DEX_SUFFIX)
            &&!"classes.dex".equals(file.getName())) {
                loadedDex.add(file);
            }
        }

        //TODO:模拟类加载器

        createDexClassLoader(context,fileDir);

    }

    private static void createDexClassLoader(Context context, File fileDir) {
        String optimizedDir = fileDir.getAbsolutePath() + File.separator + "opt_dex";
        File fopt=new File(optimizedDir);
        if (!fopt.exists()) {
            fopt.mkdirs();
        }

        for (File dex : loadedDex) {
            //初始化DexClassLoade(自有的)
            DexClassLoader dexClassLoader = new DexClassLoader(dex.getAbsolutePath(), optimizedDir,
                    null, context.getClassLoader());
            //每遍历一个需要修复的dex文件，就需要插对一次
            hotFix(dexClassLoader,context);
        }


    }

    private static void hotFix(DexClassLoader classLoader, Context context) {

        //获取系统pathClassLoader
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        try {
            //获取自有dexElements数组
            Object myDexElements = ReflectUtils.getDexElements(ReflectUtils.getPathList(classLoader));

            //获取系统的dexElements数组
            Object systemDexElements = ReflectUtils.getDexElements(ReflectUtils.getPathList(pathClassLoader));

            //合并成新的dexElements数组，斌设置自有的优先级
            Object dexElements = ArrayUtils.combineArray(myDexElements, systemDexElements);

            //获取系统的pathList对象
            Object systemPathList = ReflectUtils.getPathList(pathClassLoader);


            //重新赋值系统的pathList属性值--修改的dexelements数组（新合成的)
            ReflectUtils.setField(systemPathList,systemPathList.getClass(),dexElements);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }





































}
