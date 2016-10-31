package com.adelmo.hadoop.file;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by znb on 16-10-31.
 * 从hadoop中读取数据
 */
public class URLCat {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) throws Exception {
        InputStream inputStream = null;
        String inputPath = "hdfs://localhost:9000/input/second.txt";
        try {
            inputStream = new URL(inputPath).openStream();
            IOUtils.copyBytes(inputStream,System.out,4096,false);
        } finally {
            IOUtils.closeStream(inputStream);
        }
    }
}
