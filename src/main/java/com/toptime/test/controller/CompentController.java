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
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.font.FontSet;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
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


    @RequestMapping("/table")
    public void createPdfTable(HttpServletResponse response){

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

            document.add(new Paragraph("测试1w").setTextAlignment(TextAlignment.CENTER).setFont(font).setBold().setFontSize(12).setMarginTop(100));
            document.add(new Paragraph("  测试1w").setFont(font).setBold().setFontSize(12).setMarginTop(100));
            document.add(new Paragraph("测试1w").setFont(font).setBold().setFontSize(12).setMarginTop(100));

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
