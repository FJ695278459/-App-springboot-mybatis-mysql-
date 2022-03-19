package com.neuron.etl.controller;
import com.neuron.etl.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.model.master.Test;
import com.neuron.etl.service.master.SysUserService;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author wxl
 * @Date 2020-04-01 19:12
 * @Description TODO
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/t")
public class TestController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping(value = "/f",method = RequestMethod.POST)
    public Resp<JSONObject> test(HttpServletRequest request, @RequestBody String json) throws UnsupportedEncodingException {
        System.out.println("原始==》》》》"+json);

        Test test= JSON.parseObject(json,Test.class);
        System.out.println("转换成Tesu实体:-->>"+test);
        //javad对象转换成JSON字符串
        return Resp.success(Inti.GetJson(test),"实体json字符串");
    }
    @RequestMapping(value = "/t")
    public String p(@RequestParam("file")MultipartFile file){
        Resp resp=InFile.putFileApk(file);
        return (String) resp.getBody();
    }
    @RequestMapping(value = "/s")
    public Resp k(@RequestBody Test test){
        System.out.println(test);
        return Resp.success(Inti.GetJson(test),"成功");
    }
    @RequestMapping(value = "/k")
    public void k(@RequestParam("file")MultipartFile file){

//        long e=Ramdnum.getTimes();
//        test.putFilefileOutputStream(file,"test");
        long three=Ramdnum.getTimes();
//        System.out.println("所需时间：fileOutputStream："+(three-e)+" ms");
//
////
        test.putFilefileOutputStreamArr(file,"test");
        long four= Ramdnum.getTimes();
        System.out.println("所需时间：putFilefileOutputStreamArr："+(four-three)+" ms");

        test.putFileBuff(file,"test");
        long five=Ramdnum.getTimes();

        System.out.println("所需时间：putFileBuff："+(five-four)+" ms");
        long s=Ramdnum.getTimes();
        Resp resp=InFile.putFile(file,"test");
        long e=Ramdnum.getTimes();
        System.out.println("所需时间：transferTo："+(e-s)+" ms");
    }
    @RequestMapping(value = "/l")
    public JSONObject s(@RequestParam(value = "file" ,required = false)MultipartFile[] files,Test test){
        System.out.println(files.length);
        System.out.println(test);
        int i=0;
        JSONObject jsonObject=new JSONObject();
        for (MultipartFile multipartFile : files) {
            jsonObject.put(multipartFile.getName()+(i++),InFile.putFile(multipartFile,"testImg").getBody());
        }
        return jsonObject;
    }
}
