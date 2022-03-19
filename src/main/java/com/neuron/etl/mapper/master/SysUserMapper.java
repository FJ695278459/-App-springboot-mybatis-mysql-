package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: SysUerMapper
 * #Date: 2021/5/6 23:43
 */

@Mapper
@Repository
//用户接口
public interface SysUserMapper {
    //用户注册
    void insertMast(User user);
    //用户注册
    //查询用户信息通过id
    User selectOne (@Param("userid") String id);
    //
    User selectOneQQ(@Param("QQToken") String QQToken);
    //用户登录，修改登录时间
    void updateUserTegTime(@Param("userid")String id,@Param("time") Timestamp time);
    //用户信息修改
    void updateNameinfo(User user);
    //用户头像修改
    void updateHeadinfo(@Param("userhead")String head,@Param("userid") String user_id);
    //用户学号信息
    void updateSoninfo(User user);
    //用户的帖子收藏
    void updateCollectinfo(@Param("userid")String user_id);
    //用户发帖数量
    void updatePostnumbertinfo(@Param("userid")String user_id);
    //用户帖子收搜藏数量查询
    Integer selectCollect(@Param("userid")String user_id);
    Integer selectPostnumber(@Param("userid")String user_id);
    Integer selectScore(@Param("userid")String user_id);
    void updateScoreinfo(User user);
    //基本信息改变
    void  updateall(User user);
    //通过手机号找到用户信息
    User selectPhone(@Param("phone")String phone);

    User selectPhonePass(@Param("phone")String phone,@Param("userpass")String userpass);


    List<Object> selectAll();

    List<Object> selectUserLike(@Param("str")String str);

}
