package com.anonymous.woj.exception;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/28
 */
public class InvalidParamException extends Exception{
    private String message;
    public InvalidParamException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
