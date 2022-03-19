package com.neuron.etl.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.Collect;
import com.neuron.etl.service.master.SysCollentService;
import com.neuron.etl.util.Inti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;



/**
 * @Author: FengJie
 * #Description: SysCollentController
 * #Date: 2021/5/24 16:49
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/con")
public class SysCollentController {
    @Autowired
    SysCollentService sysCollentService;



    @RequestMapping(value = "/in")
    public JSONObject insertCollent(Collect collect){
      return  sysCollentService.insetrhistory(collect);
    }
    //所有搜藏的帖子
    @RequestMapping(value = "/o")
    public JSONArray selectCollent(@RequestParam("userid")String id){
        List<Object> objects=sysCollentService.Selecthistory(id);
        return Inti.GetJsonArr(objects);
    }
    @RequestMapping(value = "/num")
    public JSONObject SelectNumUSerid(@RequestParam("userid")String userid){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("num",sysCollentService.numBerCollectSeve(userid));
        return jsonObject;
    }
    //删除帖子
    @RequestMapping(value = "/de")
    public void delectCollent(@RequestParam("collectid")String[] ids){
        for (String id : ids) {
            sysCollentService.deletehistory(id);
        }
    }

}
