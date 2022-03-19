package com.neuron.etl.service.master;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.*;
import java.util.List;
/**
 * @Author: FengJie
 * #Description: SysInvitationService
 * #Date: 2021/5/7 00:02
 */


//帖子操作接口
public interface SysInvitationService {
    //将帖子信息插入数据库
    JSONObject InsertInvitation(Invitation invitation);
    //查询所有帖子
    List<Object> selsctAllInvitation();
    //查询其中一个帖子
    Invitation selectOneInvitation(String id);
    //分页查询
    List<Object> selectInvitionSon(Integer start, Integer end);
    //用户id擦寻
    List<Object> selectOneUserid(String userid);
    void deleteInvitation(String invi_id);
    void updateAddlikes(String invi_id);
    void updateDonelikes(String invi_id);
    void updateAddCollect(String invi_id);
    void updateDoneCollect(String inviid);
    void updateAddReadly(String invi_id);
    void updateAddReply(String invi_id);
    void updateDoneReply(String inviid);
    //帖子个数
    Integer numBerInvi();
    //模糊查询
    List<Object> SelectLike(String str);
}
