package com.neuron.etl.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: FengJie
 * #Description: GetIp
 * #Date: 2021/5/8 18:14
 */
public class GetIp {
    public static String getip(){
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String s= String.valueOf(ip);
        String p=s.substring(s.lastIndexOf("/")+1);
        return p;
    }
}
