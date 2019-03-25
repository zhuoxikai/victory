package com.ssm.crud.entity;

import lombok.Data;

/**
 * @author Ernest
 * @date 2018/4/4 13:34
 */
@Data
public class Result<T> {

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getExtend() {
        return extend;
    }

    public void setExtend(T extend) {
        this.extend = extend;
    }

    //提示码
    private Integer code;

    //提示信息
    private String msg;

    //具体内容
    private T extend;
}

