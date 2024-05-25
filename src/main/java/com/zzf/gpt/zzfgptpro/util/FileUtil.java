package com.zzf.gpt.zzfgptpro.util;

import java.io.*;

public class FileUtil {

    public static boolean save2File(String fileName, byte[] msg) {
        OutputStream fos = null;
        try {
            File file = new File(fileName);
            File parentFile = file.getParentFile();
            boolean bool;
            if ((!parentFile.exists() && (!parentFile.mkdir()))){
                return false;
            }
            fos = new FileOutputStream(file);
            fos.write(msg);
            fos.flush();
            return true;
        } catch (FileNotFoundException e){
            return false;
        } catch (IOException e){
            return false;
        } finally {
            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
