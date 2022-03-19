package com.neuron.etl.service.master.impl;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.mapper.master.SysCommentInfoMapper;
import com.neuron.etl.mapper.master.SysCommentReplyMapper;
import com.neuron.etl.mapper.master.SysInvitationMapper;
import com.neuron.etl.mapper.master.SysUserMapper;
import com.neuron.etl.model.master.Invitation;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysCommentInfoService;
import com.neuron.etl.service.master.SysInvitationService;
import com.neuron.etl.util.InFile;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.publicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysInvitationImpl
 * #Date: 2021/5/7 00:08
 */

@Service
public class SysInvitationServiceImpl implements SysInvitationService {

    @Autowired
    private SysInvitationMapper invitationMapper;
    @Autowired
    private SysCommentInfoMapper sysCommentInfoMapper;
    @Autowired
    private SysCommentReplyMapper sysCommentReplyMapper;
    @Autowired
    private SysUserMapper userMapper;
    //发布帖子
    @Override
    public JSONObject InsertInvitation(Invitation invitation) {
        User user=userMapper.selectOne(invitation.getUserid());
        JSONObject j;
        invitation.setUserhead(user.getUserhead());
        invitation.setUsername(user.getUsername());
        if (!Inti.checkObjectFieldIsNull(invitation)){
            return null;
        }else {
            invitationMapper.insertAll(invitation);
            //增加用户发帖数
            userMapper.updatePostnumbertinfo(user.getUserid());
            j=Inti.GetJson(invitation);
            j.put("postnumber",user.getPostnumber()+1);
            return j;
        }
    }

    //查询所以帖子
    @Override
    public List<Object> selsctAllInvitation() {
        return invitationMapper.selectAll();
    }

    //查寻一个帖子
    @Override
    public Invitation selectOneInvitation(String id) {
        return invitationMapper.selectOne(id);
    }

    //分页查询
    @Override
    public List<Object> selectInvitionSon(Integer start, Integer end) {
        return invitationMapper.selectsSon(start,end);
    }

    @Override
    public List<Object> selectOneUserid(String userid) {
        return invitationMapper.selectOneUserid(userid);
    }

    //删除帖子
    @Override
    public void deleteInvitation(String invi_id) {
        sysCommentReplyMapper.deleteinvi(invi_id);
        sysCommentInfoMapper.deleteinvi(invi_id);
        invitationMapper.delete(invi_id);
        String spatn= publicData.FILE_ALL+"Imagepath\\invi\\"+invi_id;
        InFile.deleteFiles(spatn);
    }

    //喜欢+1
    @Override
    public void updateAddlikes(String invi_id) {
        invitationMapper.updateAddlikes(invi_id);
    }
    //不喜欢+1
    @Override
    public void updateDonelikes(String invi_id) {
        invitationMapper.updateDonelikes(invi_id);
    }

    //收藏数+1
    @Override
    public void updateAddCollect(String invi_id) {
        invitationMapper.updateAddCollect(invi_id);
    }

    @Override
    public void updateDoneCollect(String inviid) {
        invitationMapper.updateDoneCollect(inviid);
    }

    //阅读数+1
    @Override
    public void updateAddReadly(String invi_id) {
        invitationMapper.updateAddReadly(invi_id);
    }

    //回复数+1
    @Override
    public void updateAddReply(String invi_id) {
        invitationMapper.updateAddReply(invi_id);
    }

    //回复数减一
    @Override
    public void updateDoneReply(String inviid) {
        invitationMapper.updateDoneReply(inviid);

    }

    @Override
    public Integer numBerInvi() {
        return invitationMapper.numBerInvi();
    }

    @Override
    public List<Object> SelectLike(String str) {
        return invitationMapper.selsectLike(str);
    }
}
