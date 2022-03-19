package com.neuron.etl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.*;
import com.neuron.etl.service.master.IWebSocket;
import com.neuron.etl.service.master.SysMapSercice;
import com.neuron.etl.service.master.SysSonService;
import com.neuron.etl.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

/**
 * @Author: FengJie
 * #Description: courseHtml
 * #Date: 2021/5/8 22:18
 */

@CrossOrigin
//擦寻课表
@RestController
@RequestMapping(value = "/bee")
public class Others {
    @Autowired
    private SysSonService sysSonService;
    @Autowired
    private SysMapSercice sysMapSercice;
    @Autowired
     private IWebSocket webSocket;


    String k="1234";
    @RequestMapping(value = "/ce")
    public JSONArray course(@RequestParam("user_son")String son, @RequestParam(value = "user_pass",required = false) String p){
        String[] s={son,p};
        JSONArray jsonArray=Jpyhton.JSONScore(publicData.P,s);
//        //注册学号，统计个数
//        if(map.size()>1 && sysSonService.selectSon(son)==null){
//            //如果学号不存在，学生第一次查课表，写入数据库
//                Son so=new Son(son,p);
//                sysSonService.insertSon(so);
//                sysSonService.UpdatePak(k);
//        }
        return jsonArray;
    }
    //查询注册人数
    @RequestMapping(value = "/n")
    public JSONObject num(){
        return Inti.GetJson(sysSonService.selectNumPak(k));
    }
    @RequestMapping(value = "/zf")
    public void Addzf(){
        sysSonService.updatazf(k);
    }
    //下载链接
    @RequestMapping(value = "/apk")
    public JSONObject apkInfo(){
        return Inti.readJsonFile(publicData.JSONAPK);
    }


    @RequestMapping(value = "/new")
    public JSONObject UpdateApk(@RequestParam("file")MultipartFile file, ApkInfo apkInfo ,@RequestParam("pass")String p){
        System.out.println(apkInfo);
        if(!p.equals(publicData.PASS)){
            return Inti.GetJson(Resp.fail("错误","校验么不正确！"));
        }
        if(file!=null){
            InFile.putFileApk(file);
        }
        if(!Inti.checkObjectFieldIsNull(apkInfo)){
            return Inti.GetJson(Resp.fail("错误","信息不全"));
        }
        File files=new File(publicData.JSONAPK);
        System.out.println(apkInfo);

        ToJson.writeJson(files,apkInfo);
        return JSON.parseObject(ToJson.readString(files));
    }

    //留言板信息写入
    @RequestMapping(value = "/mes")
    public JSONObject InsertNotecard(@RequestParam("text")String text ){
        if(text==null){
            return Inti.GetJson(Resp.fail("错误","信息不全"));
        }
        Notecard notecard=new Notecard(Ramdnum.getnum(),text,Ramdnum.getdate());
        sysSonService.InsertNotecard(notecard);
        return Inti.GetJson(sysSonService.SelectNotecard(notecard.getId()));
    }



    @RequestMapping(value = "/mall")
    public JSONArray selectAll(){
        return Inti.GetJsonArr(sysSonService.selectnotecardall());
    }
    //ton通告
 @RequestMapping(value = "/min")
    public JSONObject UpdateNode(Mag mag,@RequestParam(value = "pass" ,required = false)String p){
        if(mag==null){
            return Inti.GetJson(sysSonService.selectmag());
        }
        if (mag.getHomemag()==null){
            return Inti.GetJson(sysSonService.selectmag());
        }
        if(mag.getHomemag().equals("")){
            return Inti.GetJson(sysSonService.selectmag());
        }
         if(!p.equals(publicData.PASS)){
             return Inti.GetJson(Resp.fail("错误","校验么不正确！"));
         }
         System.out.println(mag.getHomemag());
         sysSonService.updatahomemag(mag);
        return Inti.GetJson(sysSonService.selectmag());
    }

    @RequestMapping(value = "/all")
    public JSONObject allmag(@RequestParam(value = "VersionCode",required = false)String v,@RequestParam(value = "type" ,required = false) String type){
        if(type==null){
            if(v==null){
                return Inti.GetJson(sysSonService.selectmag());
            }
            if(sysMapSercice.selectAppmagOne(v)==null){
                sysMapSercice.inserAppmag(new AppMag(v,1));
                return Inti.GetJson(sysSonService.selectmag());
            }else {
                sysMapSercice.updateAppmagnum(v);
                return Inti.GetJson(sysSonService.selectmag());
            }
        }
        //教务系统跳转次数
        if(type.equals("z")) {
            sysSonService.updatazf(k);
            return Inti.GetJson(Resp.success(null,"成功教务系统转跳次数加1"));
        }
        //查课表人数
        if(type.equals("c")){
            sysSonService.UpdatePak(k);
            return Inti.GetJson(Resp.success(null,"成功查课表人数加1"));
        }
        return Inti.GetJson(Resp.fail("400","type:错误"));
    }


    //通过用户id反馈查询
    @RequestMapping(value = "/ufout")
    public JSONArray seleceFeedbackUserid(@RequestParam("userid")String userid){
        return  Inti.GetJsonArr(sysSonService.selectFeedbackUserid(userid));
    }

        //反馈查询
    @RequestMapping(value = "/fout")
    public JSONArray seleceFeedback(){
        return  Inti.GetJsonArr(sysSonService.selectfeedbackall());
    }
    //反馈
    @RequestMapping(value = "/fin")
    public JSONObject insertfeed(@RequestParam(value = "file",required = false)MultipartFile[] files,Feedback feedback){

        feedback.setFeedbackid(Ramdnum.getnum());
        String[] strings= InFile.putAllFile(files,"bee","feedback",feedback.getFeedbackid());
        feedback=Inti.Get(feedback,strings);
        if(!Inti.checkObjectFieldIsNull(feedback)){
            return  Inti.GetJson(Resp.fail("错误","信息不全"));
        }
        sysSonService.insertFeedback(feedback);
        return Inti.GetJson(feedback);
    }

    @RequestMapping(value = "/num")
    public JSONObject Getnum(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("num",webSocket.numsuer());
        return jsonObject;
    }

    @RequestMapping(value = "/find")
    public JSONArray selectAllLike(@RequestParam("str")String str){
        return Inti.GetJsonArr(sysSonService.SelsctAllLike(str));
    }

}
