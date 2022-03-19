package com.neuron.etl.test;

import com.neuron.etl.util.HttpClientUtil;

/**
 * @Author: FengJie
 * #Description: pyhone
 * #Date: 2021/6/25 23:03
 */
public class pyhone {

//    //用户名
//    private static String Uid = "一起蜂app";
//    //接口安全秘钥，18881833304
//    private static String Key = "d41d8cd98f00b204e980";
//
//    //
    //用户名
    private static String Uid = "一起蜂bee";
    //接口安全秘钥，18828587508
    private static String Key = "d41d8cd98f00b204e980";


    //手机号码，多个号码如13800000000,13800000001,13800000002
    private static String smsMob = "18380720952";
//    private static String smsMob = "18828587508";

    //短信内容
    private static String smsText = "验证码：8888，5分钟内有效，请勿泄露给他人使用。";

    public static void main(String[] args) {

        HttpClientUtil client = HttpClientUtil.getInstance();

        //UTF发送
        int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }
    }
}
