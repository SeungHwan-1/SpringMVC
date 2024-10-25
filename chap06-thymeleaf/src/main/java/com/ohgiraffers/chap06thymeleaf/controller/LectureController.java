package com.ohgiraffers.chap06thymeleaf.controller;

import com.ohgiraffers.chap06thymeleaf.model.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lecture/*") // 컨트롤러에 안붙고 리퀘스트 맵핑에
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv) {
        mv.addObject("member",new MemberDTO("고릴타",20,'여',"가라르 지방"));

        mv.addObject("hello", "hello <h3>Thymeleaf</h3>");
        mv.setViewName("/lecture/expression");

        return mv; //파라미터를안넘겼다?
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv) {
        mv.addObject("num",1);
        mv.addObject("str","banana");

        List<MemberDTO> memberList = new ArrayList<>();

        memberList.add(new MemberDTO("에이스번",20,'남',"가라르 지방"));
        memberList.add(new MemberDTO("아고용",20,'남',"가라르 지방"));
        memberList.add(new MemberDTO("따라큐",20,'남',"가라르 지방"));
        memberList.add(new MemberDTO("몰드류",20,'남',"가라르 지방"));
        memberList.add(new MemberDTO("메타몽",20,'남',"가라르 지방"));
        memberList.add(new MemberDTO("철화구야",20,'남',"가라르 지방"));
        memberList.add(new MemberDTO("랜드로스",20,'남',"가라르 지방"));
        memberList.add(new MemberDTO("텅비드",20,'남',"가라르 지방"));
        memberList.add(new MemberDTO("고릴타",20,'남',"가라르 지방"));
        memberList.add(new MemberDTO("갸라도스",20,'남',"가라르 지방"));

        mv.addObject("memberList",memberList);

        mv.setViewName("/lecture/conditional");
        return mv;

    }

    @GetMapping("fragment")
    public ModelAndView fragment(ModelAndView mv) {
        mv.addObject("test1","value1");
        mv.addObject("test2","value2");
        mv.setViewName("/lecture/fragment");
        return mv;
    }
}
