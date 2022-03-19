package com.neuron.etl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysQQinfoService;
import com.neuron.etl.service.master.SysSonService;
import com.neuron.etl.service.master.SysUserService;
import com.neuron.etl.util.InFile;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.publicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.cs.US_ASCII;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: FengJie
 * #Description: UserController
 * #Date: 2021/5/8 15:04
 */
@RestController
@RequestMapping(value = "/up")
public class SysUserController {

    @Autowired
    private SysQQinfoService sysQQinfoService;
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysSonService s;


    //更改个人资料
    @RequestMapping(value = "/n",method = RequestMethod.POST)
    public JSONObject UpUserName(@RequestParam(value = "file" ,required = false) MultipartFile file, User user,@RequestParam("token")String token){

        if(!s.SelectToken(user.getUserid()).equals(token)){
            return Inti.TokenError();
        }
        User u2=userService.selectOneUser(user.getUserid());
        if(u2==null){
            return Inti.GetJson(Resp.fail("用户id与数据库不匹配","错误"));
        }
        String path="";
        if(file==null){
            path=null;
        }else {
            Resp resp=InFile.putFile(file,"user",user.getUserid());
            path= (String) resp.getBody();
        }
        user.setUserhead(path);
        User u3=Inti.UpUser(user,u2);
        userService.updateuserall(u3);
        return Inti.GetJson(u3);
    }

    //收藏数
    @RequestMapping(value = "/c",method = RequestMethod.POST)
    public JSONObject Upcollect(@RequestParam("userid")String id){
        userService.updateCollectinfo(id);
        User user=userService.selectOneUser(id);
        return Inti.GetJson(user);
    }

//    //发帖数
//    @RequestMapping(value = "p",method = RequestMethod.POST)
//    public JSONObject UpPost(HttpServletRequest request){
//        String id=request.getParameter("id");
//        userService.updatePostnumbertinfo(id);
//        User user=userService.selectOneUser(id);
//        return Inti.GetJson(user);
//    }
    //改变积分
    @RequestMapping(value = "/s",method = RequestMethod.POST)
    public JSONObject UpScore(User user){
        System.out.println(user);
        userService.updateScoreinfo(user);
        return Inti.GetJson(userService.selectOneUser(user.getUserid()));
    }
    @RequestMapping(value = "/one")
    public JSONObject selectone(@RequestParam("userid")String id){
        User user=userService.selectOneUser(id);
        System.out.println(user);
        return Inti.GetJson(user);
    }

    //查询
    @RequestMapping(value = "/find")
    public JSONArray selectUSerLike(@RequestParam("str")String str){
        return Inti.GetJsonArr(userService.selectUserLike(str));
    }

    @RequestMapping(value = "/all")
    public JSONArray getUserAll(@RequestParam("pass")String pass){
        JSONArray j=new JSONArray();
        if(pass.equals(publicData.PASS)){
            j= Inti.GetJsonArr(userService.selectAll());
            return j;
        }
        j.add(Resp.fail("错误","服务器校验码错误"));
        return j;
    }

}
