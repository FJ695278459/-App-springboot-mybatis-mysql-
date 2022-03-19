package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.CommentReply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.*;

/**
 * @Author: FengJie
 * #Description: SysCommentRepluMapper
 * #Date: 2021/5/6 23:56
 */

//回复评论
@Repository
public interface SysCommentReplyMapper {
    //回复
    void insert(CommentReply commentReply);
    //查询一个
    CommentReply selectone(@Param("replyid")String id);
    //查询所有回复
    List<Object> selectAll(@Param("infoid")String infi_id);
    //
    List<Object> selectinvi(@Param("inviid")String invi_id);
    //分页查询
    List<Object> selectinfo(@Param("infoid")String infi_id,@Param("start")Integer start,@Param("end")Integer end);
    //删除
    void deleteone(@Param("replyid")String reply_id);
    void  deleteinfo(@Param("infoid")String info_id);
    void deleteinvi(@Param("inviid")String invi_id);
    //喜欢+1
    void updateAddlikes(@Param("replyid")String reply);
    //喜欢-1
    void updateDonelikes(@Param("replyid")String reply);
    @Select("select * from commentreply")
    List<Object> selectReplyAll();

    List<Object> selectuser(@Param("userid")String userid);
}
