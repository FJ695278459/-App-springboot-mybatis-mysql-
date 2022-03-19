package com.neuron.etl.service.master.impl;

import com.neuron.etl.controller.WebSockekAs;
import com.neuron.etl.model.master.*;
import com.neuron.etl.service.master.IWebSocket;
import com.neuron.etl.service.master.web.WebScoteAll;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.Ramdnum;
import com.sun.javafx.collections.MappingChange;
import lombok.Data;
import org.aspectj.util.SoftHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: WebScodeImp
 * #Date: 2021/7/23 14:44
 */

@Service
public  class WebScodeImp implements IWebSocket {

    @Autowired
    WebScoteAll webScoteAll;
    public static List<UserWeb> userWebs=new  ArrayList();

    public static Map<String,List<UserWeb>> stringListMap=new SoftHashMap<>();
    @Override
    public Crowd CreationCrowd(String name, Integer numMAX) {
        Crowd crowd = new Crowd(Ramdnum.getnum(),1,numMAX,name,Ramdnum.getdate());

        return crowd;
    }

    @Override
    public void PutSentOne(String json) {
        
    }

    @Override
    public void PutSentSum(String json) {

    }

    @Override
    public void PutSentSys(String s) throws IOException {
        Map maps=WebScoteAll.map;
        for (Object value : maps.values()) {
            UserWeb userWeb=(UserWeb)value;
            webScoteAll.senMaee(s,userWeb.getSession());
        }
    }

    @Override
    public int numsuer() {
        return webScoteAll.getNum();
    }
}
