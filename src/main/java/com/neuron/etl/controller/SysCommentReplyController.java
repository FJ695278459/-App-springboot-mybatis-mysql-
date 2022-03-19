package com.neuron.etl.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.CommentInfo;
import com.neuron.etl.model.master.CommentReply;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.service.master.SysCommentReplyService;
import com.neuron.etl.service.master.impl.SysCommentReplyServiceImpl;
import com.neuron.etl.util.InFile;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.Ramdnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: SysCommentReplyController
 * #Date: 2021/6/2 17:51
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/reply")

public class SysCommentReplyController {
    @Autowired
    private SysCommentReplyService sysCommentReplyService;

    //发送评论
    @RequestMapping(value = "/in")
    public JSONObject insertCommentReply(@RequestParam(value = "file",required = false) MultipartFile[] file, CommentReply commentReply){
       commentReply.setReplyid(Ramdnum.getnum());
        String[] strings= InFile.putAllFile(file,"invi",commentReply.getInviid(),commentReply.getInfoid(),commentReply.getReplyid());
        commentReply=Inti.Get(commentReply,strings);
        JSONObject j=sysCommentReplyService.InsertCOmmentReply(commentReply);
        if(j==null){
            return  Inti.GetJson(Resp.fail("错误","信息不全"));
        }else {
            return j;
        }
    }

    //用户的所有回复
    @RequestMapping(value = "/u")
    public JSONArray SelectSUerAll(@RequestParam("userid")String userid){
        List<Object> list = sysCommentReplyService.SelecUserAll(userid);
        return Inti.GetJsonArr(list);
    }

    //分页查询
    @RequestMapping(value = "/s")
    public JSONArray selectSon(@RequestParam("infoid")String info_id,@RequestParam("start")Integer start,@RequestParam("end")Integer end){
        List<Object>  list=sysCommentReplyService.selectSonCommentReply(info_id, start, end);
        return Inti.GetJsonArr(list);
    }
    //擦寻所有
    @RequestMapping(value = "/o")
    public JSONArray selectAll(@RequestParam("infoid")String info_id){
        List<Object> list=sysCommentReplyService.selectAllCommentReply(info_id);
        return Inti.GetJsonArr(list);
    }
    @RequestMapping(value = "/de")
    public void  delect(@RequestParam("replyid")String id){
        sysCommentReplyService.deleteCommentReply(id);
    }

    //喜欢点赞+1
    @RequestMapping(value = "/le")
    public JSONObject updateAddLike(@RequestParam("replyid")String id,@RequestParam("cls")Integer cls){
        if(cls==0){
            sysCommentReplyService.updateDonelikes(id);

        }else {
            sysCommentReplyService.updateAddlikes(id);

        }
        return Inti.GetJson(sysCommentReplyService.selectone(id));
    }


    @RequestMapping(value = "/all")
    public JSONArray selectAll(){
        return Inti.GetJsonArr(sysCommentReplyService.selectAll());
    }
}
