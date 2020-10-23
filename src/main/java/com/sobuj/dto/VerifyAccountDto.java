package com.sobuj.dto;

import com.sobuj.validators.ValidVerifyCode;

public class VerifyAccountDto {
    @ValidVerifyCode
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
