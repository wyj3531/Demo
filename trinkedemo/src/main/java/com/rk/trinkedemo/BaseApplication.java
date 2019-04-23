package com.rk.trinkedemo;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.rk.library.FixDexUtils;

/**
 * @author orange
 * @time 2019-04-21 10:53
 */
public class BaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        FixDexUtils.loadFixedDex(this);
    }
}
