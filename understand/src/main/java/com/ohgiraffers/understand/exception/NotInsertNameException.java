package com.ohgiraffers.understand.exception;

//인서트할때 같은이름이 있는지 비교 같은이름이있으면 이걸줄꺼다 이거날릴거다~!
//기존 메뉴에 중복된 이름이 있을 시 발생시킬 익셉션
public class NotInsertNameException extends Exception {
    public NotInsertNameException(String message) {
        super(message);
    }
}