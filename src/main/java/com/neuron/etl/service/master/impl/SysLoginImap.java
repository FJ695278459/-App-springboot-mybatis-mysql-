package com.neuron.etl.service.master.impl;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.mapper.master.SysSonMapper;
import com.neuron.etl.mapper.master.SysUserMapper;
import com.neuron.etl.model.master.Token;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysLogin;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.publicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;
import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysLoginImap
 * #Date: 2021/7/1 23:13
 */

@Service
public class SysLoginImap implements SysLogin {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysSonMapper sysSonMapper;

    //手机号验证码登录


    @Override
    public void LoginPhoneYard(String userid, String token) {
        sysSonMapper.InsertToken(token,userid);
    }

    //手机号密码登录
    @Override
    public JSONObject LoginPhonePass(String phone, String pass, String token) {
        User user=userMapper.selectPhonePass(phone,pass);
        JSONObject jsonObject=new JSONObject();
        if(user!=null){
            String t=sysSonMapper.SelsctToken(user.getUserid());
            if(t.equals(token)){
                jsonObject= Inti.GetJson(user);
                jsonObject.put("code", publicData.SUCCESS);
                jsonObject.put("message","登录成功");
            }else {
                jsonObject.put("message","登录失败,token错误");
                jsonObject.put("code",publicData.ERROR_TOKEN);
            }
            return jsonObject;
        }
        jsonObject.put("message","账号或者密码错误");
        jsonObject.put("code",publicData.ERROR_PASS);
        return jsonObject;
    }

    @Override
    public List<Token> SelsctTokenAll() {
        return sysSonMapper.SelsctTokenAll();
    }

    //改变token
    @Override
    public User UpdateToken(String userid,String token) {
        sysSonMapper.UpdateToken(userid,token);
        return userMapper.selectOne(userid);
    }
}
