package com.neuron.etl.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.neuron.etl.mapper.master.SysSonMapper;
import com.neuron.etl.model.master.PhoneLogin;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysLogin;
import com.neuron.etl.service.master.SysSonService;
import com.neuron.etl.service.master.SysUserService;
import com.neuron.etl.util.*;
import com.sun.javafx.collections.MappingChange;
import com.zhenzi.sms.ZhenziSmsClient;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.multi.MultiLookAndFeel;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: login
 * #Date: 2021/6/25 15:42
 */

@RestController
@RequestMapping(value = "/log")
public class login {
    public static Map<String, PhoneLogin> map=new HashMap<>();
    //状态码
    public String code;
    //验证码
    public String yard;
    @Autowired
    public SysUserService sysUserService;
    @Autowired
    public SysLogin sysLogin;
    @Autowired
    public SysSonService sysSonService;

    //注册整合
    @RequestMapping(value = "/in")
    public JSONObject LoginIn(@RequestParam("phone")String phone,@RequestParam(value = "yard",required = false)String yard){
        if(phone.length()>11){
            return Inti.GetJson(Resp.fail("400","手机号格式错误"));
        }
        User user=sysUserService.selectPhone(phone);
        if(user!=null){
            JSONObject j=new JSONObject();
            j.put("code",publicData.ERROR_ALEAR);
            j.put("message","用户已存在，无法注册");
            return j;
        }
        //发送验证码
        if(yard==null || yard.equals("")){
            yard= Ramdnum.getyan();
            PhoneLogin p=new PhoneLogin(phone,yard,"测试验证码",publicData.SUCCESS,Ramdnum.getTimes());
            map.put(phone,p);
            Gc(phone);
            return Inti.GetJson(p);
        }else {//验证码已经获取到了
            if (map.size()==0){
                return Inti.GetJson(new PhoneLogin(phone,yard,"未知错误",publicData.ERROR_WEIZI,0));
            }
            JSONObject j=null;
            long time= (Ramdnum.getTimes()-map.get(phone).getTime())/(1000*60);
            if(time>5){
                map.remove(phone);
                return Inti.GetJson(new PhoneLogin(map.get(phone).getPhone(),map.get(phone).getYard(),"验证码失效",publicData.ERROR_YARD,5-time));
            }else if(!yard.equals(map.get(phone).getYard())){
                return Inti.GetJson(new PhoneLogin(map.get(phone).getPhone(),map.get(phone).getYard(),"验证码错误",publicData.ERROR_YARD,5-time));
            }else if(!phone.equals(map.get(phone).getPhone())){
                return Inti.GetJson(new PhoneLogin(map.get(phone).getPhone(),map.get(phone).getYard(),"手机号错误",publicData.ERROR_YARD,5-time));
            }else {
                user=Inti.setUser(phone);
                sysUserService.InsertMastUser(user);
                System.out.println("注册成功:\n"+user);
                map.remove(phone);
                j=Inti.GetJson(user);
                j.put("message","注册成功");
                //token插入
               String token=Ramdnum.getTOken(user.getUserid());
               sysLogin.LoginPhoneYard(user.getUserid(),token);
                j.put("code",publicData.SUCCESS);
                //获取token
                j.put("token",token);
                return j;
            }
        }
    }


    //注册整合
    @RequestMapping(value = "/out")
    public JSONObject LoginOut(@RequestParam("phone")String phone,@RequestParam(value = "yard",required = false)String yard){
        if(phone.length()>11){
            return Inti.GetJson(Resp.fail("400","手机号格式错误"));
        }
        User user=sysUserService.selectPhone(phone);
        if(user==null){
            JSONObject j=new JSONObject();
            j.put("code",publicData.ERROR_ALEAR);
            j.put("message","用户不存在,请先注册");
            return j;
        }
        //发送验证码
        if(yard==null || yard.equals("")){
            yard= Ramdnum.getyan();
            PhoneLogin p=new PhoneLogin(phone,yard,"测试验证码",publicData.SUCCESS,Ramdnum.getTimes());
            map.put(phone,p);
            Gc(phone);
            return Inti.GetJson(p);
        }else {//验证码已经获取到了
            if (map.size()==0){
                return Inti.GetJson(new PhoneLogin(phone,yard,"未知错误",publicData.ERROR_WEIZI,0));
            }
            JSONObject j=null;
            long time= (Ramdnum.getTimes()-map.get(phone).getTime())/(1000*60);
            if(time>5){
                map.remove(phone);
                return Inti.GetJson(new PhoneLogin(map.get(phone).getPhone(),map.get(phone).getYard(),"验证码失效",publicData.ERROR_YARD,5-time));
            }else if(!yard.equals(map.get(phone).getYard())){
                return Inti.GetJson(new PhoneLogin(map.get(phone).getPhone(),map.get(phone).getYard(),"验证码错误",publicData.ERROR_YARD,5-time));
            }else if(!phone.equals(map.get(phone).getPhone())){
                return Inti.GetJson(new PhoneLogin(map.get(phone).getPhone(),map.get(phone).getYard(),"手机号错误",publicData.ERROR_YARD,5-time));
            }else {
                map.remove(phone);
                //token插入
                String token=Ramdnum.getTOken(user.getUserid());
               User s= sysLogin.UpdateToken(user.getUserid(),token);
                System.out.println("登录成功:\n"+user);
                j=Inti.GetJson(s);
                j.put("message","登录成功");
                j.put("code",publicData.SUCCESS);
                //将token存入缓存
                //获取token
                j.put("token",token);
                return j;
            }
        }
    }



