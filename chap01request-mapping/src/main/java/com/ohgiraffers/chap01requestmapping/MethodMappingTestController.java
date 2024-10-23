package com.ohgiraffers.chap01requestmapping;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;

@Controller
public class MethodMappingTestController {
    //컨트롤러에서 어느 곳으로갈지? 위


    //
    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출");
        //리퀘스트에 어트리부트 js에서 담은 어트리부트를 사용할수있는
        // 모델에 추가해주고 어떤 경로로 보낼지지정하고 그곳에서 사용할수있음


        return "mappingResult";
        //문자열로 매핑리저트로 주면 리소스 탬플릿하위에서 찾을것 만들어줘야함
    }

    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String modifyMenu(Model model) {
        model.addAttribute("message",
                "Get 방식의 메뉴 수정 호출");
        return "mappingResult";
    }

    /*
    * 요청 메소드 전용 어노테이션
    * 요청 메소드        어노테이션
    * post              @PostMapping
    * get               @GetMapping
    * Put               @putMapping // 수정 리소스의 모든 것을 업데이트
    * 풋은 수정전용인데 abc를 가지고있으면 풋으로 ac만 보내고 c는 지우고 그런 전체를 수정하는것  기존지우고
    * Delete            @DeleteMapping
    * Patch             @PatchMapping // 수정 리소스 일부 업데이트
    * 패치는 일부만 수정하는것 abc가 있구 ac만보내고 b는 놔두고  일부두고
     */
    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message","Get 방식의 삭제 핸들러 메소드 호출");
        return "mappingResult";
    }
    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message","post 방식의 삭제 핸들러 메소드 호출");
        return "mappingResult";
    }
}
