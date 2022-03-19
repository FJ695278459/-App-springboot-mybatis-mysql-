package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * @Author: FengJie
 * #Description: PhoneLogin
 * #Date: 2021/6/25 23:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

//验证码
public class PhoneLogin {
    //手机号
    private String phone;
    //验证码
    private String yard;
    //信息
    private String message;
    //状态码
    private Integer code;
    //时间
    private long time;


}
