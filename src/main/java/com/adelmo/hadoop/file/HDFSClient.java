package com.adelmo.hadoop.file;

import org.apache.commons.lang.Validate;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by znb on 16-11-23.
 * HDFS基本操作
 */
public class HDFSClient {
    public HDFSClient() {

    }

    private static final String basePath = "/usr/local/hadoop2.7/etc/hadoop/";

    /**
     * 往hadoop上写数据
     *
     * @param source 本地文件路径
     * @param dest   hdfs文件路径
     * @throws IOException
     */
    public static void addFile(String source, String dest) throws Exception {
        Validate.notEmpty(source, "文件路径不能为空！");
        Configuration conf = new Configuration();
        //读取HDFS配置参数
        conf.addResource(new Path(basePath + "core-site.xml"));
        conf.addResource(new Path(basePath + "hdfs-site.xml"));
        FileSystem fileSystem = FileSystem.get(new URI(source), conf);
        //从文件路径中读取文件名
        String filename = source.substring(source.lastIndexOf('/') + 1, source.length());
        //创建目标路径，包括文件名
        if (dest.charAt(dest.length() - 1) != '/') {
            dest = dest + "/" + filename;
        } else {
            dest = dest + filename;
        }

        //检查文件是否已存在
        Path path = new Path(dest);
        if (fileSystem.exists(path)) {
            System.out.println("File " + dest + " already exists");
            return;
        }

        //创建一个新文件并写入数据
        FSDataOutputStream out = fileSystem.create(path);
        InputStream in = new BufferedInputStream(new FileInputStream(new File(source)));
        byte[] bytes = new byte[1024];
        int numBytes = 0;
        while ((numBytes = in.read(bytes)) > 0) {
            out.write(bytes, 0, numBytes);
        }
        //关闭文件描述符
        in.close();
        out.close();
        fileSystem.close();
    }

    /**
     * 从hdfs中读取文件
     *
     * @param file
     * @throws IOException
     */
    public static void readFile(String file) throws Exception {
        Validate.notEmpty(file, "file path is null!");
        Configuration conf = new Configuration();
        conf.addResource(new Path(basePath + "core-site.xml"));
        FileSystem fileSystem = FileSystem.get(new URI(file), conf);
        Path path = new Path(file);
        if (!fileSystem.exists(path)) {
            System.out.println("File " + file + " does not exist!");
            return;
        }
        FSDataInputStream in = fileSystem.open(path);
        String filename = file.substring(file.lastIndexOf('/') + 1, file.length());
        System.out.println(filename);
        OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filename)));
        byte[] bytes = new byte[1024];
        int numBytes = 0;
        while ((numBytes = in.read(bytes)) > 0) {
            out.write(bytes, 0, numBytes);
        }
        in.close();
        out.close();
        fileSystem.close();
    }

    /**
     * 从hdfs中删除一个文件
     *
     * @param file
     * @throws IOException
     */
    public static void deleteFile(String file) throws Exception {
        Validate.notEmpty(file, "file is null!");
        Configuration conf = new Configuration();
        conf.addResource(new Path(basePath + "core-site.xml"));
        FileSystem fileSystem = FileSystem.get(new URI(file), conf);
        Path path = new Path(file);
        while (!fileSystem.exists(path)) {
            System.out.println("File " + file + " does not exists");
            return;
        }
        fileSystem.delete(new Path(file), true);
        fileSystem.close();
    }

    /**
     * 创建一个文件
     *
     * @param dir
     * @throws IOException
     */
    public static void mkdir(String dir) throws IOException {
        Validate.notEmpty(dir, "dir is null!");
        Configuration conf = new Configuration();
        conf.addResource(new Path(basePath + "core-site.xml"));
        FileSystem fileSystem = FileSystem.get(conf);
        Path path = new Path(dir);
        while (fileSystem.exists(path)) {
            System.out.println("Dir " + dir + " already exist");
            return;
        }
        fileSystem.mkdirs(path);
        fileSystem.close();
    }

    public static void main(String[] args) throws Exception {
        String localPath = "/home/znb/java/eimhecomlinux.pdf";
        String hdfsPath = "hdfs://localhost:9000/test/";
        String readPath = "hdfs://localhost:9000/input/test1.txt";
//        mkdir(hdfsPath);
//        addFile(localPath, hdfsPath);
//        readFile(readPath);
        deleteFile(hdfsPath);
        System.out.println("Done!");
    }
}
