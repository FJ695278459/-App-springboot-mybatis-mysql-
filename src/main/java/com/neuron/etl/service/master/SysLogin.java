package com.neuron.etl.service.master;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.Token;
import com.neuron.etl.model.master.User;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SsyLogin
 * #Date: 2021/7/1 23:11
 */
public interface SysLogin {
    //手机号加验证码注册
    void LoginPhoneYard(String userid,String token);
    //
    //手机号密码登录
    JSONObject LoginPhonePass(String phone,String pass,String token);
    //加载map
    List<Token> SelsctTokenAll();
    //d
    User UpdateToken(String userid, String token);
}
