package com.neuron.etl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author: FengJie
 * #Description: GetTime
 * #Date: 2021/6/25 23:26
 */
public class GetTime {
    public static long getTimeGap(String oldTime,String newTime){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long NTime =df.parse(newTime).getTime();
            //从对象中拿到时间
            long OTime = df.parse(oldTime).getTime();
            long diff=(NTime-OTime)/1000/60;
            return diff;
        } catch (ParseException e) {
            return 0;
        }
    }
}
