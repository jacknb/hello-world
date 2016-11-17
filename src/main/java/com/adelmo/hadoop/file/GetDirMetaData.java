package com.adelmo.hadoop.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;
import java.sql.Timestamp;

/**
 * Created by znb on 16-11-17.
 */
public class GetDirMetaData {
    public static void main(String[] args) throws Exception {
        String str = "hdfs://localhost:9000/input/";
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI(str), conf);
        Path path = new Path(str);
        FileStatus fileStatus = fileSystem.getFileStatus(path);
        if (fileStatus.isDirectory()) {
            System.out.println("这是一个文件目录，目录下所有文件有：");
            for (FileStatus fs : fileSystem.listStatus(path)) {
                System.out.println((fs.isDirectory() ? "D" : "-")
                        + fs.getPermission() + " " + fs.getOwner()
                        + " " + fs.getGroup() + " " + fs.getLen()
                        + " " + new Timestamp(fs.getModificationTime()).toString() + " "
                        + fs.getPath());
            }
        }
    }
}
