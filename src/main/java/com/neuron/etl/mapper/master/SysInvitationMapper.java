package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.Invitation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysInvitationMapper
 * #Date: 2021/5/6 23:55
 */

@Repository
public interface SysInvitationMapper {
   //插入帖子
   void insertAll(Invitation invitation);
   List<Object> selectAll();
   Invitation selectOne(@Param("id")String id);
   //分页查询
   List<Object> selectsSon(@Param("start") Integer  start, @Param("end") Integer end);
   //删除帖子
   void delete(@Param("inviid")String invi_id);
   //点赞
   void updateAddlikes(@Param("inviid")String invi_id);
   //不喜欢
   void updateDonelikes(@Param("inviid")String invi_id);
   //回复数量+1
   void updateAddReply(@Param("inviid")String invi_id);
   //-1
   void updateDoneReply(@Param("inviid")String inviid);
   //阅读数量
   void updateAddReadly(@Param("inviid")String invi_id);
   //搜藏数+1
   void updateAddCollect(@Param("inviid")String invi_id);
   //-1
   void updateDoneCollect(@Param("inviid")String inviid);
   //用户id
   List<Object> selectOneUserid(@Param("userid")String userid);
   //帖子个数
   Integer numBerInvi();
   //模糊查询
   List<Object>  selsectLike(@Param("str")String str);

}
