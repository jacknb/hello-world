package com.adelmo.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.*;
import org.apache.commons.lang.Validate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public class PDFSplitUtil {

    /**
     * 批量按页拆分pdf
     *
     * @param inputPath
     * @param outputPath
     * @param fromPage
     */
    protected static void splitPDFList(String inputPath, String outputPath, int fromPage) {
        Validate.notNull(inputPath, "inputPath is null");
        Validate.notNull(outputPath, "outputPath is null");

        //获取路径下的所有文件
        List<String> pdfNames = new ArrayList<String>();
        PrintFileUtil.printSpecificFileName(inputPath, ".pdf", pdfNames);
        for (int i = 0; i < pdfNames.size(); i++) {
            splitPDF(pdfNames.get(i), outputPath, fromPage);
        }
    }

    /**
     * 按页拆分pdf
     *
     * @param inputPath
     * @param outputPath
     * @param fromPage
     */
    private static void splitPDF(String inputPath, String outputPath, int fromPage) {
        Document document = new Document();
        try {
            File file = new File(inputPath);
            FileOutputStream fileOutputStream = null;
            PdfWriter pdfWriter;
            PdfImportedPage pdfImportedPage;
            PdfContentByte pdfContentByte;

            PdfReader pdfReader = new PdfReader(inputPath);

            /*//当文件较大的时候会报异常
            FileInputStream fileInputStream = new FileInputStream(file);
            PdfReader pdfReader = new PdfReader(fileInputStream);*/

            //得到pdf的总页数
            int totalPage = pdfReader.getNumberOfPages();
            if (fromPage > totalPage) {
                fromPage = totalPage;
            }
            for (int i = 1; i <= totalPage; i++) {

                fileOutputStream = new FileOutputStream(outputPath + file.getName().split("\\.")[0] + "_" + i + ".pdf");

                //Create a writer for the OutputStream
                pdfWriter = PdfWriter.getInstance(document, fileOutputStream);
                document.open();

                //Holds the data
                pdfContentByte = pdfWriter.getDirectContent();
                document.newPage();
                pdfImportedPage = pdfWriter.getImportedPage(pdfReader, i);
                pdfContentByte.addTemplate(pdfImportedPage, 0, 0);

                fileOutputStream.flush();
                document.close();
            }
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }

    /**
     * 按页拆分pdf
     *
     * @param inputStream
     * @param outputStream
     * @param fromPage
     * @param toPage
     */
    public static void splitPDF(InputStream inputStream, OutputStream outputStream, int fromPage, int toPage) {
        Validate.notNull(fromPage, "fromPage is null");
        Validate.notNull(toPage, "toPage is null");
        Document document = new Document();

        try {
            PdfReader pdfReader = new PdfReader(inputStream);

            //得到pdf的总页数
            int totalPage = pdfReader.getNumberOfPages();
            if (fromPage > toPage) {
                fromPage = toPage;
            }
            if (fromPage > totalPage) {
                fromPage = totalPage;
            }
            //Create a writer for the Outputstream
            PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
            document.open();

            //Holds the data
            PdfContentByte pdfContentByte = pdfWriter.getDirectContent();
            PdfImportedPage pdfImportedPage;
            while (fromPage <= toPage) {
                document.newPage();
                pdfImportedPage = pdfWriter.getImportedPage(pdfReader, fromPage);
                pdfContentByte.addTemplate(pdfImportedPage, 0, 0);
                fromPage++;
            }

            outputStream.flush();
            document.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
        try {
            if (outputStream != null)
                outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按页切分PDF
     *
     * @param filePath
     * @param outputPath
     * @param startPage
     */
    public static void splitPdfPages(String filePath, String outputPath, int startPage) {
        Validate.notNull(filePath, "filePath is not null");
        Validate.notNull(outputPath, "outputPath is not null");

        Document document = null;
        PdfReader pdfReader = null;
        PdfCopy pdfCopy = null;

        try {
            pdfReader = new PdfReader(filePath);
            int totalPage = pdfReader.getNumberOfPages();
            if (totalPage == 0) {
                return;
            }

            document = new Document(pdfReader.getPageSize(1));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(outputPath)));
            pdfCopy = new PdfCopy(document, bufferedOutputStream);
            document.open();
            pdfCopy.open();
            for (int i = startPage; i <= totalPage; i++) {
                document.newPage();
                PdfImportedPage pdfImportedPage = pdfCopy.getImportedPage(pdfReader, i);
                pdfCopy.addPage(pdfImportedPage);
                pdfCopy.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen() && document != null) {
                document.close();
            }
            if (pdfCopy != null) {
                pdfCopy.close();
            }
            if (pdfReader != null) {
                pdfReader.close();
            }
        }
    }
}
