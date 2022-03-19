package com.neuron.etl.model.master;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
//用户

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //用户id
    private String userid;
    //密码
    private String userpass;
    //用户名@
    private String username;
    //注册时间
    private Timestamp RegTime;
    //上一次登录时间
    private Timestamp LastLogTime;
    //头像@
    private String userhead;
    //性别@
    private String  sex;
    //QQtoken
    private String QQToken;
    //学校@
    private String school;
    //年龄@
    private Integer age;
    //学号@
    private String son;
    //积分
    private Integer score;
    //发帖数
    private Integer postnumber;
    //收藏数
    private Integer collects;
    //个人签名
    private String signature;
    //手机号
    private String phone;
}
