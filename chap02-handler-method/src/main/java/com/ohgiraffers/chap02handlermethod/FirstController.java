package com.ohgiraffers.chap02handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id") // 세션사용하게끔
public class FirstController {
    @GetMapping("regist")
    public void regist() {
        //반환타입이 보이드로 되면 경로로 간다. regist.html로간다 요청타고 들어감
    }
    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(
                request.getParameter("categoryCode"));
        String message = name + "을(를) 신규 메뉴 목록의" + categoryCode +
                "번 카테고리에 " + price + "원으로 등록하셨습니다.";
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify() {

    }
    // required = 파라미터 포함 여부, name = 이름 , defaultValue = 기본값
//    @PostMapping("modify")
//    public String modifyMenu(Model model,  //그기능을 끈다는
//                             @RequestParam(required = false, name = "modifyName") String modifyName,
//                             @RequestParam(defaultValue = "0") int modifyPrice) { // 처리하는 방법 두게가있다
//                                            //기본값 값이 넘겨오지않았을때
////        String message = modifyName + "메뉴 가격을" + modifyPrice + "원으로" +
//                "변경 하였습니다";
//        System.out.println(message);
//        model.addAttribute("message", message);
//        return "first/messagePrinter";
//    }

    @PostMapping("modify")                          //넘겨준 네임들이 key가됨
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) {
        String modifyName = parameters.get("modifyName");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPrice"));
        String message = modifyName + "메뉴 가격을" + modifyPrice + "원으로" +
                "변경 하였습니다";
        System.out.println(message);
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }
    @GetMapping("search")
    public void search(){}

    @PostMapping("search") // 모델어트리부트에바로담아서 따로필요가없다
                                        // 모델에 뒤에 DTO있어야함
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {
        System.out.println(menu);
        return "first/searchResult";
    }
    // 4. session 이용하기
    @GetMapping("login")
    public void login() {}
    // 4-1 : httpSession을 매개변수로 선언하면 핸들러 메소드 호출 시 세션 객체를 호출함.
    @PostMapping("login")
    public String sessionTest1(HttpSession session , @RequestParam String id) {
        session.setAttribute("id", id); // 사용자마다하나씩 주어지는저장공간에 값을 넣을수 잇다
                                            // 뷰에도 쓸수있구 다른곳에서도 쓸수있음
        return "first/loginResult";
    }

    @GetMapping("logout1") //세션을 만료시키지못하게?
    public String logout(HttpSession session) {
        session.invalidate();
        return "first/login";
    }
    /*
    * 4-2. SessionAttribute를 이용하여 session에 값 담기
    * 클래스 레벨에 @SessionAttribute 어노테이션을 이용하여 세션에 값을 담을 key를
    * 설정해두면,model영역에 해당 key로 값이 추가되는 경우 Session에 자동 등록한다.
    * (@SessionAttributes 로 지정된 속성은 해당 컨트롤러 내에서만 유효하다.)
     */
    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {
        model.addAttribute("id", id);
        return "first/loginResult";
    }

    //sessionAttribute로 등록된 값은 session의 상태를 관리하는
    //sessionStatus의 setComplete() 메소드를 호출해야 사용이 만료된다.

    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionstatus) {
        sessionstatus.setComplete();
        return "first/loginResult";
    }

    @GetMapping("body")
    public void body(){}

    /*
    * 5. @RequestBody 를 이용하는 방법
    * 해당 어노테이션은 http 본문 자체를 읽는 부분을
    * 모델로 변환시켜 주는 어노테이션이다.
     */                 //리액트에서 깔때 필요하다
    @PostMapping("body")                            //a밑에 에러하는거
    public void bodyTest(@RequestBody String body) throws UnsupportedEncodingException {
        System.out.println(body);
        System.out.println(URLDecoder.decode(body,"UTF-8"));
    }
}
