package com.neuron.etl.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.Mag;
import com.neuron.etl.model.master.PhoneLogin;
import com.neuron.etl.model.master.Token;
import com.neuron.etl.service.master.SysLogin;
import com.neuron.etl.service.master.SysSonService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: FengJie
 * #Description: publicData
 * #Date: 2021/5/8 21:39
 */
public class publicData {
    public static boolean compatibleWithJavaBean = false;

    static {
        try {
            String prop = System.getProperty("fastjson.compatibleWithJavaBean");
            if ("true".equals(prop)) {
                compatibleWithJavaBean = true;
            } else if ("false".equals(prop)) {
                compatibleWithJavaBean = false;
            }
        } catch (Throwable ex) {
            // skip
        }
    }

    public static final String P = "C:\\python\\data\\getclass1.py";
    public static final String T= "D:\\poject\\yiqifeng\\trunk\\bee\\data\\544.py";
    public static final String[] USER_NAMES = {"user_name", "user_sex", "user_age", "user_num", "user_phone", "user_pass", "user_son", "user_student", "user_news", "user_token"};
    public static final String[] JSP_COURSE = new String[]{"one_one", "two_one", "three_one", "four_one", "five_one", "six_one", "seven_one", "one_two", "two_two", "three_two", "four_two", "five_two", "six_two", "seven_two", "one_three", "two_three", "three_three", "four_three", "five_three", "six_three", "seven_three", "one_four", "two_four", "three_four", "four_four", "five_four", "six_four", "seven_four", "one_five", "two_five", "three_five", "four_five", "five_five", "six_five", "seven_five"};
    public static final String[] COURSE_NAMES = {"user_son",
            "one_one", "one_two", "one_three", "one_four", "one_five",
            "two_one", "two_two", "two_three", "two_four", "two_five",
            "three_one", "three_two", "three_three", "three_four", "three_five",
            "four_one", "four_two", "four_three", "four_four", "four_five",
            "five_one", "five_two", "five_three", "five_four", "five_five",
            "six_one", "six_two", "six_three", "six_four", "six_five",
            "seven_one", "seven_two", "seven_three", "seven_four", "seven_five"};
    public static final String[] QQINfO={"QQToken","QQname","QQsex","QQHead","QQage"};
    public static final String JSONAPK="C:\\file\\img\\apk\\update.json";
    public static final String PASS="1q2w3e";
    //文字与图片的分割符
    public static final String FG="&image;";
    //用户初始头像
    public static final String HEAD="http://47.101.198.228/image/apk/head.png";
    public static final String PHONE_KEY="d41d8cd98f00b204e980";
    public static final String PHONE_UID="一起蜂bee";
    public static final int YARD=5;
    public static final String USERPASS="e10adc3949ba59abbe56e057f20f883e";
    public static final int SUCCESS=200;//执行成功
    public static final int ERROR_TOKEN=300;//token错误
    public static final int ERROR_YARD=400;//验证码错误
    public static final int ERROR_PASS=600;//密码或者用户名错误
    public static final int ERROR_NULL=700;//信息不全
    public static final int ERROR_ALEAR=700;//已经存在用户，无法注册
    public static final int ERROR_WEIZI=500;//未知错误，服务器段的错误
    public static final String FILE_ALL="C:\\file\\img\\";
    public static final String FILE_INVI="C:\\file\\img\\Imagepath\\invi\\";

}
