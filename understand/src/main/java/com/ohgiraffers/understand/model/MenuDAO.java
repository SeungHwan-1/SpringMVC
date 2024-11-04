package com.ohgiraffers.understand.model;

import com.ohgiraffers.understand.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuDAO {

    List<MenuDTO> selectAllMenu();

    MenuDTO selectOneMenu(String code);

    int regist(MenuDTO menu);

    int update(MenuDTO menu);

    int delete(MenuDTO menu);

    List<MenuDTO> searchOneMenu(String code);
}
