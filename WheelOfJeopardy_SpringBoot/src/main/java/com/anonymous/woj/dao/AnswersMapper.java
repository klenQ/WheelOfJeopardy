package com.anonymous.woj.dao;

import com.anonymous.woj.bean.Answers;
import com.anonymous.woj.bean.AnswersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersMapper {
    long countByExample(AnswersExample example);

    int deleteByExample(AnswersExample example);

    int insert(Answers record);

    int insertSelective(Answers record);

    List<Answers> selectByExample(AnswersExample example);

    int updateByExampleSelective(@Param("record") Answers record, @Param("example") AnswersExample example);

    int updateByExample(@Param("record") Answers record, @Param("example") AnswersExample example);
}