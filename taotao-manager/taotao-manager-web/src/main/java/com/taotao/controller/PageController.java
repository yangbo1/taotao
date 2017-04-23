package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 杨波 on 2017/3/14.
 */
@Controller
public class PageController {
    /**跳转到首页*/
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    /**展示其他的页面*/
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
