package com.neil.algorithm;

import com.sun.istack.internal.NotNull;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here
        File file = new File("D:\\log\\");
        System.out.println(existFile(file, "log_enable.xml"));
    }

    public static boolean existFile(@NotNull File f, String fileName) {
        if (!f.isDirectory() || f.listFiles().length <= 0) {
            return false;
        }
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                if(file.getName().equals(fileName)) {
                    return true;
                }
            } else {
                return existFile(file, fileName);
            }
        }
        return false;
    }
}
