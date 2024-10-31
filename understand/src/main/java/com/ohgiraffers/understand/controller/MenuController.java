package com.ohgiraffers.understand.controller;

import com.ohgiraffers.understand.dto.MenuDTO;
import com.ohgiraffers.understand.exception.NotInsertNameException;
import com.ohgiraffers.understand.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/menus/*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("menus")
    public ModelAndView selectAllMenu(ModelAndView mv) {
        List<MenuDTO> menus = menuService.selectAllMenu();
        if(Objects.isNull(menus)){
            throw new NullPointerException();
        }
        mv.addObject("menus",menus);
        mv.setViewName("menus/allMenus");
        return mv;
    }
    @GetMapping("onemenu")
    public ModelAndView oneMenu(ModelAndView mv) {
        mv.setViewName("menus/onemenu");
        return mv;
    }

    @GetMapping("onemenuaction")
    public ModelAndView selectOneMenu(ModelAndView mv, WebRequest request) {
        //로직
        String code = request.getParameter("code");

        MenuDTO menu = menuService.selectOneMenu(code);
        if(Objects.isNull(menu)){
            throw new NullPointerException();
        }
        mv.addObject("menus",menu);
        mv.setViewName("menus/allMenus");
        return mv;
    }

    @GetMapping("regist")
    public ModelAndView insert(ModelAndView mv) {
        mv.setViewName("menus/regist");
        return mv;
    }
    @PostMapping("regist")
    public ModelAndView insertMenu(ModelAndView mv, MenuDTO menu) throws NotInsertNameException {
        int regist = menuService.regist(menu);

        if(regist<= 0){
            mv.addObject("message","가격은 음수일 수 없습니다");
            mv.setViewName("error/errorMessage");
        }else{
            mv.setViewName("menus/returnMessage");
        }
        return mv;
    }
    @GetMapping("update")
    public ModelAndView update(ModelAndView mv) {
        mv.setViewName("menus/update");

        return mv;
    }
    @PostMapping("update")
    public ModelAndView updateMenu(ModelAndView mv, WebRequest request) throws NotInsertNameException {
        //@RequestParam int code,
        //@RequestParam(defaultValue = "") String name,
        //@RequestParam(defaultValue = "0") int price,
        //@RequestParam(defaultValue = "0") int categoryCode,

        String code = request.getParameter("code");
        String sname = request.getParameter("name");
        String sprice = request.getParameter("price");
        String scategorycode = request.getParameter("categoryCode");

        MenuDTO menu = new MenuDTO();

        if (menu.getName() == null || menu.getName().isEmpty()) {
            menu.setName(null);
        }

        if(scategorycode == null || scategorycode.isEmpty()) {
            scategorycode  = String.valueOf(0);
        }


        if (sprice == null || sprice.isEmpty()) {
            sprice = String.valueOf(0);
        }
        assert code != null;
        menu.setCode(Integer.parseInt((code)));
        menu.setName(sname);

        menu.setPrice(Integer.parseInt(sprice));
        menu.setCategoryCode(Integer.parseInt(scategorycode));

        int update = menuService.update(menu);

        if(update<= 0){
            mv.addObject("message","업데이트 실패");
            mv.setViewName("error/errorMessage");
        }else{
            mv.setViewName("menus/returnMessage");
        }
        return mv;
    }
    @GetMapping("delete")
    public ModelAndView delete(ModelAndView mv) {
        mv.setViewName("menus/delete");

        return mv;
    }
    @PostMapping("delete")
    public ModelAndView deleteMenu(ModelAndView mv, MenuDTO menu) throws NotInsertNameException {
        int delete = menuService.delete(menu);
        if(delete<= 0){
            mv.addObject("message","삭제 실패");
            mv.setViewName("error/errorMessage");
        }else{
            mv.setViewName("menus/returnMessage");
        }
        return mv;
    }

}