    //注册
    @ResponseBody
    @RequestMapping(value = "/p")
    public JSONObject getCode(@RequestParam("phone") String memPhone){
        if(memPhone.length()>11){
            return Inti.GetJson(Resp.fail("400","手机号格式错误"));
        }
        if(sysUserService.selectPhone(memPhone)!=null){
            JSONObject j=new JSONObject();
            j.put("code",publicData.ERROR_ALEAR);
            j.put("message","用户已存在，无法注册");
            return j;

        }
        yard= Ramdnum.getyan();
        PhoneLogin p=new PhoneLogin(memPhone,yard,"测试验证码",publicData.SUCCESS,Ramdnum.getTimes());
        map.put(memPhone,p);
        Gc(memPhone);
        return Inti.GetJson(p);
    }


    //登录
    @RequestMapping(value = "/pd")
    public JSONObject Enroll(@RequestParam("phone")String memPhone){
        if(memPhone.length()>11){
            return Inti.GetJson(Resp.fail("400","手机号格式错误"));
        }
        if(sysUserService.selectPhone(memPhone)==null){
            JSONObject j=new JSONObject();
            j.put("code",publicData.ERROR_ALEAR);
            j.put("message","该用户不存在，请先注册");
            return j;
        }
        yard= Ramdnum.getyan();
        PhoneLogin p=new PhoneLogin(memPhone,yard,"测试验证码",publicData.SUCCESS,Ramdnum.getTimes());
        map.put(memPhone,p);
        Gc(memPhone);
        return Inti.GetJson(p);
    }

    @RequestMapping(value = "/y")
    public JSONObject uptcode(@RequestParam("phone")String memPhone,@RequestParam("pass")String pass){
        if(!pass.equals(publicData.PASS)){
            return Inti.GetJson(Resp.fail("错误","校验么不正确！"));
        }
        if(memPhone.length()>11){
            return Inti.GetJson(Resp.fail("400","手机号格式错误"));
        }
        HttpClientUtil client = HttpClientUtil.getInstance();
        yard= Ramdnum.getyan();
//        UTF发送
        int result = client.sendMsgUtf8(publicData.PHONE_UID, publicData.PHONE_KEY, "验证码："+yard+" , "+publicData.YARD+"分钟内有效，请勿泄露给他人使用。", memPhone);

        if(result>0){
            code="发送成功";
            PhoneLogin p=new PhoneLogin(memPhone,yard,code,publicData.SUCCESS,Ramdnum.getTimes());
            map.put(memPhone,p);
            Gc(memPhone);
            return Inti.GetJson(p);
        }else{
            code=client.getErrorMsg(result);;
            PhoneLogin p=new PhoneLogin(memPhone,yard,code,publicData.SUCCESS,Ramdnum.getTimes());
            return Inti.GetJson(p);
        }
    }
    @RequestMapping(value = "/l")
    public JSONObject loginCode(@RequestParam("phone")String phone,@RequestParam("yard")String yard){
        if (map.size()==0){
            return Inti.GetJson(new PhoneLogin(phone,yard,"未知错误",publicData.ERROR_WEIZI,0));
        }
        JSONObject j=null;
        long time= (Ramdnum.getTimes()-map.get(phone).getTime())/(1000*60);
        if(time>5){
            map.remove(phone);
            return Inti.GetJson(new PhoneLogin(map.get(phone).getPhone(),map.get(phone).getYard(),"验证码失效",publicData.ERROR_YARD,5-time));
        }else if(!yard.equals(map.get(phone).getYard())){
            return Inti.GetJson(new PhoneLogin(map.get(phone).getPhone(),map.get(phone).getYard(),"验证码错误",publicData.ERROR_YARD,5-time));
        }else if(!phone.equals(map.get(phone).getPhone())){
            return Inti.GetJson(new PhoneLogin(map.get(phone).getPhone(),map.get(phone).getYard(),"手机号错误",publicData.ERROR_YARD,5-time));
        }else {
            User user=sysUserService.selectPhone(phone);
            String token=null;
            if(user==null){
                user=Inti.setUser(phone);
                sysUserService.InsertMastUser(user);
                System.out.println("注册成功:"+user);
                map.remove(phone);
                j=Inti.GetJson(user);
                j.put("message","注册成功");
                //token插入
                 token=Ramdnum.getTOken(user.getUserid());
                 sysLogin.LoginPhoneYard(user.getUserid(),token);
            }else {
                System.out.println("登录成功:"+user);
                map.remove(phone);
                j=Inti.GetJson(user);
                j.put("message","登录成功");
                token=Ramdnum.getTOken(user.getUserid());
                //改变
                sysLogin.UpdateToken(user.getUserid(),token);
            }
            j.put("code",publicData.SUCCESS);
            //将token存入缓存
            //获取token
            j.put("token",token);
            return j;
        }
    }

    //用户密码登录
    @RequestMapping(value = "/up")
    public JSONObject LogPhonePass(@RequestParam("userpass")String pass,@RequestParam("phone")String phone,@RequestParam("token")String token){
       return sysLogin.LoginPhonePass(phone,pass,token);
    }
    //销毁用户资源=
    public void Gc(String phone){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000*60*7);
                    try{
                        map.remove(phone);
                    }catch (Exception e){
                        System.out.println("销毁错误");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @RequestMapping(value = "/png")
    private String ImgPng(@RequestParam(value = "file",required = false)MultipartFile files){
        return files.getOriginalFilename();

    }

}
