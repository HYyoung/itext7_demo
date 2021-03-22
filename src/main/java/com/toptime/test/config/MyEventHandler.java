package com.toptime.test.config;


import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.IOException;

//https://kb.itextpdf.com/home/it7kb/ebooks/itext-7-jump-start-tutorial-for-java/chapter-3-using-renderers-and-event-handlers
public class MyEventHandler implements IEventHandler {
    public void handleEvent(Event event) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
        PdfDocument pdfDoc = docEvent.getDocument();
        PdfPage page = docEvent.getPage();
        int pageNumber = pdfDoc.getPageNumber(page);
        Rectangle pageSize = page.getPageSize();
        PdfCanvas pdfCanvas = new PdfCanvas(
            page.newContentStreamBefore(), page.getResources(), pdfDoc);

        ///////////////////////////设置背景色//////////////////Set background
        Color limeColor = new DeviceCmyk(0.208f, 0, 0.584f, 0);
        Color blueColor = new DeviceCmyk(0.445f, 0.0546f, 0, 0.0667f);
        pdfCanvas.saveState()
                .setFillColor(pageNumber % 2 == 1 ? limeColor : blueColor)
                .rectangle(pageSize.getLeft(), pageSize.getBottom(),
                    pageSize.getWidth(), pageSize.getHeight())
                .fill().restoreState();
        //Add header and footer
        PdfFont font =null;
        try {
             font = PdfFontFactory.createFont("C:/Windows/Fonts/simhei.ttf", PdfEncodings.IDENTITY_H,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ////////////////添加页码//////////
        pdfCanvas.beginText()
                .setFontAndSize(font, 9)
                .moveText(pageSize.getWidth() - 120, pageSize.getTop() - 20)//上方居右
                .showText("THE TRUTH IS OUT THERE11")

                //划线 As you can see, I add two green lines using moveTo(), lineTo() and stroke().
                .setStrokeColor(ColorConstants.GREEN).
                setLineWidth(1).
                moveTo(30, pageSize.getTop()-25).
                lineTo(pageSize.getWidth()-30, pageSize.getTop()-25).
                stroke()
                //////////////////
                .moveText(120-pageSize.getWidth()/2, -pageSize.getTop() + 30)//下方居中
                .showText(String.valueOf(pageNumber))
                .endText();
        ////////////添加水印//////////////////////Add watermark
        Canvas canvas = new Canvas(pdfCanvas, pdfDoc, page.getPageSize());
        canvas.setFontColor(new DeviceRgb(java.awt.Color.red));
        UnitValue fontSizeAsUV = UnitValue.createPointValue(60f);
        canvas.setProperty(Property.FONT_SIZE,fontSizeAsUV);
        canvas.setProperty(Property.FONT, font);
        canvas.showTextAligned(new Paragraph("这是一个测试的水印"),
            298, 421, pdfDoc.getPageNumber(page),
            TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);
        ///////////////////////////////////////////////////////////////
        pdfCanvas.release();
    }
}
