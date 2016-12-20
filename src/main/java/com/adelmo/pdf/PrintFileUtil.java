package com.adelmo.pdf;

import org.apache.commons.lang.Validate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public class PrintFileUtil {

    /**
     * 打印特定的文件
     *
     * @param path     文件路径
     * @param specific 文件后缀
     * @param fileList 文件列表
     */
    protected static void printSpecificFileName(String path, String specific, List<String> fileList) {
        Validate.notNull(path, "path is null");
        Validate.notNull(specific, "specific is null");

        if (null != path) {
            File file = new File(path);
            if (file.exists() && file.isDirectory()) {
                File[] files = file.listFiles();
                if (null != files) {
                    for (File child : files) {
                        if (child.isFile() && child.getName().endsWith(specific)) {
                            //得到绝对地址
                            fileList.add(child.getAbsolutePath());
                        } else if (child.isDirectory()) {
                            //循环遍历文件
                            printSpecificFileName(child.getAbsolutePath(), specific, fileList);
                        }
                    }
                }
            } else if (file.getName().endsWith(specific)) {
                //文件
                fileList.add(file.getAbsolutePath());
            }
        }
    }

    /**
     * 创建文件夹/文件
     *
     * @param outputPath
     * @throws IOException
     */
    protected static void createDir(String outputPath) throws IOException {
        //如果是文件夹
        File outputFile = new File(outputPath);
        if (!outputFile.exists()) {
            outputFile.mkdirs();
        }
    }

    /**
     * 读取某个文件夹下的所有文件
     */
    public static boolean readFile(String filePath) throws IOException {
        try {

            File file = new File(filePath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filePath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath="
                                + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());

                    } else if (readfile.isDirectory()) {
                        readFile(filePath + "\\" + filelist[i]);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }

    private static List<String> fileList = new ArrayList<String>();

    public static void printAllFileNames(String path) {
        if (null != path) {
            File file = new File(path);
            if (file.exists()) {
                File[] list = file.listFiles();
                if (null != list) {
                    for (File child : list) {
                        if (child.isFile() && child.getName().endsWith(".pdf")) {
                            fileList.add(child.getAbsolutePath());
                            System.out.println(child.getAbsolutePath());
                        } else if (child.isDirectory()) {
                            printAllFileNames(child.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}
