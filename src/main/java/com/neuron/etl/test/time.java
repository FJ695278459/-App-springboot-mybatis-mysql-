package com.neuron.etl.test;

import com.alibaba.fastjson.JSONArray;
import com.neuron.etl.util.GetTime;
import com.neuron.etl.util.Jpyhton;
import com.neuron.etl.util.Ramdnum;
import com.neuron.etl.util.publicData;
import com.sun.javafx.collections.MappingChange;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: time
 * #Date: 2021/6/25 23:32
 */
public class time {
    public static void main(String[] args) {
        String userid="201917190213";
        String password="1q2w3e";
        JSONArray jsonArray= Jpyhton.JSONScore(publicData.P,userid,password);

    }




}
