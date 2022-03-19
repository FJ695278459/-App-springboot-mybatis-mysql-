package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: SysSonMapper
 * #Date: 2021/5/21 22:35
 */
@Repository
public interface SysSonMapper {
    //学号密码插入
    void insert(Son son);
    //查询课表人数
    void updataPak(@Param("id") String id);
   //通过本软件点击教务系统人数
    Zf selectNum(@Param("id")String id);
    //查询一个学号的所有信息
    Son selectSon(@Param("son")String son);
    //留言板插入
    void insertnotecard(Notecard notecard);
    //查询留言板
    Notecard selectnotecard(@Param("id")String id);
    //
    List<Object> selectnotecardall();
    void updatazf(@Param("id")String id);
    //查询通告
    Mag selectmag();
    //修改通告
    void updatahomemag(Mag mag);
    void insertfeedback(Feedback d);
    List<Object> selectfeedbackall();
    //通过userid查询反馈
    List<Object>  selectfeedbackUserid(@Param("userid")String userid);
    Feedback selectFeedbackId(@Param("feedbackid")String id);

    //token
    void InsertToken(@Param("token")String token,@Param("userid")String userid);
    //获取token
    String SelsctToken(@Param("userid")String userid);

    List<Token> SelsctTokenAll();

    void UpdateToken(@Param("userid")String userid,@Param("token")String token);
    List<Object> SelsctAllLike(@Param("str")String str);
}
