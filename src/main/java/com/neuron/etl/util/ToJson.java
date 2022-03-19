package com.neuron.etl.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.collections.MappingChange;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author: FengJie
 * #Description: MapToJson
 * #Date: 2021/5/8 23:03
 */
public class ToJson {
    public static JSONObject Get(Map<String,Object> map){
    JSONObject jsonObject=new JSONObject();
        for (String s : map.keySet()) {
            jsonObject.put(s,map.get(s));
        }
        return jsonObject;
    }
//    public static Map<String,Object> Get(JSONObject jsonObject){
//            Map<String,Object> map=new HashMap<>();
//
//        }

    public static String readString(File file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            StringBuilder content = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    /**
     * 写入文件
     */
    public static void writeString(File file,String content){

        BufferedWriter bufferedWriter = null;
        try {
            FileOutputStream fr = new FileOutputStream(file);
            OutputStreamWriter brs = new OutputStreamWriter(fr,"utf-8");
            bufferedWriter = new BufferedWriter(brs);
            System.out.println("content:"+content);
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
            fr.close();
            brs.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                //关闭流释放资源
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 读取json类型的文件
     * @param systemSetting
     * @param c
     * @param <T>
     * @return
     */
    public static  <T> T readJson(File systemSetting,Class<T> c) {
        String content = readString(systemSetting);
        return JSON.parseObject(content,c);
    }

    /**
     * 写入json类型的文件
     * @param systemSetting
     * @param o
     */
    public static void writeJson(File systemSetting, Object o) {
        String jsonString = JSON.toJSONString(o);
        writeString(systemSetting,jsonString);
    }

}
