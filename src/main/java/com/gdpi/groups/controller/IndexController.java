package com.gdpi.groups.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luojianhui
 * @date 2018/12/7
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "manager/index.html";
    }
}
