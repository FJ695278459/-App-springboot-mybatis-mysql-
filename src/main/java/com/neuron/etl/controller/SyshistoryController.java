package com.neuron.etl.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.History;
import com.neuron.etl.service.master.SysHistoryService;
import com.neuron.etl.util.Inti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: SyshistoryController
 * #Date: 2021/5/24 16:26
 */
@RestController
@RequestMapping("/his")
public class SyshistoryController {
    @Autowired
    private  SysHistoryService sysHistoryService;

    //插入
    @RequestMapping(value = "/in")
    public void insertHistory(History history){
        sysHistoryService.insetrhistory(history);
    }

    //查询一个用户的所有历史浏览
    @RequestMapping(value = "/o")
    public JSONArray selectSon(@RequestParam("userid")String user_id){
        List<Object> historyList= sysHistoryService.Selecthistory(user_id);
        return Inti.GetJsonArr(historyList);
    }
    @RequestMapping(value = "/num")
    public JSONObject SelectNumUSerid(@RequestParam("userid")String userid){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("num",sysHistoryService.numBerHistotySeve(userid));
        return jsonObject;
    }

    //删除历史帖子
    @RequestMapping(value = "/de")
    public void deleteOne(@RequestParam("historyid")String[] ids){
        for (String id : ids) {
            sysHistoryService.deletehistory(id);
        }
    }

}
