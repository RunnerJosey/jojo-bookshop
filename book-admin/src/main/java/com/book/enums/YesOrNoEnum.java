package com.book.enums;

/**
 * 是否枚举
 */
public enum YesOrNoEnum {
    YES(1,"1" ,"是"),
    NO(0, "0","否");

    private  Integer code;
    private String strCode;
    private  String name;


    YesOrNoEnum(Integer code, String strCode, String name) {
        this.code = code;
        this.strCode = strCode;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
