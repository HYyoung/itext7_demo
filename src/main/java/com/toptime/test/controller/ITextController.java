package com.toptime.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
     * 创建 pdf
     * @param response
     */
    @RequestMapping("/pdf")
    public void createPdf(HttpServletResponse response){

    }

}
