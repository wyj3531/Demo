package com.rk.trinkedemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] perms={Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (checkSelfPermission(perms[0])== PackageManager.PERMISSION_DENIED) {
                requestPermissions(perms,200);
            }
        }
    }

    public void jumTo(View view) {
        Intent intent = new Intent(MainActivity.this, SecActivity.class);
        startActivity(intent);
    }
}
