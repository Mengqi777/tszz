package com.heu.poet.tszz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MengQi
 * @create 2018-02-23 11:29
 */
@Controller
@RequestMapping("web")
@SuppressWarnings(value = "unused")
public class WebController
{

    @RequestMapping(value = "chat")
    public String chat(){
        return "chatpage";
    }
}
