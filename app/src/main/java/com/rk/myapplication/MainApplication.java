package com.rk.myapplication;

import android.app.Application;

import com.rk.mylibrary.services.AppConfig;
import com.rk.mylibrary.services.IBaseApp;

/**
 * @author orange
 * @time 2019-04-07 00:44
 */
public class MainApplication extends Application implements IBaseApp {

    private static Application sApplication;

    public static Application getApplication() {
        return sApplication;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializal(this);
    }

    @Override
    public void initializal(Application application) {


        for (String s : AppConfig.baseConfig) {
            try {
                //通过配置文件的Application的路径，实例化，并传递给对应模块
                Class<?> clazz = Class.forName(s);
                Object o = clazz.newInstance();
                if (o instanceof IBaseApp) {
                    ((IBaseApp)o).initializal(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
