package com.toptime.test.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.codec.Base64;
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
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.font.FontSet;
import com.itextpdf.layout.property.*;
import org.omg.CORBA.IMP_LIMIT;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

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
            Image image = new Image(ImageDataFactory.create("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png"));
            image.setWidth(520);
            image.setHeight(260);
            document.add(image);
            //bases 64
           document.add(new Image(ImageDataFactory.create(Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAfQAAAH0CAYAAADL1t+KAAAgAElEQVR4nOzdd3QU1d8G8Gdm+6Z3egLSa+i9qAgIKoKIBcRef4ry2htixd4LNkTE3huCgqL03mvonfRks73M+8dCSMhu2M3O7iaT53OOR0iyd24C7DP3zr3fK0iSJIGIiIjqNDHaHSAiIqLQMdCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAEY6ERERArAQCciIlIABjoREZECMNCJiIgUgIFORESkAAx0IiIiBWCgExERKQADnYiISAHU0e4AUV1iM5thKTPBWmaCtawMokoFncEAncEAjU4Pnd4AfUxMtLtJRPUQA53Ih6P79mDnmlU4vHuX97+cHBQePwpJks76WpVGg8TUdKQ0bIiGWS3QpGVrtOraDS06dYFWp49A7+uf4rxcnDh4AHlHDiHv8GFYy0zlnxPVKiSlN0BG00ykNWmCjKaZUGu1UewtUXgIUiDvUET1wLZVK7B24Xys+3sBju3fK3v7Wr0BnfoPRL+LRqP3sJEMlRAUHDuKzcsWY9vKZdi6YjkKjh0J+LUarQ6tu/VAx74D0KFvf7Tu2j2MPSWKHAY61Wu5hw/h3++/xqLvvwkqFEIVk5CIwWPG4bzxE9CkVeuIXbcus1stWPHH7/j3h6+xfdWKgGZLApHWuAkGX3YFhlw2HqmNmsjSJlE0MNBJMcylJbBbrXBYrRBEEfqYGBhiY6tMczvsNqyaPxf/fPsVtq1cJlsw1FSfkRfj6vsfRXqTplHtR23lcjjw43tv4reZ78NusYTtOoIgoOuQ8zFu8r1o0bFz2K5DFC4MdKpzyoqLsHPdGuxcswr7t29F3uFDyD1yCG6n0+fXa/UGNMjMQnrTTOhjjFj39wJYTKUR7nX1NFodhk+6HmPvuAfGuLhod6fW2Ll2Nd5/5D4c3bs7otftMXQExk+5H81at43odYlCwUCnOqE4LxfL5/6C5XN/Rc76tVEfVYdLSsPGmPLW+2jZpWu0uxJVNrMZc154Ggu/mhO1P2tBEDDy+ptx1b0Pc70D1QkMdKrVdm9cj99mvo9V8+fC43ZHuzsRodJocPX9j2LU9TdHuytRsWbBfMx88lEUHj8W7a4AAJq1aYfJr73LtQ5U6zHQqVbau2UT5jz/FLatXB7trkRN7xGjcNcrb9eb0WFJQT5mTnsEK+f9Hu2uVKHR6nDDtGdx7uVXRbsrRH4x0KlWKSnIxxcvPov/fvxWsdPqwcgefB7ue/fjOhvqFpMJ+7ZuxvED+3DiwH7kHjkEU2EhrGUmmE2lkDweCKIIURBRmHs8rIve5DBi0o2Y9Og0iCKLbFLtw0CnWmPpbz9h1lOPw1RUGO2u1CqdBwzGfTNm1omiNBaTCZuW/IvNS//DrnVrcHj3LsXdmHUeMBh3vPg6Ck8cx76tm5F76CDKiotQVlIMjU4HvTEGSRkN0Kx1G2S268jdCxQxDHSKupKCfHz42INYs2BetLtSa7Xv3Rc3Pjkdjc9pFe2uVFFaWICV837H8rm/YMeaVfVmrUOgGrVoiZ4XjMDgy8ajUfNzot0dUjAGOkXVrvVr8dKt13FUHqBGLVqiU/+BaN+7H9r26IWElNSo9WXL8iWYN/sTrPvnL4Z4AARBQLfzLsDoW+9kdToKCwY6Rc2aBfPx5pT/wWGzRrsrdVZ602Zold0drbK9teJbdOgU9uftO9euxucvPoNd69aE9TpKJQgCBl56GSY8+HhUb8hIeRjoFBULvpqDmdMe4chOZiqNBi06dEK7nn3QeeBgtO3eS7aArw17w5UkJiERtz//KnoMHR7trpBCMNAp4v794Vu89+A90e5GvaAzGtHj/OEYOPoyZA8+t8btbFy8CB88+kBE693XF6NuuAUTHnycK+cpZAx0iqgda1bi6UlX+C3TSuGT3rQZRl53M4ZeOTGoUfs3r72IH959I4w9o17DLsTdb8yASs0TranmGOgUMScOHsBj4y7iArgoS2nYGNdPffqsU70uhwPvPfR/WPrrjxHqWf3WZdAQPPD+pwx1qjEGOkWE2+XCw5eOwMGd26PdFTpp0JhxuOnpF3zub7eYTHjp1muxffXKKPSs/ho0ZhzueJGzIVQzfGhDEfHrR+8xzGuZ/378Ds9MugIWk6nSx10OB8M8Sv778Tv8/ME70e4G1VEcoVPY5R4+hPsuPFdx29NiYj3o08+K7K42NGrsgsEgwWwWUVggYssmHVauMCD3RO2fPm3Xszcem/1N+VTva3fdUivrqZ9NXJwbLVs70SzTidhYD3Q6759Hfr4Ke/dosH+vBpIkRLubZ6XSaPDcD3OR2bZ9tLtCdQwDncJu+o0TsPG/RdHuhmxEUcLFl5Zh9Jgy6A3+//l4PMDa1Xp8OScex4/V7mAfPHY8bn/hNcx6eirmzf442t0JSsfOdlx0SRk6drajuoXixUUili424PdfY1FcpIpcB2ugeYdOmP4TKydScBjoFFZr//4LL916XbS7IZu4ODfufbAQrdsGvkrf7Qa+/SoOv/wYF8aehW7YxOvw55xZ0e5GwBIS3bjl9mJ07W4P6nUuJ/D9t3H4+Yfa/efxv5fexMBLL4t2N6gOYaBTWN0/8jwcytkZ7W7IIi7OjalPF6BxE1eNXr9qhR5vvZ4Et6v2T/vWdm3b2XHP/UWIj/fUuI3lS/WY8XYSnM7a+eeRkZmFNxYsjXY3qA5hoFPYrPjjN7w++dawXkMUJXTqbEd2Nzuat3AgPcMNY4z3Td5qFZGXq8KBfRps2qjDxvU6OBw1WwcqihKmPpUf1Mjcl7WrdXjlhZSQ2qjvuna3Ycp9hVBrQm9r314NnnkiBVZr7Vwf/Njsr9Gx74Bod4PqCAY6hc2jl43Cnk0bwtK20ejBiFFmjBhZhti4wP4K2+0CFv5lxNxfYlFYGNwz1CuuLsXosWXe36jTAVdusF0u99kn8fjj99gav74+y8xyYtqz+dDp5Hvb2rBeh5eeS66VC+YGjB6LO19+K9rdoDqidt6WUp23Z/PGsIV5l2wbXnkrF+OuMAUc5gCg00kYeZEZr7yVi0vGmCCKgb22SVMnLhp9MsxVyRDa7gB0bWvSdQDA2PEmGI01nyqurwRBwm13FnnDXN8ZQoOngPiLQm43u6sdV19TKkMP5bdp8b/R7gLVIQx0Cot/v/86LO1ePNqEBx8rREJCzQNRp5Nw5QQTpj6Vj8Sksx8Oc/PtxVCdHNALGVMB2zbAvqPG14+JkdB3gLK28EXCkPMsyMxyAfpsCC3/g5DxOMTmv0JouQQQQjuAZtQlZnTqYpOpp/IpLSzAgR3bot0NqiNq914aqrOWz/1V9jbHX1WKSy8rk6291m2dePaFPDz9RKrfbWW9+ljRqvXJ5+aaLCDlNkh7zgv52p0627Hwz5iQ26nt4uLc6NnHhvYdHMjMciIxyQ29XkJRoQp5eSrsydFgx3YdNm/UVbs4TRQljB3vLYAjNP0Igiqh/HNCTH9ISdcBhR+E1NdxV5iweWPVqnnRdmjXDu5Jp4Aw0El2O9eulr1e+7nnm2UN81OSkj144pl8PPFIqs8iMJdcevqaQqPngbK/AcuykK+bmqrsY2MzGrgwZpwJ/Qday2c3KkpNcyM1zY127R24aLQZNquAJf8Z8MtPscjPq/rn0DnbjpSUk7My2qwqnxe0WQj1qXqr1k40aerE4UPBrbbr2duKc4daAAA7tmkx7/eYGi++9OXont2ytUXKxil3kt3mZYtlba9RYyeuv6lE1jYrSkjw4L6HCmEwVJ7G79DRjhYtT47ODd2AhHGQjk8LWz+U4oLhZrzwai4GDfEd5r7oDRKGDrfg1TdzMeayqusbunWvMB1e8kOV10umuaF0uVzvvsE9CrlwVBmm3F+E7K52ZHe148oJJrz0eh4SEuW7YSspyJetLVI2BjrJbvuqFbK2d9NtJbJsUapOk6YuXDKm8gzABSPM5b8W0h8ByhYB1lWyXK+kpOb/9OLj3cjMciK7mw3Z3Wxo3KR2HEUrit5Fa9ffXIIgTmetRK0BLr/KhEenFSAu7nQoZrU4/T1KR+6ElP8OJHcRJNtOeA5eA5iXhNp9AMA5rQL/WaZnuHDFhKqL6dLS3bj8SpOPV9SMzWKRrS1SNk65k+z2btkoW1sdO9vRtp1DtvaqM/xCM377JRbmMhE6vQfZ3U6OCrUtgYRLIe0dKdu1du2smnhGowdJyW4kJXuQlOT2/jrJ+7HkFO/vExM9Pke9Obs0eOX5ZJSWRqekqSBImHJ/Ibr3DK5qmz/t2jvw1PR8PPl4KoqLVEjPqDDilRyQjtwJHLlTlmtV1Lhx4EWDbqjmxiU5Rb4Ruttds0JGVP8w0ElWBceOwlom37Pui0fLN9I5G71BwqDBFvzxeyy6dbeVv1kL6fd5V7aX/SnbtbKaO3HnPUVITXUhIdEb2jUd1QLe578PPlaIxx9KhccT+f3UN9xcIluYn5LRwI2pT+Xj8YfTYDREZpvfqaJEZ9O3vwWds/1/v8sWG+TqEoyxtbtELdUenHInWR0/sF+2tuLj3ejQycfoPHYohNbrIHQshpD5VUh7ws80cIh3erNXn5Ojc3U6kDQJUv6bsl0DAHr3taHfACtat3Uio0FoYX5K8xZO9OgV+a1XffpZcf6w8EwLN2joxt33ylMVTi5GoweTbvC/b33fXg2WLZEv0GMTEmVri5SNgU6yKso9LltbXbr6OD1Lnw2hxVwIhq4QVAkQEq+A0HodECNPecys5i7Ex7vRpq33RkJIuQOAByj6Qpb2w61J08hOzxqNHtxwc3HlDwpaCC2XAZomslyjo6+bujCxmM/+ljjh2lK/dRAcDuCdNxJlnSVp2LyFbG2RsjHQSVYlBQWytdXinKoLlIT0+yAIlYdrgmiA0PB52a7bf6AViUkn37CTrwNMCwCpbixMys+P7DP0iy+tWnpXyJgGiEbAeTiifZHD8WPV//w6dbHh3PP9/1349qt4HD0i73RCZrsOsrZHysVAJ1k5rPJVQEvP8DHa1LX2/cV6+QpvDDr35Bu2oRcEbSak0l9kazucPB5g0wZdxK6nUksYOtxc+YPqRkDaPZAKZkSsH3Lau8f/sw+j0YNb7ij2+/m9uzWY+6u8xYJ0RiOatZbvkRIpGwOdZOVyyjc9GuNrgZLTz5S+86hs183MOnkjETcMkuQGSn+Tre1wWrrYgOKiyI3QO3exIybmjHIuyddBEA3eWY06aNVK/5Xibrmj+HRxmzO4nMB7byfKfsBL9qBzoZZjgQXVCwx0qrU8Pt4cpdznILkrr3yXJCek41Nlv74QOwCwbQnpZLVI2Z2jwacfJ5z9C2XUxsd2QiF2iPcXzoMR7Ysc9u9TY5+fEfqQ88ynF0r68P23cThyWP6Ve72Gy7dVkpSP29ZIVhqdfFO+FrOP0Y5lBaTd/YAGTwG69oBjL6Tc52QrLFKJoUetH50f2K/Gor+N+GteTMS3q2Vl+SjCok499QsAkVvMJocv58T7/HhqmguTrve/qn13jga//Cj/cbjxySnoPYyBToFjoJOs9Eb5niEeO6oG4GOvr20LpP1jZbuOT+oGENQp8FjXyd602w24XAJcLsDpEOB0CrDbBdhs3v+sFhE2mwCLWYTVKsBsFmExn/y/RUSZSUBZmQiTSYTdFr1JtvgEH8VTnMcBAwB9WyAMP7uiQhFJyfLvSV/8r8HvwSy3/a8YeoPvSvEOBzAjDFPtADBs4nWcbqegMNBJVjHx8k377tsbxc3H2pNbhayhn+l+/JgK909Jh9sV+YIv4WTwEXKSaR6E+AshJF4NKQyB/unMBNx8e3HVZ/chOHxI7fdxxbALy9C+o/+Zhi8+k39V+ynte/cLS7ukXHyGTrIyxvuetqyJzRt18ESmQFi5bVtOjojU6ZAkpyyjzM9mJSguzAHAZvPxPRXOhOTYB6Te4T3QRmZHDqvxyvPJcMg0m3/iuArPP50Ci6XqW2FqmgtXTfRfqXDDeh3+/EP+qfZTNv73T9jaJmVioJOs4pKSZWvLZFJh29bITjl+/WU8LBYBMM2DtDMb8IRWxnbzRi3Wr619Z2zLodTXATOeMkj7xgLuUgjN50LuSUBTqYgd23V4/umUkA64AYDt27SY+nAqCgt97wy4+bZi6HS+ZwJKSkTMeCu8Fdw2MNApSAx0klVCSurZvygIf/wWvhHQmXbnaJCzU4s1q/SAZAPs20Jqz+MBPp8d2ZXnkXRgv5+pZtsGSDm9IB2cCEC+ynUlJWL54TM7tuvw0L1p+GehMehZHLNZwKyP4/HMEykwmXyHed/+FnTq4nsawOMB3n4tKewH4RzatQMOe+RL+VLdxWfoJKvEtDRZ21u/Vo99ezVo3iL8R4TOnukN399+jkX/gYGf5e3Pkv8M8HiAfgMsaNDQjfQMFxITPYiN9UCrk+ByAVarCKtFQF6uGkePeP/L2aWBw1H777W3b9PhotFm3590HpR969rO7ZVna0qKVfjwvUT8+lMsRl1chp59bIiP95/uu3M0WL7EgL8XGqtdTKjVejDxWv+r2n/4Ng55eSq062BHaqobcfEemEpFbNqoQ0mxfCHvcbtxcMd2tOzSVbY2SdkESZLkW11CBGBSp5Zw2OSrGJeZ5cQzL+SFHLDV+XuBER/NOD2Fetn4Ulw2Xr5T44LhdgM5u7TYskmHZUsMOH6sdt53i6KEGR8fr1L6NVxeeykJq1f6P/REECQ0bORC4yYuxMZ6oNFKsFpE5OercPCABuayyiFuMHhPuUtI9CAx0Xs0bUKSB82bO/yOzqvjcgKffJSAfxbKt9Pj7tffQ99Rl8jWHilb7XynoDotISUFeUfkq+N9YL8Gsz5OwI23lMjWZkX791Vd5fz9N/FITvFUW7c7XFQqoG07B9q2c2DcFSbsztFg0d9GLFpojMrRqP54PALmzY3FuCvCf8Rtfp4K686yFkGSBBw9oqm06jwh0Y0W5zgxYmQZ0jPcSEk5dba8x+/z8ZpSa4AbbinBrp1a2YrMFBw/Jks7VD8w0El2sYlJsgY6ACz8MwZJyW6MHSfvqDkvV4VXXkiG01k1KD98LxEWs4BRl/iZVo6Qlq2caNmqBBePLsM3X8Zh+VJjVPtT0e+/xmDoMPPpw2zC5Ms5cQHtFMho4EJ2NxvatXfgnFYOv6Vaw0WlAoZfaMbMD+VZMGctC//NEikHA51kp9XLdxZ0Rd99FQ+rRcSESf6fbwbjyGE1nn0ypdr655/PTsDGDXpMmFRyusZ7lGQ0cOOuKcXoP9CK995OqjKFHA12m4jPZsXjrin+Dy0J1eaN2mpvYjp2tqNbdxuyu9nQoKGPYjcRdk4r+dZ72GV8dEXKx0An2VlKwzM1DgC//xKLgwfUuGNysd8zqQMxf24MvvoiLqBKa1s26fDwfek4p6UDHTrZccEIc8RHfhV162HHi6/m4uUXkv3WHo+k5UuN6NPPhp695V+RXWYS8OEM36Pdlq0cuPn2YjRtFt0brTPJeD4R1JooFleiOif6t/ikKLvWr8WhnJ1hvcbmjXrce1c6vv0yDqWlgf8V9niAVSv0ePyhVHw6MyHosql7dmuxaYMOiYnRC/NTkpI9ePSJArRqUzvqpb/zRiL27pY3fBwO4KXnU5CfV3Xc0bGzHVOfyq91YQ4Ahw7K93OIiVPutkeSH0foJKuf3nszItexWET8+H0cfv4xFu07OtAl24bM5k40bORCjFGCRit5652Xijh4QIPt27TYsE6Hgvya/5UXRQl3TC4O62r7YBiNEh5+rABPPp7qf094hDgcIp6eloLJU4rQtbuP+vtBKikR8fL0ZOzZXXUGQhAk3HBzMdQaAGIi4AnfdH+w3G7g91/lq50gZ+VFUj4GOsnmcM4urF+0MKLX9HgEbNmkw5ZN8p3y5s/5F1jQpGntGhHqDRL+74FCPHxfms/ypZFkt4l4aXoKzj3fjKsmltZ4O9vypXrM/iTB757uzl3s3mflhh4QGj4Dae+IULotqw9nJMq6zTA+Wb7Ki6R8DHSSzdxZH0KpZQ1EUcKYcRVWHGuaADGDgOIvotepk9LS3bjljmK8/nLtePP/Z2EMVi434JKxZTjvfHNAwe5yAqtX6TH311ifo/KKunQ9OQNg7AUItWPF/5HDasyZFY+NG+Qt89usTXtZ2yNlY6CTLDweD1bOnxvWa7Rq40DLlg6kpLmh1Uiw2bwV1nJ2abB/X3gXh/XpZz29NUvQQ2j+G6Qjd4b1msHo1ceG5uc4asUiOcD7SOSrOfH45os4dM62o3UbBzKznEhI8MAY44HdLsBk8j4O2b1Li43rdbBaA5thSM84OUuiTgXE6Hy/Hg+we5cG69fpsX6tHgcPyP/IwxgXj4xmmbK3S8rFQCdZbF2+BOaS8DzLHHKeGWMvL0Nqmv8tSceOqvD1F/FYtSI8W+aGVCgwIzR4BnAeBcxLwnKtmho33oSXpqdEuxuVeDwCNqzTY8M6+Uau5cHvsQG6tvC+jYX/UUhRoYgtm3XYuF6HjRv0Yd82mNW+Q1jbJ+VhoJMswjE6Nxg8uPOewBZZNWzkxj33FWH1SitmvJ0Y8GgvEEajB+3an1xNrm0JpE2GlNNHtvbl0rW7HekZLuSeUPY/65xdGvQfaAWsGyCoEoAG0yAdf0z26xQXidi2VYdtW7XYulmHE8cj+3PtOvj8iF6P6j5l/8uniNm8bLGs7RkMHjz2ZEHQh7L07G1Dg4b51Z6kFazO2fbyle1CxmOAbYcs56Sf4vEAhQUqmEwi7HYBDrsAjwSo1RJiYz1ITXUHvMBs0LkWfPdVZFdGq9QSevW2olcfG7KaO5GY5IFKlFBcrMK+vRqsXqnH8mUG2c6EX/KvEZdfaUIM/oRU/L13LYPM7HYB992dHrWFhoIgoN9Fo6Nybaq7eDgLhcxmNuP6rm1kXRD3wKMFyO5a8+1Pe3dr8MRjqbKEyE23FeO8oRZAlQqh/WFIJ54Bcp+pcXvHjqqwfZt36ra4WIWGjVxo2NB7oIjLJWDPbg1Wr9JX2iefnOxG9542XHxp9Y8eCgpE3HVrgxr3LVhdsm248daSavsEePv1xex42crW9uhlxT33FUGsQd7m56lw/LgKHTtVv4f/zVeTsGJZeB7hnE27nr3xxBc/ROXaVHdxhE4h2799i6xhPuQ8c0hhDgAtWjoxcVIpPp0ZemGO9h1O9iV2CARRB6nku6Bev22LFjt2aJGzQ4vdu7Uwl4nokm3D2PEmtGrtewbCZhXw3TdxmHtyT3NhoQp/zY/Bv/8YMOmGUu8Nhg8pKR7Exbllm53wRxAkXHaFKeDa+ikpHtw1pRjdetgx453EkG+01qwy4NknRVxxVSlatnaWB7vHA5QUiygqVKH45P/z8lQ4dlSNY0fVOHFcDadTgChKmPNN9QefJKdEr4zsiGtvitq1qe5ioFPI9m/bKltbGo2E8VfJcyDF0OFm/PZLTEjFZAwGT3l9cMHYC5LjEGDfEfDrDx1U45lpqZU+NnxkGa69ofp69HqDhInXlqJhQxc+/uB06VOHQ8RHMxLhsAsYMcr3oTEpqeEP9CsmmHDJpcEflNN/oBWiKOGt10LfYrd9qw7THkuDVutBfIIHTqeA0vDL53oAACAASURBVBIRknT2mwWPR4DDAWirWSSfnuFCz97W8tPZUlLcSEh0IyZGgihKWLXcgJ9+iA3oesFo0bEzeg8fKWubVD8w0ClkRbknZGur0vawU1TJgDYLsG0BpMBLnapUwKDBVvz4fVyN+5OZVWEEbewBlP0d1Os3n1Hwpl0HO665rhQQYyGkPwLo20Iq+goo+cbn688fZsH2bVosW1J5qvqzWfFo2dqBlj4OAklNc2P/vqC6GZSu3W01CvNT+va3Ycsms2znhjscIvLzgp97t1pFaLX+y/gOG2HBsBH+j8/NzDLhyBG17DsrrrrvYVnbo/qDtdwpZGYZD2Pp1eeM06WSb4DQ/jDE1mshtN0B6FoH1V6XrqEdGNKgYYXtULr2kMzLgnr95g2VA33itaUQRUBo+hGEjIchJIyBkPkFoO/ot42rrimFSl35kYYkCfjxO983KrGx4as1r9V6cMsdFbYnirFAwtig27liggkGQ4SPNlVLaNXGgYtHm3D/wwWy/JyCXbR5NkPGXYlO/eVf5Ef1A0foFDJrmXxnlLc4p+IbpBpCo9chiN4RkKBtDmRMhXRwYsDtNcsMbX9ySmqF56jq5KBWt7ucwPZtp+d0GzR0nQ6AuNPlSgVBBUnf2TsD4asPKR5072GrMhJcv1aPY0dVaNio8rPecB7Q1W+AtfIpd6mTg5o1OSU+3oPzLrDg91/kq3vuS4OGLnTvaUPXbja0bO2odoq9Jvbuke+HnZGZhRumPStbe1T/MNApZNYyeZ55A0B8xbBQp0NQnTEK1bUMqj29QYJKLdV4EVZc/Mn+iPEQBA0k+66AX7t/vwYOx+lJsPYdKyz0s24CYgee/r1jb7VtdfMR6ACwaKERV11T+eev1YVv40qPXpVnPISEsZAOTqpRW/0HhifQW7VxoHtPG3r2sla52ZFLcZGIP36LweqV8k23pzVuCq1O3tKxVL8w0ClkGp18B6NIHgCn1nO5jkJyHoOgaXj6CxyHg2rP40FIK6p12pPhKKghecyAp/rFbBWdOXrLqvA8Xjo4EWg2x/tcvmg2YFlRbVtt2voeBa9cYagS6Gp1+AI9s/kZU8zaLMCxu0ZtNct0Qav1VLrpCUVGAxcm/1+R7NPgp+zdrcG6tXqsX6cLS4ndLcsW43DOLjRpFdxjJaJTGOgUsph4+c5sLikVkZJyepQu7R0BNP3A+4zZugHSsQeCa684tLDwnFrB7C6EtL1FUK/dv7dyoGc0qDD97zwIaU/gz0pT09wQBAlqtTew1WqpfGrdbBYQE3M6xBMSPGjS1Am9XoJO5z1KVhAAU6mI3TmhBVFC/BnPnQURMPYDzIuCbksUgcQkD3JPhB7ooijhgUcKZB2RWyzek/zWrdVjw1odSkvDf27ubzPfx23TXwn7dUiZGOgUMjnPbN67W4uUlArTurZNIZVZDTXA7LYKo3tXblCv3be38rXjzgzDIKhUwOffVr9v+pQRo8x+t7T98F1sSJXk3B4BalSYAbDtgND4VUg5/QAptAWIoeicbZd9ev21F5OxdUv4j+WtaOkvP+L6qU9DZ6gdp8hR3cJV7hSyuCT5ju1csUzeZ4jr14b2hmyx1ny6fvC5Ftx5TxGmPp2PN987EfICPTlcdEkZNJqaT8kXF1V+y5Dy3/TWtw9y98EpplJ53oLCUQTGbpd3f3kgnA47Nvy3KOLXJWVgoFPImrVuK1tbK5cbcOyoPFObZrOA5SGW7izIq3lfRowyo98AK9q2cyA1zV2jMqVy02qBuLiazxRUWdVd/BWkLfGAbVPQbR0/ppLtEJ1gDqRxu703evN+r34fvM0W+UAHgFVhPoaYlItT7hSy5h06ydaWxyNg5geJeHRaQcht/fR9XKV66DWRl6esfyLr1+pQWFjzm5S1q/Xo21+eqXU566Rv26L1uYXvFLtdwNbNWqxaacCalXpYLCJS01x+H00AgMNRNdATk9xo0tSF9AwXnA4BO3doZT/dbsvy2nUsL9Udynq3oqhITEtHQmoaSvLzZGlv6xYd/pxnrLZK19ls2qDD3F9Dq0SWnuFC5y7Rey4cCpcTyMtT4fgxNY4dU+PEMTUOHlBj547QHkGsXGHAFbkmpKWHNsVtNgv44zd5KsUB3hvBN19Nxq3/K0JWcxc8HuDAfg02bdBh00Yddu3UVtntYDJVf7N3xdWl0OslxMV7kJDgQVKSG+ozJig8HmDBn0bMnpkAj0eeEX1Jfh5KCwsQn1y7zran2o+BTrJo060HVv35h2ztzZ6ZgIQED3r3DT5Qd+3Q4LWXk2pcY7tZphPX3VSCtu2CL5gSaWazt375qZGpwwE8MCUdebkq2WuMA94tgHM+jceU+4tCaufD9xJlrzd/YL8Gj9yfDq3WA0kS4HT6//7j4txoc5Y/30BmIkTRWyLWYhbxzZfyLQ49sH0rK8ZR0BjoJIu+Iy+RNdA9HgFvvJKM0WNNuOxyU5WRkT8L5hvx2ayEat/Mq9O4iRNTn86H0Rj+LUrBcLuBw4fUKCxQ4egRNQ4e0GDvHg2OHNZg5MVlmHitd3987gm17FPAZ1q90oDffnbgotH+p6urM/e3GNnrn1fka1+7RiOhfQc7uvawoVNn+VfEj7y4DH/8FiPbTcqJQwch34Msqi8Y6CSL7kOHQWc0wm6p+TS5Lz//EIcVywy4+ppSdO9p87mwzOMBNm3U4fuv47Bn99m3qZ0/zIwRI83QGzzYuF6P776OQ3GR94344kvLYDRK3nPPd7YH3IWyfj81tWunFk9PTfX5uYorvI8eicw/6S/neEejwYb6vN9j8MVs+Uay1RFFCZ062zFwiBXde9qgC2MFPa0W6NTFXuUQnZqS83wEqj8Y6CQLrU6P7udegGW//yx72yeOq/HaS8lISHSjfQfv6Eqv98BmE3H0iBrbt2lRUhzYyOjMo0vPG2rBOS0dePSBNHg8Aho19m4tEzQZkLQtAGvtCPSjh/3/U21Y4QCZSAW6JAn44rME7Niuw1UTS9G4SfVb8spMAmZ9nHDWwIuLc6NXXxucTqHGxVxiYj04/wIzhl9oRlJy5A6ACXVdQUWW0sArEhKdwkAn2Yy49sawBPopJcUqLF9a8xFQZpYTE66p+kaZmeVCm3YObN+qQ1mZdwpAchUAsUMA65oaX89iEZB7QnVyGlyFokIVrrm+Zm/U+/f7f+aQVaEc6/59YTyZxYd1a/RYv1aHLl3t6NbdhqwWTiQkeKDRSDCZRBw+pMbGDXqsXK4/646Dxk2ceOLpfMTGeUfSZrOAF55JCao40AXDzbh6UmlYR+P+WEOoWXAmtzv6NQuo7mGgk2xad+2O7MHnYcO/wZ0ZHglarQd33lPk81m8xwOcOOb9p7BhnQ7ZXe2Qjv4fhNihqEksOBzA5NsyfI4uzx1qQZOmwb9Z+zvVKzHJXWkUevBAZAMd8I7WN6zTY8O6mhcF0mgkTP6/ovIwB4CYGAm331WEeydnBNRGvwEWXH9z9KaqjxyS72ev04dvjQEpVy0odUFKMv6e+6PdBZ+uuc7/tPDSxYbyvdkL5sdg4Z9GuPNnQzrkPUXM5QSKCgP/p6LV+p9+XbUy+NCz2wW/Qd05+/QJbjargOPH6uY9+hUTStG0WdU/n4aN3AGdm65SS7hygnyn/gXr0EG1rGVi5ay+SPVH3fzXT7VWi46d0W/U6LBOvQcru5sN5w/zvVjP5QS+/er0Ea0ej4CPP0jEl3PiERfvgalUhMXiDfPnXspFVvPARteDz7X4XKD33z9GXDq2LKiqcZs26PyeGNe12+mtVYcOqXFOSwfyclUROUhELh072zHyIt+L644dDayaXOcudqSmnbyJihlSo8NiasrlBGZ+IN8BRQCQ2qixrO1R/cAROsnuhmnPIik9sGnScIuJ9eCW24v9fn7u77HI91ENzmIRceK4ujzMAeDrzwNfne2dWq96jGfuCXVQBW/sdgHffBnn83MGgwddu58O9FatnXj6+Xy8+HoeGjSsG89gjUYPbr/T/572Tz5KDKidiiv9hcavh9yvQDgcwNrVOkx9JDXkgj1natKSR6hS8BjoJLvYxCTc9vyr0e4GAOCmW4uRmOR7yragQMQP38QG3NbGDXqsWhHYlLlKBTw6rQCZWVVD/YvPEvDtl3FwnKVuTXGRiBeeScaRw1Wn2xs1dmLCtaXQ+lgvFh/vQUZG3Qj0a28s8bsS/b9FBmzZFFhQFuRXmJFQNwAE+U8rc7uB3Tka/PJTLKY/nYxbrmuAV15Iwf598p6NboyLR4Os5rK2SfUDp9wpLLoMHIJRN9yC32d+ELU+9O1vqbbS3KcfJ/gsQlKdTz5KQJt2DiQknP25bkKCB8++mIcl/xnwy4+xOHrkdDD/+H0cFv9nwMiLzOjQyY70DDfUagllZSIO7NNg9So9Fi8ylPdPFCW0buNAtx42dO9pq7YwyoL5RmwOMAijqVsPGwYOtvr8XEmJiM8/DXxGZNsW7elz4e07gOQbgIK3Q+qf3S5gT44Gu3ZqsX2bFrt2akM+GyAQ7XrV/Lhgqt8Y6BQ21zz8BE4cPIg1C+ZF/NoJiW5cf5P/Fc/Ll+qxZlXwK4lLilV489UkPDK1AKoAHlOLIjBoiBWDhlixbYsWG9d764ofP65Gfp4asz+p+uxVq/UgLd2NDp0caNDAhdZtHejUxQ6jsfo19/v2ajDr4wTk7JR3xBgOMbEe3HSr/0chH7wbXGlYh0PEN1/E4/qbSyAVfeE9o92dDxR/VaP+vfdWIpYuNshWnz0Y3c4dGvFrkjIw0CmsJr/+Dp699irsXLsqote96dbiSlugKiopETHro5ovYtq+VYd33kjCnfcUBbW4rX1HB9p3PD3P7nJ6j+i0OwSoRECrk6DXS0Efs2q3C3jrtSSsWyPvWfLhdN2NJX4fhfyz0Ij1a4P/Xv6aH4PGTZ0YNuIDwJANocm7kOx7AWvVv3tuN5B7QoXDhzTQ6aRKuwUAb134aIS5SqNB7+EjI35dUgYGOoWVVqfHAx/MwvM3TkTOhnURuWavPlZ072n3+/n33wn9YJAVywxwOATcNaWoxkVM1BogViMhNojd7h4P4HQKla65aKGxToV5j15W9B/oe6r9yGE1Pv245qVhZ32UiE0b9Ojb/17o9VNgs4kwm40oLVGhsEBEQYG30E9erqo8sHv1sVYJdLM5Omeh9x42ErGJSVG5NtV9DHQKu5j4BDw+51u8cfftWLvwz7Bfb9QlZX4/N39uTEgFUCpat0aPh+5Nw423FqNjp/CdzOZ2e2u5r12tx5pVejz+VH55oHs8wO8hHhMbSUajBzfe6vtRiMMBvPVaUtDrGs60bo0+qBscX8eoWszRWS884tobo3JdUgYGOkWEVqfHve9+jFlPPYY/P/80rNfKaOAGtC0hpE2GVPARABGwbcHuHAFzZD4Y5MRxNZ57MhVt29kxdLgFPXpZfa48D4bDAezf612MtW2rDju3a8v3Yl84qgwpKaenqlcsM/jcdldbXTS6DAnNbwBKfqhy8M2nHydEpdJdSXHl8Ha7EdDed7l1GTQErbt2j/h1STnqzjsB1XmiKOKGac+hQ98B+ODR+2Eu8b8oKhRHDqsRH78bkm0HhBbzAHcxSrf/D6++uM1vgZZQ7diuw47tOmg0iWjdxoHWbRxo3NSF9AwXEhM9iI31QKOVoFJ5A9thF1BSokJpqYi8XO808LGjKhw5rMHhQ2q/z2+bZVbeBvfLj4Fvu6sNmjZzQtC2AFrMhVTyG1A4E3Adxb9/G/DPwujMNBQUVH78YiqNfJiLKhWuvv/RiF+XlIWBThHXe/hItOnWA+89NAUb/1ske/vffhmHBx8rhK7gXUgF76K0VMRzT6aguCj8oz+nU8DWLTpZy4BWdOiQBoD3+fOuHZqojGhDsXqVAd37vAohpg+EjEcA0Yh9y6di5oeBFZAJB7tNPL3lDb6n4MNtxDXXI7Nt+4hfl5RFkCQp8scSEZ209u+/8NXL03EoZ6es7SYnu9Glqw2iCli1XB/yIrjaQqWWMPxCM5JT3Jj7S2x5Dfq6ZPRYE8aMM0GrBXZs1+KNV5ICPv42XJ59MQ/NW3hnPzZv1GL6077Png+H5h064elvfoE61Gc1VO8x0KlW+PaNl/H9269FuxsUIaIoISbGU2tutO6aUoi+/b1FiBb/a8B7b0VmpXlMQiKm/zQP6U2aRuR6pGws/Uq1wgVXT4IgRGerEEWexyPUmjAHvIsbTykticzbokqjweTX3mGYk2wY6FQrJKalo0WnLtHuBtVTx46eDvTCgvDfaGj1Bjz04Wx0GTgk7Nei+oOBTrXGgEvGRLsLVE9VDPSiovAGujEuHo988jk69R8U1utQ/cNAp1pj4OjLoNLUrVXbpAxHj5wO9DO3scmpQ5/+eOn3hWjbo3fYrkH1FwOdao3YxCQMuJijdIo8i0VEQYEIi0XA8aPyB7oxLh7XPvYkHv/sG6Q0bCR7+0QAV7lTLVNw7CjuGToATof/WuxE4ZCe4YLLKci6FTA+OQUjr78ZI665AfqYulOil+omBjrVOl++PB0/vx/aWdZE0abR6vDRmi3QGYzR7grVE5xyp1pn/D33I7Ndh2h3gygkDZu3YJhTRDHQqdZRqdWY/No70OoN0e4KUY01bd022l2geoaBTrVS43NaYcpb70NU1Z7iI0TBaJXdLdpdoHqGz9CpVvv3h28x46EpCMdf01ZtHJh4bQmcDgFzPo3H/n3Rr6Wd0cCFC0aYceKYGgv+NEKSTlfPi4tz46bbStChkx3bt2rx7ptJUTnmszZQqSVoNRJsNqHSz6g2efvflUht1CTa3aB6hIFOtd7in77Hew9NgcftlrXd194+4T07HUB+ngqTb8/w+XVjLjPhkrFl2LBOhzdeSQ64/UHnWnDNdSU4cUyNGe8k4vChs++xf+n1XDRupgc8ZfjwvYRKR4pOub8QPXvbyn+/aYMOLz6X7Peo1VNEUcIdk4vRpp0d059KwdEjge31r0n/dXoPbr6tBN2622AyifjkowRsWKf3+bWpaS48+Ww+9u/T4KXpKWdtO7ubDQMGWdGuvR1Jyd4z4T0e7x7yrZt1+Gu+MeDvLdyad+iE6T/Ni3Y3qJ6pn7f3VKcMvPQyPDb7GySkpsnabkKSHkLWTwCA1DT/NwujLzNBl3IBeve1IT3DFVDbzTKduOX2YsTESGjR0on/3V0U0OsaN3FBaLnE++umla/VqXPlrXyds+24Y3IxBKH6e/Jb/1eMfgOsSEnxIKu5s9qvDbX/Y8aVod8AK/QGCWnpbtxxVxG0Wo/Pr23X3oGkZA+6dq9+i2J6hgtPPpeHBx4pRL8B1vIwBwBRBJo0dWH4SDNeeDUPwy4sC6if4dZr2Mhod4HqIQY61Qnte/XBi78tQO8Ro+Rr1GOBtP/Ss36ZVgsIsQMAABpNYBNaEyaVQNQkQ2jwHABv6AT6Wmh8Fx45fFgNJN8CGHqUf6zfACvumFwMUfTd9rU3lGDgYO/56Vs2a7F8aWALDSfdJELV6Lny3wfa/37nNwOSriv/fWychBGjzP5fkDSp2vY6dbHhuZfy0Kr12W9EVCrguhtLkZIa2E1XuGj1Bpx/5YSo9oHqJwY61RkJKamY8tYHeHTWlzinc3ZEry0dnxrw13bsbEenLg7vDcPxRwB4w6bvAGtgDbiLfX74g3cTUbr/Ewhp/wfoWpd/vP9AK+6+twgqdeXAvWx8KYaP9IZpcZGId95ICuh5c8fOdrRvX1Le92D6n5xkAYpmVfrYJWPKkJDoZwakaLbftjIauHD3vUUwGoN7KhgbG92niEOvnID45LM/QiCSGwOd6pxO/Qfh2e9/x7Qvf8CA0WNhiI2NdpcqufLqUu8v4oZV+vjQYdWMVCuy7/b54cOHNHjmiUQUb70VQsMXAd3pbVE9e9tw74OF5aPokReX4bLx3ulnhwN46flklBQHtmPgyqtLq/Q90P6LyVdW+ZjRKGHS9SUBXbuiyf/nP8xLSkTsztFg314NLJbTNymrVuhxYH/0nqNrtDpccsv/onZ9qt/UZ/8SotqpbY/eaNujN1wOB3asXYXtq1Zg//atOLpnNwpzj8NusUS8T9ndbGjR0glomgGSd+r3xHFvkLZs5URmlvOsgSPt8//89fAhDaY9LOChqZPQoPvbkAo/AMzeZ+7ZXe2498FCrFurw8RrvTcVHg/wzhtJ2LcnsBX82d1saNGuYXnfg+2/oG0JXxHct78NSxfbsG6N7wVyVb5+kBbN2zQEnAcrfXx3jgafzUpAzs7K309yshuiSkJ+XnTf0iY+PBWJaelR7QPVXxyhU52n1mrRse8AXH73fbh/xid47a/F+HRjDmZv2YPXFyyJ6Ah+zDgTAEBIvgEweVc5z5sbgxXLvM+uAx6lV+PEcTWmPmjAtvk3Q4gbCSTfUP65ztl2XHdjafnvP5qRgNUrAy/QM2acqVLfg+6/Nsvvp266tRhGo+8Fcme69JbrK91UAN41AE8+nlolzAGgsFAV9TDvdu5QDJ94XVT7QPUbA50US6vT49i+vbCWVV35PHCwBVpd5bHkG++eqPTfC6/m4sJRga+abtnK4V28pcmC5C4G4IHFImDR30Ys+c8biP0HWqHTBxZq1TGZVHh2WjJ+nvEcJNt+QEys8jUfvpeARX8HfiBIy1YOtOrQuLzvAILv/xkL+mzW09PhiUkeXH9zYFPvjTuMBVzHy3/vcgLvvpkEt6t27jlv3LIV7njx9Wh3g+o5Bjop2pE9vp9HX39TCcQz/vanpbuR3vtnpA+1I32oHc0u2IQRo8zwBJi/F17kDX8h9U6gcBYAYMGfMbDbRBw5rMHe3RroDRL69Q9wcdxZeDwCvpoTj0fu2Ix9uyuPnD94t/Ie9kD7X7HvQA36r06t9NsFfxqxO+f0FH3/gVb06HX2719laA6Ip2dWNm7QobiodlYNbNGxM5788kfEJiZFuytUzzHQSdHcbt9bmPbt8/0c2L7zIuz7WY8l78Thkwf6YOojqQik9FJyshu9+tgAdToAD+Aphs0q4PefT4fq3wu9B3Wcf0Fgz/adjsBGowf2a2AwnL7rmPFOYlAjc+Bk/wfE41TfAdSs/2J8pd86nAJefykZpaWn32puuq3E/6r3UyRbpen7/X7+vKKtx9ARmDrnO4Y51QpcFEeKltqosc+Pvzw9GXffW4TO2aeLmtxxc4bPUaDLJUClqj7Vh400Q6UCkHwTpHzv0a/z/4iByXS6vaWLDZg4qRQtWjqR1dxx1lKzTmfg08s5u7Ro0NA78v3vn+BP+Bo20gxV2uTyvgM1678g6qosiissVOGtV5Pw8NQCiCIQH+/BHXcVYekS//10lKyFxpAN2DZ5f2+v/LMYdmEZxl9l8rkK/sB+NZ6ZlgpzWfjGK0npGbhu6jPoPZwFZKj2YKCTonXsOwAqjQZuZ+XCJFariPz8yuHtb0rX5QJ0Ov/X0GgknHe+GYAagioZ0smV2e072vHw4/mQJAFWq4D9+zRYuVyPwedZcf4FFnz8QfWBbioNPJA+/TihvIBMsLz9t1fquxz9r2jrFh2+nBOPCZO8C/Y6dXEgLt7/s4z9qz9A6z6XQzq5T71idTgAuPKWLtC7F/t8bWaWC/0HWvDnH1UXQ6Y1bYq8Q4cC7veZWnTsjPOumICBo8fyaFSqdRjopGgJKakYMnY8Fn79eY3bcDoEIMb/CL3/QAti4yQgfgSkwpnlH2/V2gkkjIPQ4ClA2wJ9RR1Wfn4hgHnoP9CKObPjYbf5D+2yssBH6DZbzReL9R9oQWzj4ZX6DgCteo4u77sg6tB797mY/+3qk6/x3X/J4/+m4vdfYtHiHAf69vfWo89q7r+i2/yvF6J1t57eRxiuXHQ8o+ytUzsceteBKtvaTrH5+LmKKhXeWLAMuzeux4ZFC7F362bs27oZJfl5PtsQBAHpzTLRsnNXtOySjQ59B6AZj0SlWoyBToo34cHHQwv0s0x9n6rGBlUiYN9W+ZMl30Eq+Q4AIAHYtioeSToNWrZyov9AK/7+y/+z7tKSwBeBeTwCzGYBMdXcePgzfKQ5oL4DwPHj8did47//0ubqR63vv5OIho3yqw1zAFixzIDL1z9afnhOk6YuZHezlR/08sRNb2LYCDO0Ou/1NBqpfIbi378NWLyo6la9zLbtIYoiWnftjtZdu5d/3GG3wVJaCnNpCVxOJ2Li42GMS4AxLq7aPhLVNlwUR4oX6htzdaPfdh3syMw6GU4lP1XbzuFDaixfYsCCP70heLY93SUlwf3zDGaK/pTy/p+l70Dw/ffF4RDx8vSUs35vHo+Ad99KqrTD4Jbbi9GosffRyfFjasz+JAEfzUjERzMS8eWc04vxli4x+ixx22fkxT6vpdXpkZiWjsbntEJm2/ZIbdSEYU51EkfoVL8JWkByVPslVov/QB91cYV96p4y5OepMOWu9Gr3Sy9fYsDESSXIau6qdnFcabCBbhLRoGFwR8yW99/j/X+o/S8tFRFf4dl4fm7VWYbCQhVenp6Mx54sgE4noajQ9/eZs1OLz2bF45rrSiGK3n3sT03Px7y5MdiwVo/SUhHJyW5062HDeRVW3ufnVb1mfHIKhk+4rtqfBVFdxxE61QuCUDWgrBYBQsZUQJ0ORzWZXlZhtbTbXbmd9h0qv/Dbr+LOWvzE6RSw8ORU9aAhlZ85nzry3e32BnQwAt3mVpHc/V+/5vTqQbcb2LzJ92rCPbu1ePG5ZCxbYsBL0/2fMT9/bixefj4ZZSZvn4xGCWPHleGp6fl4/Z1cTH26ABeNNuP4UTUKCrw/r6Kiqj+3HkOHQx8T3FY+orqGgU71QlxS1dCY/0cMcg/mQGr2M775Mt7Hq7z+W2SExSJg1w5NeV3zU5ZVOI50315NeUW1s5k3NwYlJWKVafLffo6F3S7gr3kxfk9GE86siHOSwymU3xAESu7+AaQLowAAB5tJREFUfzYrARvW61BmEjDr4wQU5PufBNy+VYe3X0866/a9Dev0uPuODMz5NB47tmthNnu/z6JCEWtX6/Dmq0l4/OFULPnXiPw8lc+Fhg2zWgT0fRHVZYIkBVI2g6hue+76q7Fpyb9habtHLyuSU9xYsdSA0tLwVzPLbNcBh3btgOeM9M5q7kCDhu7yuuuBinT/o+H+92eh+3kXRLsbRGHFETrVC/0vHhO2ttesMuDPP2IjFoaDxlzu80Sv/fu0QYc5EPn+R5pWb0DHvv2j3Q2isGOgU70w8NLL0KJj52h3I2TpTZth6JUT0K5nn2h3pc4YNvFaFoGheoGBTvWCKIq4b8YnSG/aLKLXbdO9F+Zs3Ydnf5gLjbaacnMBMMTG4p4334fOYMTI62/2udDPH7VGE3S9cTn7DvhemOhL5wGDMWjM5RBVoc8YNO/QCePvuT/kdojqAtW0adOmRbsTRJFgiI1F/4vH4MieHBzbv7far83IzEKn/gNxOGdXja/XomNnPPTRbOhjYpGc0QDte/fBxsWLYDMHv3+7aas2uP/9WWjeoRMAIDmjAVQqNbauWHrW1wqCgNuffw1jbp+M9YsWwmIqPetr5Ow7AKQ0bIwHP5yN7EHnYt+2LTCXFPv8mokPPY5rH30SPS8Ygb6jLoEgiMg9dBB2a/BlbbsMGoL7358FQ0zVErBESsRFcVQv7VizEv98+xV2rF2FohMnIHk8SExLwzlduqL3sJHoNXwkVGo19m7ZhIVfzcG2lcuRf/QIBFFEcnoG9LExOHHwIKxlpiptxyUlY9iEazH2f/dApa68yttmNmP+57Owav5cHN69Cy6nE8npGWjdrSdiEhKwf9sWHM7ZBbvNivikZLTo1AUDLh6D3hdeBNHH6vZ5s2fis+efqlKr/hSd0YjbnnsFfUddAgCwWy344Z03sOCrOT5DtSZ9b9+7HwZfNh4Htm/F6r/m4XDOLphNpYiJi0dW+47oNXwkhowdD7X29Gr2PZs3Yu/mjSgtKoRWq0OLTl3QtkevKtcEAI/Hg8O7d2Hv5o0oOnECZlMJ1BoNElPTEROfgJXz52LPpvUoLSpETFw8WnXtjnPHXYkeQ4f7/JkQKRUDnaiGXA4Hdm1YhyO7d8FcWoK4pGRkNMtEu559fAZTuJw4eABzZ32ITYv/Rf7RIxDVKmQ0zUS384biwmtvQkJKapXX1Ja+E5F8GOhEREQKwEVxRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyIiUgAGOhERkQIw0ImIiBSAgU5ERKQADHQiIiIFYKATEREpAAOdiIhIARjoRERECsBAJyKi/2+vDmQAAAAABvlb3+MriRgQOgAMCB0ABoQOAANCB4ABoQPAgNABYEDoADAgdAAYEDoADAgdAAaEDgADQgeAAaEDwIDQAWBA6AAwIHQAGBA6AAwIHQAGhA4AA0IHgAGhA8CA0AFgQOgAMCB0ABgQOgAMCB0ABoQOAANCB4ABoQPAgNABYEDoADAgdAAYEDoADAgdAAaEDgADQgeAAaEDwIDQAWBA6AAwIHQAGBA6AAwIHQAGhA4AA0IHgAGhA8CA0AFgQOgAMCB0ABgQOgAMCB0ABoQOAANCB4ABoQPAgNABYEDoADAgdAAYEDoADAgdAAaEDgADQgeAAaEDwIDQAWBA6AAwIHQAGBA6AAwIHQAGhA4AA0IHgAGhA8CA0AFgQOgAMCB0ABgQOgAMCB0ABoQOAANCB4ABoQPAgNABYEDoADAgdAAYEDoADAgdAAaEDgADQgeAAaEDwIDQAWBA6AAwIHQAGAhCp/bM8t0QrwAAAABJRU5ErkJggg=="))));
            System.out.println("---img--");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/table")
    public void createPdfTable(HttpServletResponse response,String qt){

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
                table.addCell(new Cell().add(new Paragraph(i+15+"行\n换行").setFont(font)));
            }



            System.out.println("---table--");
            document.add(table);
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE)); //换页
            ////////////添加html片段 end///////////
            String content = "<img src='https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png'>";
            ConverterProperties proper = new ConverterProperties();
            //字体设置，解决中文不显示问题
            FontSet fontSet = new FontSet();
            fontSet.addFont("C:/Windows/Fonts/simhei.ttf",  PdfEncodings.IDENTITY_H);

            FontProvider fontProvider = new FontProvider(fontSet);
            proper.setFontProvider(fontProvider);
            List<IElement> elements = HtmlConverter.convertToElements(content, proper);
            Div overall = new Div();
            for (IElement element : elements) {
                if (element instanceof Div) {
                    Div div = (Div) element;
                    // 全部段落改成相同样式
                    overall.add(div);
                } else if (element instanceof Paragraph) {
                    Paragraph paragraph = (Paragraph) element;
                    overall.add(paragraph);
                }
            }
            document.add(overall);
            ////////////添加html片段 end///////////
            document.add(new Paragraph("--------------").setFont(font));
            document.add(new Paragraph("这是中文!").setFont(font));
            if (qt!=null){
                document.add(new Paragraph(qt).setFont(font));
            }
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
