package com.ohgiraffers.chap01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/*") //오더하위 전부
public class ClassMappingTestController {

    @GetMapping("/regist")
    public String registOrder(Model model) {
        model.addAttribute("message", "Get 방식의 주문 등록용 핸들러 메소드 호출");
        System.out.println("오더");
        return "mappingResult";
    }
    // 밸류에이런식으로 넣으면 한번에 여러게 같이 쓸수있다. 같이 접근이가능 RequestMethod 만쓰면 겟포스트다받음
    @RequestMapping(value = {"modify","delete"}, method = RequestMethod.POST)
    public String modifyOrder(Model model) {
        model.addAttribute("message","post 방식의 주문 정보 수정 핸들러 메소드 호출");
        return "mappingResult";
    }

    // /order/1 패스벨리어블
    //  /order?asd=asd 쿼리스트링파라미터

    /*
    * PathVariable
    * @PathVariable 어노테이션을 이용해 변수를 받아올 수 있다.
    * path variable 로 전달되는 {변수명}은 반드시 매개변수명과 동일해야한다.
    * 만약 동일하지 않으면 @PathVariable("이름")을 설정해주어야한다.
     */
    @GetMapping("/detail/{orderNo}")  //다그냥 이대로 넣어주자
    public String selectOrderDetail(@PathVariable("orderNo") int orderNo, Model model) {
        model.addAttribute("message", orderNo+"번 주문 상세 내용 조회용 핸들러 메소드 호출");
        return "mappingResult";
    }
    @RequestMapping
    public String otherRequest(Model model) {
        model.addAttribute("message","order 요청이긴 하지만 다른 기능이 준비되지 않음");
        return "mappingResult";
    }
}
