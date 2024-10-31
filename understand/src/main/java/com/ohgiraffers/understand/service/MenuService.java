package com.ohgiraffers.understand.service;

import com.ohgiraffers.understand.dto.MenuDTO;
import com.ohgiraffers.understand.exception.NotInsertNameException;
import com.ohgiraffers.understand.model.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuDAO menuDAO;

    public List<MenuDTO> selectAllMenu() {
        List<MenuDTO> menus = menuDAO.selectAllMenu();
        System.out.println(menus);
        return menus;
    }

    public MenuDTO selectOneMenu(String code) {
        MenuDTO menu =menuDAO.selectOneMenu(code);
        return menu;
    }
                                            //컨트롤러로 던지고
    public int regist(MenuDTO menu) throws NotInsertNameException {
        List<MenuDTO> menus = menuDAO.selectAllMenu();
        //이름만 불러오는 요청 만들어서 날리는게 더좋다!
        List<String> names = new ArrayList<>();

        for (MenuDTO menuu:menus){
            names.add(menuu.getName());
        }
        //리스트안에 같은이름이있거나 || 비어있으면 익셉션
        if(names.contains(menu.getName()) || menu.getName().isEmpty()){
            throw new NotInsertNameException("");
        }
        if(menu.getPrice() <= 0){
            return 0;
        }
        int result = menuDAO.regist(menu);

        return result;


    }

    public int update(MenuDTO menu) throws NotInsertNameException {
        List<MenuDTO> menus = menuDAO.selectAllMenu();
        //이름만 불러오는 요청 만들어서 날리는게 더좋다!
        List<String> names = new ArrayList<>();

       for(MenuDTO menuu:menus){
            names.add(menuu.getName());
        }
        if(names.contains(menu.getName())){
            throw new NotInsertNameException("");
        }

        int result = menuDAO.update(menu);

        return result;
    }

    public int delete(MenuDTO menu) {
        int result = menuDAO.delete(menu);

        return result;
    }
}
