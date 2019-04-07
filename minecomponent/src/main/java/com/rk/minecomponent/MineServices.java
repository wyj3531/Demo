package com.rk.minecomponent;

import android.content.Context;
import android.content.Intent;

import com.rk.mylibrary.services.IMineService;

/**
 * @author orange
 * @time 2019-04-07 00:09
 */
public class MineServices implements IMineService {
    @Override
    public void lanuch(Context context, int userId) {

        Intent intent=new Intent(context,MainActivity.class);
        intent.putExtra("id",userId);
        context.startActivity(intent);
    }
}
