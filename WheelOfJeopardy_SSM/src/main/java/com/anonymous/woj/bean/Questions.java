package com.anonymous.woj.bean;

public class Questions {
    private Integer questionid;

    private Integer categoryid;

    private Integer pointvalue;

    private String question;

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getPointvalue() {
        return pointvalue;
    }

    public void setPointvalue(Integer pointvalue) {
        this.pointvalue = pointvalue;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }
}