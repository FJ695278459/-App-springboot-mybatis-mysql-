package com.neuron.etl.util;

import com.baomidou.dynamic.datasource.RandomDynamicDataSourceStrategy;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.io.BufferedReader;
import java.util.UUID;

/**
 * @Author: FengJie
 * #Description: Ramdnum
 * #Date: 2021/5/8 15:50
 */


//获取随机id
public class Ramdnum {


    public static String getnum(){
        long s=System.currentTimeMillis();
        Random random=new Random();
        StringBuffer stringBuffer=new StringBuffer();
        int i=3;
        for (int i1 = 0; i1 < i; i1++) {
            stringBuffer.append(random.nextInt(10));
        }
        stringBuffer.append(s);
        return String.valueOf(stringBuffer);
    }


    //生成验证码
    public static String getyan(){
        Random random=new Random();
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < 5; i++) {
            stringBuffer.append(random.nextInt(10));
        }
        return String.valueOf(stringBuffer);
    }

//    public static Date getdate(){
//
//        return new Date(System.currentTimeMillis());
//    }
    public static Timestamp getdate(){
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }
    public static String getTimeString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStringParse = sdf.format(date);
        return dateStringParse;
    }
    public static String getTime(Timestamp timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar calendar = Calendar.getInstance();
//        Date date = calendar.getTime();
        String dateStringParse = sdf.format(timestamp);
        return dateStringParse;
    }
    public static String getTime(Data timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar calendar = Calendar.getInstance();
//        Date date = calendar.getTime();
        String dateStringParse = sdf.format(timestamp);
        return dateStringParse;
    }
    public static String getTOken(String id){
        String token=id+"-"+getTimes()+"-"+UUID.randomUUID();
        return token;
    }
    public static String getTOken(){
        String token=getTimes()+"-"+UUID.randomUUID();
        return token;
    }
    public static long getTimes() {
        return System.currentTimeMillis();
    }

}
