package com.rk.minecomponent;

import android.app.Application;

import com.rk.mylibrary.services.IBaseApp;
import com.rk.mylibrary.services.ServiceFactory;

/**
 * @author orange
 * @time 2019-04-07 00:43
 */
public class MineApplication extends Application implements IBaseApp {


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
     sApplication=application;
        ServiceFactory.getInstancce().setIMineService(new MineServices());
    }
}