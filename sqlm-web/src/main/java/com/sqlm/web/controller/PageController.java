package com.sqlm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面请求控制器
 * @author Yampery
 * @date 2017/7/26 16:12
 */
@Controller("pageController")
public class PageController {

    @RequestMapping("/{url}")
    public String page(@PathVariable("url") String url) {
        return url + ".html";
    }
}
