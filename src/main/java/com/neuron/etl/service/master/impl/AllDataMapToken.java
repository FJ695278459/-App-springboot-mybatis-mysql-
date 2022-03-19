//package com.neuron.etl.service.master.impl;
//
//import com.neuron.etl.model.master.Token;
//import com.neuron.etl.service.master.SysLogin;
//import com.neuron.etl.util.publicData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//
///**
// * @Author: FengJie
// * #Description: AllDataMapToken
// * #Date: 2021/7/2 01:04
// */
//
//
//@Service
//public class AllDataMapToken {
//    @Autowired
//    private SysLogin sysLogin;
//
//    @PostConstruct
//    public void getMapToken(){
//        for (Token token : sysLogin.SelsctTokenAll()) {
//            publicData.TOKEN.put(token.getUserid(),token.getToken());
//        }
//    }
//
//    public void Gs(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true){
//                        Thread.sleep(1000*10);
//                        System.out.println(publicData.TOKEN.size());
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//}
