package com.anonymous.woj.controller;

import com.anonymous.woj.bean.Msg;
import com.anonymous.woj.bean.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/13
 */
@Controller
public class TestController {


    @RequestMapping("/")
    public String axios(){
        System.out.println();
        return "axios";
    }

    @ResponseBody
    @RequestMapping("/axios-server")
    public Msg test(@RequestBody Test test){
        System.out.println(test);
        return Msg.success().add("test",test);
    }
    @ResponseBody
    @RequestMapping("/axios-server/{id}")
    public Msg test(int id){
        System.out.println(id);
        return Msg.success();
    }

}
