package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Author: FengJie
 * #Description: CommentReply
 * #Date: 2021/5/6 22:32
 */

//回复评论
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentReply {
    //回复id
    private String replyid;

    //所属帖子id ***
    private String inviid;
    //被回复的评论id ***
    private String infoid;
    //评论者id ***
    private String userid;
    //内容***
    private String content;

    //名字
    private String username;
    //评论者头像
    private String userhead;
    //发送时间
    private Timestamp intime;
    //点赞数
    private Integer likenum;

}
