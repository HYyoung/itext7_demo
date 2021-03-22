package com.toptime.test.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.font.FontSet;
import com.itextpdf.layout.property.*;
import com.toptime.test.config.MyEventHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * @Classname CompentController
 * @Description TODO
 * @Date 2021/3/16 19:46
 * @Created by HY
 */
@RestController
@RequestMapping("/compent")
public class CompentController {


    @RequestMapping("/text")
    public void createPdfTable(HttpServletResponse response){

        PdfWriter writer = null;
        try {
            writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new MyEventHandler());
            //默认页面大小为A4
            Document document = new Document(pdf);
            //设置页面边距
            document.setMargins(50, 20, 20, 20);
            //设置字体
            PdfFont font =  PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);

            document.add(new Paragraph("测试1w").setTextAlignment(TextAlignment.CENTER).setFont(font).setBold().setFontSize(12).setMarginTop(100));
            document.add(new Paragraph("  测试1w").setFont(font).setBold().setFontSize(12).setMarginTop(100));
            document.add(new Paragraph("测试1w").setFont(font).setBold().setFontSize(12).setMarginTop(100));

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/brank")
    public void TestBrank(HttpServletResponse response){
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new MyEventHandler());
            //默认页面大小为A4
            Document document = new Document(pdf);
            //设置页面边距
            document.setMargins(20, 20, 20, 20);
            //设置字体
            PdfFont font =  PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
            document.add(new Paragraph("这是一段测试模拟的数据").setFont(font).setFontSize(12));
            String text="  测试1w  你好 好的";
            String trim = text.trim();
            String[] split = trim.split("  ");
            if (split != null && split.length>0){
                for (int i = 0; i < split.length; i++) {
                    document.add(new Paragraph(split[i]).setFont(font).setFontSize(12).setFirstLineIndent(24f));
                }

            }

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/ttc")
    public void TestTTC(HttpServletResponse response){
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new MyEventHandler());
            //默认页面大小为A4
            Document document = new Document(pdf);
            //设置页面边距
            document.setMargins(20, 20, 20, 20);
            //设置字体


            PdfFont font = PdfFontFactory.createFont("C:/Windows/Fonts/simsun.ttc,0", PdfEncodings.IDENTITY_H,true);


            document.add(new Paragraph("这是一段测试模拟的数据").setFont(font).setFontSize(12));



            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 合并单元格
     * @param response
     */
    @RequestMapping("/table")
    public void TestTable(HttpServletResponse response){
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new MyEventHandler());

            //默认页面大小为A4
            Document document = new Document(pdf);
            //设置页面边距
            document.setMargins(50, 50, 20, 20);
            //设置字体


            PdfFont font = PdfFontFactory.createFont("C:/Windows/Fonts/simsun.ttc,0", PdfEncodings.IDENTITY_H,true);

            Table table = new Table(new float[]{4, 6});
            table.setWidth(UnitValue.createPercentValue(100))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);//上下左右居中
            //表头
            table.addHeaderCell(new Cell().add(new Paragraph("分类").setFont(font)).setBackgroundColor(new DeviceRgb(Color.red)));
            table.addHeaderCell(new Cell().add(new Paragraph("搜索词").setFont(font)));

            ///正文 会根据表头信息自动换行
            //表中表
            Table tableChildren = new Table(1);
            tableChildren.setWidth(UnitValue.createPercentValue(100))
//                    .setBorder(Border.NO_BORDER)
//                    .setBorderLeft(Border.NO_BORDER)
//                    .setBorderTop(Border.NO_BORDER)
//                    .setBorderRight(Border.NO_BORDER)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);//上下左右居中

            for (int i = 0; i < 5; i++) {
                Cell cell = new Cell()
                        .add(new Paragraph(i + ":(5)").setFont(font))
                        .setBorderLeft(Border.NO_BORDER)
                        .setBorderRight(Border.NO_BORDER);
                if (i== 0) cell.setBorderTop(Border.NO_BORDER);

                if (i== 4) cell.setBorderBottom(Border.NO_BORDER);
                tableChildren.addCell(cell);
            }
            table.addCell(new Cell().add(new Paragraph("分类1").setFont(font)).setVerticalAlignment(VerticalAlignment.MIDDLE));
            table.addCell(tableChildren);



            document.add(table);


            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void tableAddHref(){
        Table table = new Table(1);
        Paragraph paragraph = new Paragraph();
        Link chunk = new Link("European Business Awards",
                PdfAction.createURI("https://itextpdf.com/en/events/itext-european-business-awards-gala-milan"));
        paragraph.add(chunk);
        table.addCell(paragraph);
    }

}
