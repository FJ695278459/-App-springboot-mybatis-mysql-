package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author FengJie
 * #Description CommentInfo
 * #Date: 2021/5/6 21:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//主评论
public class CommentInfo {

    //评论id
    private String infoid;


    //被评论帖子id ***
    private String inviid;
    //评论者id ***
    private String userid;
    //内容 ***
    private String content;

    //评论者名字
    private String username;
    //评论者头像
    private String userhead;


    private Integer likenum;
    private Timestamp intime;
}
