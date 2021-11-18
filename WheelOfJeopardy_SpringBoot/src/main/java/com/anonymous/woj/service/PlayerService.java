package com.anonymous.woj.service;

import com.anonymous.woj.bean.*;
import com.anonymous.woj.dao.AnswersMapper;
import com.anonymous.woj.dao.CategoriesMapper;
import com.anonymous.woj.dao.QuestionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/14
 */
@Service
public class PlayerService {
    @Autowired
    CategoriesMapper categoriesMapper;
    @Autowired
    QuestionsMapper questionsMapper;
    @Autowired
    AnswersMapper answersMapper;

    public List<Categories> getCategory() {
        return categoriesMapper.selectByExample(null);
    }


    public Categories getCategoryById(int id) {
        CategoriesExample ce = new CategoriesExample();
        CategoriesExample.Criteria criteria = ce.createCriteria();
        criteria.andCategorieidEqualTo(id);
        List<Categories> categories = categoriesMapper.selectByExample(ce);
        //since we only have one category per id
        return categories.get(0);
    }

    public List<Questions> getQuestionsByCategoryId(int id) {
        QuestionsExample questionsExample  = new QuestionsExample();
        QuestionsExample.Criteria criteria = questionsExample.createCriteria();
        criteria.andCategoryidEqualTo(id);
        return questionsMapper.selectByExample(questionsExample);
    }

    public List<Answers> getAnswersByQuestionId(int questionId) {
        AnswersExample answersExample = new AnswersExample();
        AnswersExample.Criteria criteria = answersExample.createCriteria();
        criteria.andQuestionidEqualTo(questionId);
        return answersMapper.selectByExample(answersExample);
    }

    public Answers getAnswersByAnswerId(int answerId) {
        AnswersExample answersExample = new AnswersExample();
        AnswersExample.Criteria criteria = answersExample.createCriteria();
        criteria.andAnsweridEqualTo(answerId);
        List<Answers> answers = answersMapper.selectByExample(answersExample);
        //only one answer per answerId
        return answers.get(0);
    }

    public Questions getQuestionsByQuestionId(int questionId) {
        QuestionsExample questionsExample  = new QuestionsExample();
        QuestionsExample.Criteria criteria = questionsExample.createCriteria();
        criteria.andQuestionidEqualTo(questionId);
        List<Questions> questions = questionsMapper.selectByExample(questionsExample);
        //only one answer per answerId
        return questions.get(0);
    }
}
