package com.neuron.etl.service.master;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

/**
 * @Author: FengJie
 * #Description: SysUserService
 * #Date: 2021/5/7 00:04
 */

public interface SysUserService {
    void InsertOtherUser(User user);
    void InsertMastUser(User user);
    User selectOneUser(String user_id);
    User selectOneQQUser(String QQToken);
    void updateUserTegTime(String QQToken, Timestamp RegTime);
    void updateNameinfo(User user);
    void updateHeadinfo(String head,String user_id);
    void updateSoninfo(User user);
    void updateCollectinfo(String user_id);
    void updatePostnumbertinfo(String user_id);
    Integer selectCollect(String user_id);
    Integer selectPostnumber(String user_id);
    Integer selectScore(String user_id);
    void updateScoreinfo(User user);
    void updateuserall(User user);
    User selectPhone(String phone);
    //手机号，密码登录
    List<Object> selectAll();
    List<Object> selectUserLike(String str);
}
