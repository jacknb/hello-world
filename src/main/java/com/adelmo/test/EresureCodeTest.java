package com.adelmo.test;

import com.xiaomi.infra.ec.ErasureCodec;

import java.io.*;

/**
 * Created by znb on 17-4-21.
 */
public class EresureCodeTest {

    public static void main(String[] args) {

        int k = 8;
        int m = 2;
        int size = 32;

        //初始文件路径
        String inputPath = "/home/znb/aaa.docx";

        ErasureCodec erasureCodec = new ErasureCodec.Builder(ErasureCodec.Algorithm.Cauchy_Reed_Solomon)
                .dataBlockNum(4)
                .codingBlockNum(2)
                .wordSize(8)
                .build();

        //读取文件
        File file = new File(inputPath);
        try {
            InputStream inputStream = new FileInputStream(file);

            //Generate Data
            byte[][] data = new byte[k][size];

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int n = 0;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
