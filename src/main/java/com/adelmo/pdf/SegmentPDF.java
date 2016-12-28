package com.adelmo.pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 * 创建pdf
 */
public class SegmentPDF {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\Administrator\\Desktop\\2016年湖南第二届研究生数模竞赛获证书扫描.pdf";
        String outputPath = "G:\\aaa\\";
        List<String> lists = new ArrayList<String>();

        //先判断输出文件夹是否存在
        PrintFileUtil.createDir(outputPath);

        PrintFileUtil.printSpecificFileName(inputPath, ".pdf", lists);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }

        PDFSplitUtil.splitPDFList(inputPath,outputPath,1);
    }
}
