package com.anonymous.woj.bean;

import java.util.ArrayList;
import java.util.List;

public class AnswersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnswersExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAnsweridIsNull() {
            addCriterion("AnswerID is null");
            return (Criteria) this;
        }

        public Criteria andAnsweridIsNotNull() {
            addCriterion("AnswerID is not null");
            return (Criteria) this;
        }

        public Criteria andAnsweridEqualTo(Integer value) {
            addCriterion("AnswerID =", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotEqualTo(Integer value) {
            addCriterion("AnswerID <>", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridGreaterThan(Integer value) {
            addCriterion("AnswerID >", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridGreaterThanOrEqualTo(Integer value) {
            addCriterion("AnswerID >=", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridLessThan(Integer value) {
            addCriterion("AnswerID <", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridLessThanOrEqualTo(Integer value) {
            addCriterion("AnswerID <=", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridIn(List<Integer> values) {
            addCriterion("AnswerID in", values, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotIn(List<Integer> values) {
            addCriterion("AnswerID not in", values, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridBetween(Integer value1, Integer value2) {
            addCriterion("AnswerID between", value1, value2, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotBetween(Integer value1, Integer value2) {
            addCriterion("AnswerID not between", value1, value2, "answerid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNull() {
            addCriterion("QuestionID is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNotNull() {
            addCriterion("QuestionID is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidEqualTo(Integer value) {
            addCriterion("QuestionID =", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotEqualTo(Integer value) {
            addCriterion("QuestionID <>", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThan(Integer value) {
            addCriterion("QuestionID >", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("QuestionID >=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThan(Integer value) {
            addCriterion("QuestionID <", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThanOrEqualTo(Integer value) {
            addCriterion("QuestionID <=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIn(List<Integer> values) {
            addCriterion("QuestionID in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotIn(List<Integer> values) {
            addCriterion("QuestionID not in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidBetween(Integer value1, Integer value2) {
            addCriterion("QuestionID between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotBetween(Integer value1, Integer value2) {
            addCriterion("QuestionID not between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesIsNull() {
            addCriterion("AnswerChoices is null");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesIsNotNull() {
            addCriterion("AnswerChoices is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesEqualTo(String value) {
            addCriterion("AnswerChoices =", value, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesNotEqualTo(String value) {
            addCriterion("AnswerChoices <>", value, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesGreaterThan(String value) {
            addCriterion("AnswerChoices >", value, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesGreaterThanOrEqualTo(String value) {
            addCriterion("AnswerChoices >=", value, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesLessThan(String value) {
            addCriterion("AnswerChoices <", value, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesLessThanOrEqualTo(String value) {
            addCriterion("AnswerChoices <=", value, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesLike(String value) {
            addCriterion("AnswerChoices like", value, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesNotLike(String value) {
            addCriterion("AnswerChoices not like", value, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesIn(List<String> values) {
            addCriterion("AnswerChoices in", values, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesNotIn(List<String> values) {
            addCriterion("AnswerChoices not in", values, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesBetween(String value1, String value2) {
            addCriterion("AnswerChoices between", value1, value2, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andAnswerchoicesNotBetween(String value1, String value2) {
            addCriterion("AnswerChoices not between", value1, value2, "answerchoices");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerIsNull() {
            addCriterion("CorrectAnswer is null");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerIsNotNull() {
            addCriterion("CorrectAnswer is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerEqualTo(Integer value) {
            addCriterion("CorrectAnswer =", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerNotEqualTo(Integer value) {
            addCriterion("CorrectAnswer <>", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerGreaterThan(Integer value) {
            addCriterion("CorrectAnswer >", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerGreaterThanOrEqualTo(Integer value) {
            addCriterion("CorrectAnswer >=", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerLessThan(Integer value) {
            addCriterion("CorrectAnswer <", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerLessThanOrEqualTo(Integer value) {
            addCriterion("CorrectAnswer <=", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerIn(List<Integer> values) {
            addCriterion("CorrectAnswer in", values, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerNotIn(List<Integer> values) {
            addCriterion("CorrectAnswer not in", values, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerBetween(Integer value1, Integer value2) {
            addCriterion("CorrectAnswer between", value1, value2, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerNotBetween(Integer value1, Integer value2) {
            addCriterion("CorrectAnswer not between", value1, value2, "correctanswer");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}