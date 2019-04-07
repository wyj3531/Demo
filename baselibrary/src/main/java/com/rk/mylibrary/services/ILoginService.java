package com.rk.mylibrary.services;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

/**
 * @author orange
 * @time 2019-04-07 00:04
 */
public interface ILoginService {

    void lanuch(Context context,String targetClass);

    Fragment newUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle);
}
