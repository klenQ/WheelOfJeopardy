package com.anonymous.woj.bean;

public class Answers {
    private Integer answerid;

    private Integer questionid;

    private String answerchoices;

    private Integer correctanswer;

    public Integer getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Integer answerid) {
        this.answerid = answerid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getAnswerchoices() {
        return answerchoices;
    }

    public void setAnswerchoices(String answerchoices) {
        this.answerchoices = answerchoices == null ? null : answerchoices.trim();
    }

    public Integer getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(Integer correctanswer) {
        this.correctanswer = correctanswer;
    }
}