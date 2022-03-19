package com.neuron.etl.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.Invitation;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.service.master.SysInvitationService;
import com.neuron.etl.service.master.SysUserService;
import com.neuron.etl.util.InFile;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.Ramdnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: SysInvitationController
 * #Date: 2021/5/18 21:50
 */


//帖子操作
@RestController
@RequestMapping(value = "/invi")
public class SysInvitationController {
    @Autowired
    SysInvitationService invitationService;
    @Autowired
    SysUserService userService;

    //全部帖子
    @RequestMapping(value = "/all")
    public JSONArray selectAll(){
        List<Object> invitationList= invitationService.selsctAllInvitation();
        return Inti.GetJsonArr((invitationList));
    }
    //帖子发送
    @RequestMapping(value = "/in")
    public JSONObject inserts(@RequestParam(value = "file",required = false)MultipartFile[] file, Invitation invitation){
        invitation.setInviid(Ramdnum.getnum());
        String[] strings= InFile.putAllFile(file,"invi",invitation.getInviid());
        invitation=Inti.Get(invitation,strings);
        JSONObject j=invitationService.InsertInvitation(invitation);
        if(j==null){
            return Inti.GetJson(Resp.fail("错误","信息不全"));
        }else {
            return j;
        }
    }


    //帖子发送
    @RequestMapping(value = "/ino")
    public JSONObject invitation(@RequestParam(value = "file",required = false)MultipartFile[] file,@RequestParam("userid")String userid,@RequestParam("title")String title,@RequestParam("content")String content){
        Invitation invitation=new Invitation();
        invitation.setUserid(userid);
        invitation.setTitle(title);
        invitation.setContent(content);
        invitation.setInviid(Ramdnum.getnum());
        String[] strings= InFile.putAllFile(file,"invi",invitation.getInviid());
        invitation=Inti.Get(invitation,strings);
        JSONObject j=invitationService.InsertInvitation(invitation);
        if(j==null){
            return Inti.GetJson(Resp.fail("错误","信息不全"));
        }else {
            return j;
        }
    }

    //查询一个
    @RequestMapping(value = "/o")
    public JSONObject selectone(@RequestParam("inviid") String id){
        Invitation invitation=invitationService.selectOneInvitation(id);
        return Inti.GetJson(invitation);
    }
    //分页查询
    @RequestMapping(value = "/s")
    public JSONArray selectSon(@RequestParam("start") Integer s,@RequestParam("end") Integer end){
        List<Object> invitations=invitationService.selectInvitionSon(s,end);
//        for (Object invitation : invitations) {
//            System.out.println("invitation-分页查询："+invitation.toString());
//        }
        return Inti.GetJsonArr(invitations);
    }

    //用户id查询
    @RequestMapping(value = "/u")
    public JSONArray geuUserIdINvi(@RequestParam(value = "userid")String id){
        List<Object> invitationList= invitationService.selectOneUserid(id);
        return Inti.GetJsonArr((invitationList));
    }

    //查询
    @RequestMapping(value = "/find")
    public JSONArray getSelectLike(@RequestParam(value = "str")String str){
        return Inti.GetJsonArr(invitationService.SelectLike(str));
    }
    //喜欢
    @RequestMapping(value = "/le")
    public JSONObject updateAddLike(@RequestParam("inviid")String id,@RequestParam("cls")Integer cls){
        if(cls==0){
            invitationService.updateDonelikes(id);
        }else {
            invitationService.updateAddlikes(id);
        }
        return Inti.GetJson(invitationService.selectOneInvitation(id));
    }
    //搜藏数
    @RequestMapping(value = "/col")
    public JSONObject updateDoneLike(@RequestParam("inviid")String id,@RequestParam("cls")Integer cls){
        if(cls==0){
            invitationService.updateDoneCollect(id);
        }else {
            invitationService.updateAddCollect(id);
        }
        return Inti.GetJson(invitationService.selectOneInvitation(id));
    }

    //阅读量加一
    @RequestMapping(value = "/rey")
    public JSONObject updatereaply(@RequestParam("inviid")String id){
        invitationService.updateAddReadly(id);
        return Inti.GetJson(invitationService.selectOneInvitation(id));
    }
    //帖子个数
    @RequestMapping(value = "/num")
    public JSONObject NumBerInvi(){
        JSONObject j=new JSONObject();
        j.put("num",invitationService.numBerInvi());
        return j;
    }
    //删除帖子
    @RequestMapping(value = "/de")
    public void deteleInvi(@RequestParam("inviid")String id ){
//        System.out.println(id);
         invitationService.deleteInvitation(id);
    }
}
