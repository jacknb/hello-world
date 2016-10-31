package com.adelmo.hadoop.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by znb on 16-10-31.
 */
public class FileSystemCat {
    public static void main(String[] args) throws IOException {
        String uri = "hdfs://localhost:9000/input/test1.txt";
        Configuration conf = new Configuration();
        fileSystemCat(uri, conf);
        System.out.println("======================");
        fileSystemDoubleCat(uri, conf);
    }

    /**
     * 输出文本文件
     *
     * @param uri
     * @param conf
     * @throws IOException
     */
    private static void fileSystemCat(String uri, Configuration conf) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        InputStream in = null;
        try {
            in = fs.open(new Path(uri));
            IOUtils.copyBytes(in, System.out, 4096, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(in);
        }
    }

    /**
     * 读取文件，标准输出2次
     *
     * @param uri
     * @param conf
     * @throws IOException
     */
    public static void fileSystemDoubleCat(String uri, Configuration conf) throws IOException {
        FileSystem fileSystem = FileSystem.get(URI.create(uri), conf);
        FSDataInputStream in = null;
        try {
            in = fileSystem.open(new Path(uri));
            IOUtils.copyBytes(in, System.out, 4096, false);
            in.seek(0);//返回文件起点
            IOUtils.copyBytes(in, System.out, 4096, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
