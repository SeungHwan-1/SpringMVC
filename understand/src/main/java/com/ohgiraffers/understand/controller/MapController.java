package com.ohgiraffers.understand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

    @GetMapping("/map/map")
    public ModelAndView map(ModelAndView mv) {
        mv.setViewName("map/map");

        return mv;
    }
}
