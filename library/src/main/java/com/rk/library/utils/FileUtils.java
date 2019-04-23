package com.rk.library.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author orange
 * @time 2019-04-22 23:51
 */
public class FileUtils {

    public static void copyFile(File sourceFile,File targetFile) throws IOException {
        FileInputStream inputStream=new FileInputStream(sourceFile);

        BufferedInputStream inBuff=new BufferedInputStream(inputStream);


        FileOutputStream outputStream=new FileOutputStream(targetFile);
        BufferedOutputStream outBuff=new BufferedOutputStream(outputStream);

        byte[] b = new byte[1024 * 5];
        int len;
        while ((len=inBuff.read(b))!=-1) {

            outBuff.write(b,0,len);
        }
        outBuff.flush();
        inBuff.close();
        outBuff.close();
        inputStream.close();
    }
}
