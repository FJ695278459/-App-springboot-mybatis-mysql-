package com.neuron.etl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.mapper.master.SysCollentMapper;
import com.neuron.etl.model.master.CommentInfo;
import com.neuron.etl.model.master.Invitation;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysCommentInfoService;
import com.neuron.etl.service.master.SysCommentReplyService;
import com.neuron.etl.service.master.SysUserService;
import com.neuron.etl.service.master.impl.SysCommentInfoServiceImpl;
import com.neuron.etl.util.InFile;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.Ramdnum;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;
import javax.activation.CommandInfo;
import javax.validation.constraints.Past;

/**
 * @Author: FengJie
 * #Description: SysCommentinfoController
 * #Date: 2021/5/24 19:00
 */
@CrossOrigin

//发送评论
@RestController
@RequestMapping(value = "/info")
public class SysCommentinfoController {
    @Autowired
    private SysCommentInfoService sysCommentInfoService;
    //发送评论
    @RequestMapping(value = "/in")
    public JSONObject insertCommentinfo(@RequestParam(value = "file",required = false) MultipartFile[] file, CommentInfo commentInfo){
        commentInfo.setInfoid(Ramdnum.getnum());
        String[] strings= InFile.putAllFile(file,"invi",commentInfo.getInviid(),commentInfo.getInfoid());
        commentInfo=Inti.Get(commentInfo,strings);
        JSONObject j=sysCommentInfoService.insertCommentInfo(commentInfo);
        if(j==null){
            return  Inti.GetJson(Resp.fail("错误","信息不全"));
        }else {
            return j;
        }
    }

    @RequestMapping(value = "/u")
    public JSONArray SelectUserAll(@RequestParam("userid")String userid){
        List<Object> list = sysCommentInfoService.selectUser(userid);
        return Inti.GetJsonArr(list);
    }


    //分页查询
    @RequestMapping(value = "/s")
    public JSONArray selectSum(@RequestParam("inviid")String invi_id,@RequestParam("start")Integer start,@RequestParam("end")Integer end){
        List<Object> list=sysCommentInfoService.selectSonCommentInfo(invi_id,start,end);
        return Inti.GetJsonArr(list);
    }
    //查询所有
    @RequestMapping(value = "/o")
    public JSONArray selectAll(@RequestParam("inviid")String invi_id){
        List<Object> list=sysCommentInfoService.selectAllCommentInfo(invi_id);
        return Inti.GetJsonArr(list);
    }
    //删除评论
    @RequestMapping(value = "/de")
    public void deleCommentInfo(@RequestParam(value = "infoid")String info_id){
        System.out.println(info_id);
       sysCommentInfoService.deleteCommentInfo(info_id);
    }
    //喜欢+1
    @RequestMapping(value = "/le")
    public JSONObject updateAddLike(@RequestParam("infoid")String id,@RequestParam("cls")Integer cls){
        if(cls==0){
            sysCommentInfoService.updateDonelikes(id);
        }else {
            sysCommentInfoService.updateAddlikes(id);
        }
        return Inti.GetJson(sysCommentInfoService.selectone(id));
    }

    @RequestMapping(value = "/all")
    public JSONArray selectAll(){
        return Inti.GetJsonArr(sysCommentInfoService.selectAll());
    }

}
