package com.neuron.etl.controller;

import com.neuron.etl.model.master.ChatData;
import com.neuron.etl.model.master.ChatOne;
import com.neuron.etl.service.master.web.WebScoteAll;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.Ramdnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: FengJie
 * #Description: WebSockekAs
 * #Date: 2021/6/14 12:08
 */

@RestController
@RequestMapping(value = "/socket")
public class WebSockekAs {

    @Autowired
    WebScoteAll webScoteAll;


    @RequestMapping(value = "/one")
    public void SocketChat(ChatOne chatOne,@RequestParam(value = "file",required = false)MultipartFile[] files){
        chatOne.setIntime(Ramdnum.getdate());
        webScoteAll.sendOne(chatOne);
    }

}
