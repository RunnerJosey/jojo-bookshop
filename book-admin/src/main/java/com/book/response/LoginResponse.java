package com.book.response;

public class LoginResponse {
    private long code;
    private String message;
    private String token;

    public LoginResponse(long code, String message, String token) {
        this.code= code;
        this.message= message;
        this.token=token;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}


