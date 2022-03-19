package com.neuron.etl.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.AppMag;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.service.master.SysMapSercice;
import com.neuron.etl.util.Inti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FengJie
 * #Description: SysMagController
 * #Date: 2021/6/7 14:31
 */

@RestController
@RequestMapping(value = "/mag")
public class SysMagController {
    @Autowired
    private SysMapSercice sysMapSercice;

    @RequestMapping(value = "/upmag")
    public JSONArray upAppmag(@RequestParam(value = "VersionCode",required = false)String v){
        if(v==null){
            return Inti.GetJsonArr(sysMapSercice.selectAppmagAll());
        }
        if(sysMapSercice.selectAppmagOne(v)==null){
            sysMapSercice.inserAppmag(new AppMag(v,1));
            return null;
        }else {
            sysMapSercice.updateAppmagnum(v);
            return null;
        }
    }

}
