package com.neuron.etl.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.neuron.etl.model.master.ApkInfo;
import com.neuron.etl.service.master.SysCommentInfoService;
import com.neuron.etl.service.master.SysCommentReplyService;
import com.neuron.etl.service.master.SysInvitationService;
import com.neuron.etl.service.master.impl.SysCommentInfoServiceImpl;
import com.neuron.etl.service.master.impl.SysCommentReplyServiceImpl;
import com.neuron.etl.service.master.impl.SysInvitationServiceImpl;
import com.neuron.etl.util.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.*;

/**
 * @Author: FengJie
 * #Description: JyTest
 * #Date: 2021/5/8 21:40
 */
public class JyTest {
    public static void main(String[] args) {
//        String[] s = {"201917190179", "1q2w3e"};
//        Map<String, Object> map = Jpyhton.transimtData(publicData.P, s);
//        System.out.println(map);
        SysCommentReplyService sysCommentReplyService=new SysCommentReplyServiceImpl();
        SysInvitationService sysInvitationService=new SysInvitationServiceImpl();
        SysCommentInfoService sysCommentInfoService=new SysCommentInfoServiceImpl();
    }

    public static void phone(String phone,String code){
        
    }
    public static void authCode(String phoneNumber){

        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "8a216da87a332d53017a41e157e10623";
        String accountToken = "主账号令牌AUTH TOKEN";
        //请使用管理控制台中已创建应用的APPID
        String appId = "管理控制台中已创建应用的APPID";
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        //随机生成6位数字验证码
        String code = String.valueOf(Math.random()).substring(2, 8);
        System.out.println("随机生成的6位验证码是： " + code);
        String to = phoneNumber;
        String templateId= "1";
        String[] datas = {code,"10"};
//        String subAppend="1234";  //可选 扩展码，四位数字 0~9999
//        String reqId="fadfafas";  //可选 第三方自定义消息id，最大支持32位英文数字，同账号下同一自然天内不允许重复
        //HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas);
        HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }

    }



    public static JSONObject readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return JSON.parseObject(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
