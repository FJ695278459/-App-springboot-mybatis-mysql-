package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.CommentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.*;

/**
 * @Author: FengJie
 * #Description: SysCommentInfoMapper
 * #Date: 2021/5/6 23:51
 */
@Repository
public interface SysCommentInfoMapper {
    //发布评论
    void insert(CommentInfo commentInfo);
    //查询一个
    CommentInfo selectone(@Param("infoid")String id);
    //现实所有
    List<Object> selectAll(@Param("inviid")String invi_id);
    //分页查询
    List<Object> selectson(@Param("inviid")String invi_id,@Param("start")Integer start,@Param("end")Integer end);
    //删除评论
    void deleteone(@Param("infoid")String info);
    void deleteinvi(@Param("inviid")String invi_id);
    //喜欢，点赞+1
    void updateAddlikes(@Param("infoid")String info_id);
    //喜欢，点赞-1
    void updateDonelikes(@Param("infoid")String info_id);
    @Select("select * from commentinfo")
    List<Object> selectInfoAll();
    //通过用户id获取所有评论
    List<Object> selectuser(@Param("userid")String userid);
}
