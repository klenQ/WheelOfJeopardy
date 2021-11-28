package com.anonymous.woj.exception;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/28
 */
public class InvalidGameException extends Exception{
    private String message;
    public InvalidGameException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
