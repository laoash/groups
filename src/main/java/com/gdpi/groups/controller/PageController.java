package com.gdpi.groups.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luojianhui
 * @date 2018/7/21
 * 管理页面
 */
@Controller
public class PageController {

    /**
     * 打开对应的html
     *
     * @return 打开视图
     */
    @RequestMapping("/manager/{page}")
    public String showPage(@PathVariable String page) {
        return "manager/" + page;
    }
}
