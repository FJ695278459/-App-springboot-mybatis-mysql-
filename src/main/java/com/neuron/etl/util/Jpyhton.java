package com.neuron.etl.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @Author: FengJie
 * #Description: Jpyhton
 * #Date: 2021/5/8 21:36
 */
public class Jpyhton {

    public static Map<String, Object> transimtData(String path, String... arg) {
        StringBuffer stringBuffer = new StringBuffer();
        Map<String, Object> map = null;
        int a = arg.length;
        String str[] = new String[a + 2];
        str[0] = "python";
        str[1] = path;
        int i = 2;
        for (String s : arg) {
            str[i] = s;
            i++;
        }

        try {
            Process process = Runtime.getRuntime().exec(str);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            CourseList c = new CourseList(arg[0]);

            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//                getJSonScore(line);
//                //System.out.println(line);
                c.geuCousre(line);
                stringBuffer.append(line);
            }
            map = c.getStringObjectMap();
            in.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }


    public static JSONArray JSONScore(String path, String... arg) {
        JSONArray jsonArray=new JSONArray();
        int a = arg.length;
        String str[] = new String[a + 2];
        str[0] = "python";
        str[1] = path;
        int i = 2;
        for (String s : arg) {
            str[i] = s;
            i++;
        }
        try {
            Process process = Runtime.getRuntime().exec(str);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;

            while ((line = in.readLine()) != null) {
                line=Cur(line);
                jsonArray .add(getJSonScore(line));
            }
            in.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println(jsonArray);

        return jsonArray;
    }


    private static JSONObject getJSonScore(String ls){
        String[] strls=publicData.COURSE_NAMES;
        int i=1;
        JSONObject jsonObject=new JSONObject();
        String[] strings=ls.split("], \\[");

        for (String string : strings) {
            String[] strings1=string.split("', '");
            for (String s : strings1) {
                s=s.replace("'","");
                jsonObject.put(strls[i++],s);

            }
        }
//        System.out.println(jsonObject);
        return jsonObject;
    }



    public static String Cur(String str){

        /* 开始截取 */
        String result = str.substring(2, str.length()-2);

        return result;
    }



}
