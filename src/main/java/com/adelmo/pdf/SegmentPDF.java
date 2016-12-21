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
        String inputPath = "G:\\论文\\References\\other\\";
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
