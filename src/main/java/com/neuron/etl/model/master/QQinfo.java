package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: QQinfo
 * @Author: FengJie
 * Date: 2021/5/6 21:17
 **/

//QQ信息
@Data
@AllArgsConstructor
@NoArgsConstructor

public class QQinfo {
    //qqtoken
    private String QQToken;
    //qq网名
    private String QQname;
    //qq性别
    private String QQsex;
    //QQ头像
    private String QQHead;
    //QQ年龄
    private Integer QQage;
}
