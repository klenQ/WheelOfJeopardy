package com.anonymous.woj.controller;

import com.anonymous.woj.service.GameService;
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
    GameService gameService;

    //select category by category id
    @ResponseBody
    @RequestMapping("/category/{categoryId}")
    public Msg selectCategory(@PathVariable int categoryId){

        Categories categories = gameService.getCategory(categoryId);
        return Msg.success().add("category",categories);
    }


    //select questions by category id
    @ResponseBody
    @RequestMapping("/questions/{categoryId}")
    public Msg selectQuestionsByCategoryId(@PathVariable int categoryId){
        List<Questions> questions = gameService.getQuestionsByCategoryId(categoryId);
        return Msg.success().add("questions",questions);
    }

    //select answer
    @ResponseBody
    @RequestMapping("/selectAnswers/{questionId}")
    public Msg selectAnswersByQuestionId(@PathVariable int questionId){

        List<Answers> answers = gameService.getAnswersByQuestionId(questionId);

        return Msg.success().add("answers",answers);
    }
    //check answer
    @ResponseBody
    @RequestMapping("/checkAnswer/{answerId}/{questionId}")
    public Msg checkAnswerById(@PathVariable int answerId, @PathVariable int questionId){

        Answers answers = gameService.getAnswersByAnswerId(answerId);
        if(answers.getCorrectanswer()==0){
            //the answer is not correct
            return Msg.success().add("correctness",false);
        }else {
            //the answer is correct return point, and also return point value
            //point value get from correspond question table
            Questions questions = gameService.getQuestionsByQuestionId(questionId);
            Integer pointValue = questions.getPointvalue();
            return Msg.success().add("correctness",true).add("points",pointValue);
        }


    }


}
