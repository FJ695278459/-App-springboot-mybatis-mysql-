package com.neuron.etl.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysQQinfoService;
import com.neuron.etl.service.master.SysUserService;
import com.neuron.etl.util.*;
import com.neuron.etl.model.master.QQinfo;
import com.neuron.etl.model.master.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: FengJie
 * #Description: SysQQinfoController
 * #Date: 2021/5/9 16:08
 */

//注册接口，QQ信息和用户信息注入
@RestController
@RequestMapping(value = "/log")
public class SysQQinfoController {
    @Autowired
     private SysQQinfoService sysQQinfoService;
    @Autowired
     private SysUserService userService;
    @RequestMapping(value = "/us")
    public JSONObject logingQQinfo(QQinfo qinfo){
        QQinfo ko=sysQQinfoService.selectoneQQInfo(qinfo.getQQToken());
        System.out.println(ko);
        //如果QQToken不存在说明是第一次登录，需要注册
        if (ko==null){
            System.out.println("执行注册");
            System.out.println(qinfo);
            if (!Inti.checkObjectFieldIsNull(qinfo)){
                return  Inti.GetJson(Resp.fail("错误","信息不全"));
            }
            sysQQinfoService.insertQQinfo(qinfo);
            User user=Inti.Get(qinfo);
            System.out.println(user);
            userService.InsertMastUser(user);
            return Inti.GetJson(user);
        }else {
            System.out.println("执行登录");

            if (!Inti.checkObjectFieldIsNull(qinfo)){
                return  Inti.GetJson(Resp.fail("错误","信息不全"));
            }
            sysQQinfoService.updateQQinfo(qinfo);
            userService.updateUserTegTime(qinfo.getQQToken(),Ramdnum.getdate());
            User user=userService.selectOneQQUser(qinfo.getQQToken());
            System.out.println(user);
            return Inti.GetJson(user);
        }
    }
//    @RequestMapping(value = "/us")
//    public JSONObject logingQQinfo(String json){
//        JSONObject jsonObject=JSON.parseObject(json);
//        System.out.println(json);
//        System.out.println(jsonObject);
//        QQinfo qinfo=JSONObject.parseObject(json,QQinfo.class);
//        System.out.println(qinfo);
//        QQinfo ko=sysQQinfoService.selectoneQQInfo(qinfo.getQQToken());
//        System.out.println(ko);
//        //如果QQToken不存在说明是第一次登录，需要注册
//        if (ko==null){
//            System.out.println("执行注册");
//            System.out.println(qinfo);
//            if (Inti.okNull(qinfo)){
//                return  Inti.GetJson(Resp.fail("400","信息不全"));
//            }
//            sysQQinfoService.insertQQinfo(qinfo);
//            User user=Inti.Get(qinfo);
//            System.out.println(user);
//            userService.InsertMastUser(user);
//            return Inti.GetJson(user);
//        }else {
//            System.out.println("执行登录");
//
//            if (Inti.okNull(qinfo)){
//                return  Inti.GetJson(Resp.fail("400","信息不全"));
//            }
//            sysQQinfoService.updateQQinfo(qinfo);
//            userService.updateUserTegTime(qinfo.getQQToken(),Ramdnum.getdate());
//            User user=userService.selectOneQQUser(qinfo.getQQToken());
//            System.out.println(user);
//            return Inti.GetJson(user);
//        }
//    }
}
