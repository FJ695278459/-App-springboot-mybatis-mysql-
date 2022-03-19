package com.neuron.etl.service.master.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.controller.WebSockekAs;
import com.neuron.etl.mapper.master.SysUserMapper;
import com.neuron.etl.model.master.ChatOne;
import com.neuron.etl.model.master.User;
import com.neuron.etl.model.master.UserWeb;
import com.neuron.etl.service.master.SysUserService;
import com.neuron.etl.service.master.impl.SysUserServiceImpl;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.Ramdnum;
import com.neuron.etl.util.publicData;
import com.sun.javafx.collections.MappingChange;
import lombok.Data;
import org.aspectj.util.SoftHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * @Author: FengJie
 * #Description: WebScoteAll
 * #Date: 2021/7/23 15:11
 */
@ConditionalOnClass(value = WebSocketConfig.class)
@Data
@ServerEndpoint(value = "/web/{userid}")
@Service
public class WebScoteAll {

    SysUserService sysUserService=new SysUserServiceImpl();

    public static Map<String,UserWeb> map=new SoftHashMap<>();
    private Session  session;
    private String userid;
    /**
     * @author FengJie
     * @date 2021-07-23 14:53
     * 用户链接
     */

    public int getNum(){
        return map.size();
    }

    @OnOpen
    public void onOpne(@PathParam("userid") String sid, Session session) {
        this.session=session;
        this.userid=sid;
        map.put(sid,new UserWeb(sid,session, Ramdnum.getdate()));
        sendAll();
    }

    private void sendAll(){
        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("num",map.size());
            jsonObject.put("name",userid);
            onMessage(String.valueOf(jsonObject),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnClose
    public void onClose() {
        map.remove(this.userid);
        sendAll();
    }
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        for (UserWeb value : map.values()) {
            senMaee(message,value.getSession());
        }
    }
    //发送单个消息
    public void senMaee(String mess,Session session) throws IOException {
        session.getBasicRemote().sendText(mess);
    }


    public void sendOne(ChatOne chat){
        try {
            String userid=chat.getTouserid();
            Session session=map.get(userid).getSession();
            String s=String.valueOf(Inti.GetJson(chat));
            senMaee(s,session);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误！");
        error.printStackTrace();

    }


}
