package com.anonymous.woj.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: used for return json
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/10
 */
public class Msg {
    //status code
    private int code;
    //Tips message
    private String msg;
    //data we actually return to the browser
    private Map<String,Object> extend = new HashMap<String,Object>();

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("Success");
        return result;

    }
    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("Fail!");
        return result;

    }
    public static Msg fail(String msg){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg(msg);
        return result;

    }
    public Msg add(String key, Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", extend=" + extend +
                '}';
    }
}
