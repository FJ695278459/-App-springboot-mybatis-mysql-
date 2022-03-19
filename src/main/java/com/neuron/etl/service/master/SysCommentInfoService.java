package com.neuron.etl.service.master;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.CommentInfo;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: SysCommentInfoService
 * #Date: 2021/5/6 23:59
 */
//评论帖子

public interface SysCommentInfoService {
    //评论
    JSONObject insertCommentInfo(CommentInfo commentInfo);
    //查询一个
    CommentInfo selectone(String id);
    //查询一个帖子下的所有回复
    List<Object> selectAllCommentInfo(String invi_id);
    //分页查询
    List<Object> selectSonCommentInfo(String invi_id,Integer start,Integer end);
    //删除
    void deleteCommentInfo(String invi_id);
    //喜欢点赞+1
    void updateAddlikes(String info_id);
    //喜欢点赞-1
    void updateDonelikes(String info_id);
    List<Object> selectAll();
    //通过用户id获取所有评论
    List<Object> selectUser(String userid);
}
