package com.adelmo.pdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/12/20.
 * 创建pdf
 */
public class JavaPdfHelloWorld {
    public static void main(String[] args) {

        try {
            PDFSplitUtil.splitPDFByPages("G:\\znb\\计算机文档\\疯狂HTML5CSS3JavaScript讲义\\疯狂HTML5CSS3JavaScript讲义.pdf", "G://aaa/", 1);
//            PDFSplitUtil.splitPDF(new FileInputStream("G://论文/References/chinese/RAID技术发展综述.pdf"), new FileOutputStream("G://aaa/b.pdf"), 1, 1);
//            PDFSplitUtil.splitPdfPages("G://论文/References/chinese/RAID技术发展综述.pdf", "D://aaa.pdf", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
