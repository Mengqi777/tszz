package com.heu.poet.tszz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MengQi
 * @create 2018-02-23 11:29
 */
@Controller
@RequestMapping("")
@SuppressWarnings(value = "unused")
public class WebController {

    @RequestMapping(value = "web/chat")
    public String chat() {
        return "chatpage";
    }

    @RequestMapping(value = "mystory")
    public String myStory() {
        return "mystorypage";
    }

    @RequestMapping(value = "storydetail")
    public String storyDetail() {
        return "storydetailpage";
    }
}
