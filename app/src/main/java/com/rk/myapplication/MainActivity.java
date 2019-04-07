package com.rk.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rk.mylibrary.services.ServiceFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toLogin(View view) {
        ServiceFactory.getInstancce().
                getILoginService().lanuch(MainActivity.this, "");
    }

    public void toMine(View view) {
        ServiceFactory.getInstancce().getIMineService()
                .lanuch(MainActivity.this, 12);
    }

    public void toShowFragemnt(View view) {
        Bundle bundle = new Bundle();
        ServiceFactory.getInstancce().getILoginService()
                .newUserInfoFragment(getSupportFragmentManager(),R.id.container,bundle);

    }
}
