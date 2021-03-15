package com.toptime.test.controller;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.colorspace.PdfDeviceCs;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.Background;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;

/**
 * @Classname ITextController
 * @Description TODO
 * @Date 2021/3/15 20:19
 * @Created by HY
 */
@RestController
@RequestMapping("/createPdf")
public class ITextController {

    /**
     * 测试
     * @return
     */
    @RequestMapping("/hello")
    public String helloWord(){
        return "hello word!";
    }

    /**
     * 创建 pdf 入门
     * @param response
     */
    @RequestMapping("/pdf")
    public void createPdf(HttpServletResponse response){

        PdfWriter writer = null;
        try {
            writer = new PdfWriter(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Hello World!"));
        document.close();
    }

    @RequestMapping("/font")
    public void createPdfFont(HttpServletResponse response){

        PdfWriter writer = null;
        try {
            writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            //默认页面大小为A4
            Document document = new Document(pdf);
            // Create a PdfFont
            PdfFont font = PdfFontFactory.createFont("C:/Windows/Fonts/simhei.ttf", PdfEncodings.IDENTITY_H,true);

            // Add a Paragraph
            document.add(new Paragraph("iText is:").setFont(font));
            document.add(new Paragraph("这是中文!").setFont(font));
            System.out.println("-----");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @RequestMapping("/img")
    public void createPdfImg(HttpServletResponse response){

        PdfWriter writer = null;
        try {
            writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            //默认页面大小为A4
            Document document = new Document(pdf);
           document.add(new Image(ImageDataFactory.create("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png")));
            System.out.println("---img--");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/table")
    public void createPdfTable(HttpServletResponse response){

        PdfWriter writer = null;
        try {
            writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            //默认页面大小为A4
            Document document = new Document(pdf);
            //设置页面边距
            document.setMargins(20, 20, 20, 20);
            //设置字体
            PdfFont font = PdfFontFactory.createFont("C:/Windows/Fonts/simhei.ttf", PdfEncodings.IDENTITY_H,true);
            //创建表格对象 我们Table通过定义一个float包含7个元素的数组（第7行）来为该对象定义7个列
            Table table = new Table(new float[]{4, 1, 3, 4, 3, 3, 3});
            table.setWidth(UnitValue.createPercentValue(100))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);//上下左右居中
            //表头
            table.addHeaderCell(new Cell().add(new Paragraph("字段1").setFont(font)).setBackgroundColor(new DeviceRgb(Color.red)));
            table.addHeaderCell(new Cell().add(new Paragraph("字段2").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("字段3").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("字段4").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("字段5").setFont(font)).setBackgroundColor(new DeviceRgb(Color.red)));
            table.addHeaderCell(new Cell().add(new Paragraph("字段6").setFont(font)));
            table.addHeaderCell(new Cell().add(new Paragraph("字段7").setFont(font)));
            ///正文 会根据表头信息自动换行
            table.addCell(new Cell().add(new Paragraph("1").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("2").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("3").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("4").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("5").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("6").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("7").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("8").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("9").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("10").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("11").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("12").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("13").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("14").setFont(font)));
            for (int i = 0; i < 280; i++) {
                table.addCell(new Cell().add(new Paragraph(i+15+"行").setFont(font)));
            }


            System.out.println("---table--");
            document.add(table);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
