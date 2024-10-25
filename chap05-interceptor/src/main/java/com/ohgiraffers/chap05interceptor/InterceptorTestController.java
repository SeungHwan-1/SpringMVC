package com.ohgiraffers.chap05interceptor;

import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class InterceptorTestController {

    @Autowired  //의존성 주입
    private IntercpetorService intercpetorService;

    @PostMapping("stopwatch")
    public String handlerMethod(Model model) throws InterruptedException {
        model.addAttribute("test", "모델 테스트");
        System.out.println("핸들러 메소드 호출함..");
        intercpetorService.method();
        Thread.sleep(1000); // 프로그램 1초 대기
        return "result";
    }
}
