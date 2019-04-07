package com.rk.mylibrary.services;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

/**
 * @author orange
 * @time 2019-04-07 01:38
 */
public class EmptyService implements ILoginService {
    @Override
    public void lanuch(Context context, String targetClass) {

    }

    @Override
    public Fragment newUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle) {
        return null;
    }
}
