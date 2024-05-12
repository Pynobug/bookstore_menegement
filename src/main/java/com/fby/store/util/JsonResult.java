package com.fby.store.util;

/**
 * Json格式的数据进行响应
 */
public class JsonResult<E> {
    /** 状态码 */
    private Integer state;
    /** 描述信息 */
    private String message;
    /** 数据 */
    private E date;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E date) {
        this.state = state;
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getDate() {
        return date;
    }

    public void setDate(E date) {
        this.date = date;
    }
}
