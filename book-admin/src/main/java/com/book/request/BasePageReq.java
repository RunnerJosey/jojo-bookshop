package com.book.request;

/**
 * 基础分页查询类
 */
public class BasePageReq {
    /**
     * 当前页码，默认 1
     */
    private Integer current = 1;

    /**
     * 每页显示条数,默认 10
     */
    private Integer size = 10;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
