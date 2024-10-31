package com.ohgiraffers.chap08securitysession.user.service;

import com.ohgiraffers.chap08securitysession.user.dao.UserMapper;
import com.ohgiraffers.chap08securitysession.user.dto.LoginUserDTO;
import com.ohgiraffers.chap08securitysession.user.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    //패스워드 인코더 비크립트가 들어옴
    @Autowired
    private PasswordEncoder encoder;

    // Transactional - 메소드가 정상적으로 완료되면 커밋함. 실행 중 예외 발생시 롤백함

    @Transactional
    public int regist(SignupDTO signupDTO) {
        if(signupDTO.getUserId() == null || signupDTO.getUserId().isEmpty()){
            return 0;
        }
        if(signupDTO.getUserName() == null || signupDTO.getUserName().isEmpty()){
            return 0;
        }
        if(signupDTO.getUserPass() == null || signupDTO.getUserPass().isEmpty()){
            return 0;
        }
        signupDTO.setUserPass(encoder.encode(signupDTO.getUserPass()));

                int result = userMapper.regist(signupDTO);

        return result;

    }

    public LoginUserDTO findByUserName(String username) {

        LoginUserDTO login = userMapper.findByUserName(username);
        if(Objects.isNull(login)){
            return null;
        }else
            return login;
    }
}
