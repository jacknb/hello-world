package com.adelmo.hadoop.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * Created by znb on 16-11-1.
 * 将本地文件复制到Hadoop文件系统
 */
public class FileCopyWithProcess {
    public static void main(String[] args) throws Exception {
        String localStr = "/home/znb/java/test.txt";
        String hdfStr = "hdfs://localhost:9000/input/test.txt";//需要指定文件名
        InputStream in = new BufferedInputStream(new FileInputStream(localStr));

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(hdfStr), conf);

        OutputStream out = fs.create(new Path(hdfStr), new Progressable() {
            public void progress() {
                System.out.print(".");
            }
        });

        IOUtils.copyBytes(in, out, 4096, true);
    }
}
