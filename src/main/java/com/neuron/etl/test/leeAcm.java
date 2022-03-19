package com.neuron.etl.test;

import com.alibaba.fastjson.JSONArray;
import com.neuron.etl.util.Jpyhton;
import jdk.nashorn.internal.parser.Scanner;
import org.attoparser.dom.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * @Author: FengJie
 * #Description: leeAcm
 * #Date: 2021/5/25 19:45
 */
public class leeAcm <T>{
    public static   void main(String[] args) throws IOException {
        String url="http://47.101.198.228/bee/ce?user_son=201917190179&user_pass=wdw";

        String html=getHTml(url);
        JSONArray jsonArray=getJSONARRy(html);
    }


    private static String getHTml(String url) throws IOException {
        URL url1=new URL(url);
        URLConnection connection=url1.openConnection();

        InputStream w=connection.getInputStream();

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(w,"utf-8"));

        String ulir="";
        StringBuffer buffer=new StringBuffer();

        while ((ulir=bufferedReader.readLine())!=null){
            System.out.println(ulir);
            buffer.append(ulir);


        }
        return String.valueOf(buffer);
    }

    private static JSONArray getJSONARRy(String json){
        JSONArray jsonArray=JSONArray.parseArray(json);

        for (Object o : jsonArray) {
            System.out.println(o);
        }
        return jsonArray;
    }
}
