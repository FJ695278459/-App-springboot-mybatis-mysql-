package com.neuron.etl.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.*;

import javax.activation.CommandInfo;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Pattern;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import java.lang.reflect.Field;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
/**
 * @Author: FengJie
 * #Description: Inti
 * #Date: 2021/5/8 21:31
 */

//初始化

//工具箱
public class Inti{
    public static boolean okNull(QQinfo qinfo){
        if(qinfo.getQQage()==null || qinfo.getQQHead() ==null ||  qinfo.getQQname()==null||qinfo.getQQToken()==null ||qinfo.getQQsex()==null){
            return true;
        }
        return false;
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

    public static boolean okNull(ApkInfo apkInfo){
        if(apkInfo.getApkMd5()==null || apkInfo.getDownloadUrl()==null || apkInfo.getUpdateStatus()==null || apkInfo.getVersionName()==null
         || apkInfo.getVersionCode()==null || apkInfo.getApkSize()==null||apkInfo.getModifyContent()==null){
            return false;
        }
        return true;
    }
    public static CommentInfo Get(CommentInfo commentInfo,String[] strings){
//        commentInfo.setInfoid(Ramdnum.getnum());
        commentInfo.setIntime(Ramdnum.getdate());
        commentInfo.setLikenum(0);

        commentInfo.setContent(commentInfo.getContent()+getStringhead(strings));
        return commentInfo;
    }
    public static CommentReply Get(CommentReply commentReply,String[] strings){
//        commentReply.setReplyid(Ramdnum.getnum());
        commentReply.setIntime(Ramdnum.getdate());
        commentReply.setLikenum(0);

        commentReply.setContent(commentReply.getContent()+getStringhead(strings));
        return commentReply;
    }

    public static Feedback Get(Feedback feedback,String[] strings){
        feedback.setIntime(Ramdnum.getdate());
        feedback.setContent(feedback.getContent()+getStringhead(strings));
        return feedback;
    }

    private static String getStringhead(String[] strings){
        if (strings==null){
            return "";
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (String string : strings) {
            stringBuffer.append(publicData.FG+string);
        }
        return String.valueOf(stringBuffer);
    }

    public static Invitation Get(Invitation invitation ,String[] strings){
//        invitation.setInviid(Ramdnum.getnum());
        invitation.setBoardid("1234");
        invitation.setCollects(0);
        invitation.setPostTime(Ramdnum.getdate());
        invitation.setLikes(0);
        invitation.setReadly(0);
        invitation.setReply(0);

        invitation.setContent(invitation.getContent()+getStringhead(strings));
        return invitation;
    }


    public static User Get(QQinfo qinfo){
        User user= new User();
        user=Getjib(user);
        user.setUsername(qinfo.getQQname());
        user.setUserhead(qinfo.getQQHead());
        user.setSex(qinfo.getQQsex());
        user.setAge(qinfo.getQQage());
        user.setQQToken(qinfo.getQQToken());
        return user;
    }

    public static User setUser(String phone){
        User user=new User();
        user.setPhone(phone);
        user=Getjib(user);
        user.setUsername(phone);
        return user;
    }
    public static User Getjib(User user){
        user.setUserid(Ramdnum.getnum());
        user.setUserpass(publicData.USERPASS);
        user.setUsername(user.getUserid());
        user.setUserhead(publicData.HEAD);
        user.setRegTime(Ramdnum.getdate());
        user.setLastLogTime(Ramdnum.getdate());
        user.setSignature("空空如也...");
        user.setPostnumber(0);
        user.setCollects(0);
        user.setScore(0);
        return user;
    }
    //用户信息更新
    public static User UpUser(User u1,User u2){
        if(u1.getUsername()!=null ){
            u2.setUsername(u1.getUsername());
        }
        if(u1.getAge()!=null){
            u2.setAge(u1.getAge());
        }
        if(u1.getSchool()!=null ){
            u2.setSchool(u1.getSchool());
        }
        if(u1.getSex()!=null){
            u2.setSex(u1.getSex());
        }
        if(u1.getSon()!=null){
            u2.setSon(u1.getSon());
        }
        if(u1.getUserhead()!=null ){
            if(!u2.getUserhead().equals(publicData.HEAD)){
                String spaht=GetLastPath(u2.getUserhead());
                System.out.println(spaht);
                DeleFile(spaht);

                String[] xes = spaht.split("X.");

                DeleFile(xes[0]+"."+xes[1]);
            }
            u2.setUserhead(u1.getUserhead());
        }
        if(u1.getSignature()!=null){
            u2.setSignature(u1.getSignature());
        }if(u1.getUserpass()!=null){
            u2.setUserpass(u1.getUserpass());
        }if(u1.getScore()!=null){
            u2.setScore(u1.getScore());
        }
        return u2;
    }

    public static String GetLastPath(String head){
        String s=head.split("/image/")[1];
        String spaht=publicData.FILE_ALL+s;
        spaht=spaht.replace("/","\\");
        return spaht;
    }

    public static boolean checkObjectFieldIsNull(Object object) {
        if (null == object) {
            return false;
        }
        try {
            for(Field field : object.getClass().getDeclaredFields()){
                field.setAccessible(true);
                if(StringUtils.isEmpty(field.get(object))){
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean DeleFile(String spath){
        final boolean[] b = {false};
        new Thread(new Runnable() {
            @Override
            public void run() {
               b[0] = InFile.DeleteFolder(spath);
            }
        }).start();
        return b[0];
    }

    public static void DeleFile2(String spath){
        new Thread(new Runnable() {
            @Override
            public void run() {
                new File(spath).delete();
            }
        }).start();
    }

    public static JSONObject GetJson(Object o){
        String jsonObject=  JSONObject.toJSONString(o);
        return JSONObject.parseObject(jsonObject);
    }
//
//    public static boolean isMobile(String mobile) {
//        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(16[5,6])|(17[0-8])|(18[0-9])|(19[1、5、8、9]))\\d{8}$";
//        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//        Matcher m = p.matcher(mobile);
//        return m.matches();
//    }

        public static JSONArray GetJsonArr(List<Object> o){
        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=null;
        for (Object o1 : o) {
            jsonObject=GetJson(o1);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

//    public static boolean Token(String token){
//        String s1=token.split("-")[0];
//        if(token.equals(publicData.TOKEN.get(s1))){
//            return true;
//        }
//        return false;
//    }


    public static JSONObject TokenSuccess(){
        JSONObject j=new JSONObject();
        j.put("code",publicData.SUCCESS);
        j.put("message","token校验成功");
        return j;
    }

    public static JSONObject TokenError(){
        JSONObject j=new JSONObject();
        j.put("code",publicData.ERROR_TOKEN);
        j.put("message","token校验失败，重新登录");
        return j;
    }

    public static JSONObject getJSonFromString(String s){
        return (JSONObject) JSON.parse(s);
    }

    public static boolean dateAd(Timestamp a,Timestamp b){
        if(a.before(b)){
            return true;
        }
        return false;
    }
//
//    public static JSONArray GetJsonArrHistory(List<Object> o){
//        JSONArray jsonArray=new JSONArray();
//        JSONObject jsonObject=null;
//        for (Object o1 : o) {
//            jsonObject=GetJson(o1);
//            System.out.println(jsonObject);
//            jsonArray.add(jsonObject);
//        }
//        return jsonArray;
//    }
}
