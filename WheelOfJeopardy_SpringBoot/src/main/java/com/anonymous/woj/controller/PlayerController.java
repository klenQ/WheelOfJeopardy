package com.anonymous.woj.controller;

import com.anonymous.woj.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.anonymous.woj.bean.Answers;
import com.anonymous.woj.bean.Categories;
import com.anonymous.woj.bean.Msg;
import com.anonymous.woj.bean.Questions;

import java.util.List;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/13
 */
@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;

    //get all categories
    @ResponseBody
    @RequestMapping("/category")
    public Msg getAllCategories(){

        List<Categories> categories = playerService.getCategory();
        return Msg.success().add("category",categories);
    }





    //select category by category id
    @ResponseBody
    @RequestMapping("/category/{categoryId}")
    public Msg selectCategory(@PathVariable int categoryId){

        Categories categories = playerService.getCategoryById(categoryId);
        return Msg.success().add("category",categories);
    }


    //select questions by category id
    @ResponseBody
    @RequestMapping("/questions/{categoryId}")
    public Msg selectQuestionsByCategoryId(@PathVariable int categoryId){
        List<Questions> questions = playerService.getQuestionsByCategoryId(categoryId);
        return Msg.success().add("questions",questions);
    }

    //select answer
    @ResponseBody
    @RequestMapping("/selectAnswers/{questionId}")
    public Msg selectAnswersByQuestionId(@PathVariable int questionId){

        List<Answers> answers = playerService.getAnswersByQuestionId(questionId);

        return Msg.success().add("answers",answers);
    }
    //check answer
    @ResponseBody
    @RequestMapping("/checkAnswer/{answerId}/{questionId}")
    public Msg checkAnswerById(@PathVariable int answerId, @PathVariable int questionId){

        Answers answers = playerService.getAnswersByAnswerId(answerId);
        if(answers.getCorrectanswer()==0){
            //the answer is not correct
            return Msg.success().add("correctness",false);
        }else {
            //the answer is correct return point, and also return point value
            //point value get from correspond question table
            Questions questions = playerService.getQuestionsByQuestionId(questionId);
            Integer pointValue = questions.getPointvalue();
            return Msg.success().add("correctness",true).add("points",pointValue);
        }


    }


}
