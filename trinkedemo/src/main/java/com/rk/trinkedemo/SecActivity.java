package com.rk.trinkedemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.rk.library.FixDexUtils;
import com.rk.library.utils.Constants;
import com.rk.library.utils.FileUtils;

import java.io.File;
import java.io.IOException;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

    }

    public void show(View view) {
        ParamSort paramSort=new ParamSort();
        paramSort.math(this);
    }

    public void fix(View view) {
        //:通过接口服务器下载修复好的dex文件。
        //:将文件放到sdCard
        File sourceFile=new File(Environment.getExternalStorageDirectory(), Constants.DEX_NAME);
        File targetFile=new File(getDir(Constants.DEX_DIR,
                Context.MODE_PRIVATE).getAbsolutePath()+File.separator+Constants.DEX_NAME);

        //如果存在则先删除，清理之前修复过的
        if (targetFile.exists()) {
            targetFile.delete();
            Toast.makeText(this, "删除嘞 ", Toast.LENGTH_SHORT).show();
        }
        //复制过程
        try {
            FileUtils.copyFile(sourceFile,targetFile);
            Toast.makeText(this, "复制dex完成 ", Toast.LENGTH_SHORT).show();
             FixDexUtils.loadFixedDex(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
