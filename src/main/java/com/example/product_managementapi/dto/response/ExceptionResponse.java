package com.example.product_managementapi.dto.response;


public class ExceptionResponse {

    private String code;

    public ExceptionResponse(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
