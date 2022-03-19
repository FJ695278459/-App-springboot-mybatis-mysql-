package com.neuron.etl.service.master;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.CommentReply;
import java.util.*;

/**
 * @Author: FengJie
 * #Description: SysCommentRepluService
 * #Date: 2021/5/6 23:59
 */

//回复评论
public interface SysCommentReplyService {
    //回复评论
    JSONObject InsertCOmmentReply(CommentReply commentReply);
    //查询一个
    CommentReply selectone(String id);
    //得到所有回复
    List<Object> selectAllCommentReply(String id);
    //
    List<Object> selectinfoCommentInvi(String invi_id);
    //分页查询回复
    List<Object> selectSonCommentReply(String id,Integer strat,Integer end);
    //删除回复
    void deleteCommentReply(String reply_id);
    void updateAddlikes(String reply_id);
    void updateDonelikes(String reply_id);
    List<Object> selectAll();

    List<Object> SelecUserAll(String userid);
}
