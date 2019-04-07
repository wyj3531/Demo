package com.rk.logincomponent;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.rk.mylibrary.services.ILoginService;

/**
 * @author orange
 * @time 2019-04-07 00:09
 */
public class LoginService implements ILoginService {


    @Override
    public void lanuch(Context context, String targetClass) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);

    }

    @Override
    public Fragment newUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle) {
        UserInfoFragment fragment = new UserInfoFragment();
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().add(viewId, fragment).commit();
        return null;
    }
}
