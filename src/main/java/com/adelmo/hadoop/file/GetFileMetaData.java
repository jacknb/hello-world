package com.adelmo.hadoop.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.sql.Timestamp;

/**
 * Created by znb on 16-11-17.
 * 得到HDFS的元信息
 */
public class GetFileMetaData {
    public static void main(String[] args) throws IOException {
        String str = "hdfs://localhost:9000/input/hadoop-2.7.1.tar.gz";
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(URI.create(str), conf);
        Path fPath = new Path(str);
        FileStatus fileStatus = hdfs.getFileStatus(fPath);
        if (fileStatus.isDirectory() == false) {
            System.out.println("This is directory");
        }
        System.out.println("文件路径：" + fileStatus.getPath());
        System.out.println("文件长度：" + fileStatus.getLen());
        System.out.println("文件块大小：" + fileStatus.getBlockSize());
        System.out.println("文件的副本数：" + fileStatus.getReplication());
        System.out.println("文件所有者：" + fileStatus.getOwner());
        System.out.println("文件所在的组群为：" + fileStatus.getGroup());
        System.out.println("文件权限：" + fileStatus.getPermission());
        System.out.println("最后访问时间：" + new Timestamp(fileStatus.getAccessTime()).toString());
        System.out.println("最后修改时间：" + new Timestamp(fileStatus.getModificationTime()).toString());
    }
}
