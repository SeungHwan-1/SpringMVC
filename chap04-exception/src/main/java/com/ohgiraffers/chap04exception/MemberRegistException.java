package com.ohgiraffers.chap04exception;
//예외로 만드려면 상속을 받아야함 생성자 두번째

public class MemberRegistException extends Exception{
    public MemberRegistException(String message) {
        super(message);
    }
}
