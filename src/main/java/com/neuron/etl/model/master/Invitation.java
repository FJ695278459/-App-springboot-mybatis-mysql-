package com.neuron.etl.model.master;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Date;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor

//帖子表
public class Invitation {

    //发帖人id ***
    private String userid;
    //内容 ***
    private String content;
    //标题 ***
    private String title;

    //id
    private String inviid;
    //用户头像
    private String userhead;
    //用户名字
    private String username;
    //发帖时间

    private Timestamp postTime;
    //模块id
    private String Boardid;
    //点赞数量
    private Integer likes;
    //收藏数量
    private Integer collects;
    //阅读数量
    private Integer readly;
    //回复数量
    private Integer reply;
}
