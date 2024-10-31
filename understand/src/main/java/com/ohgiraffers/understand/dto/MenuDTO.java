package com.ohgiraffers.understand.dto;

public class MenuDTO {
    private int code;
    private String name;
    private int categoryCode;
    private String status;
    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public MenuDTO(int code, String name, int categoryCode, String status, int price) {
        this.code = code;
        this.name = name;
        this.categoryCode = categoryCode;
        this.status = status;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", categoryCode=" + categoryCode +
                ", status='" + status + '\'' +
                ", price='" + price + '\'' +
                '}';
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MenuDTO() {
    }

    public int getPrice() {
        return price;
    }

    public MenuDTO(int code, String name, int categoryCode, String status) {
        this.code = code;
        this.name = name;
        this.categoryCode = categoryCode;
        this.status = status;
    }


}
