package com.neuron.etl.service.master.impl;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.mapper.master.*;
import com.neuron.etl.model.master.CommentInfo;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysCommentInfoService;
import com.neuron.etl.util.InFile;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.publicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysCommentInfoImpl
 * #Date: 2021/5/7 00:07
 */

@Service
public class SysCommentInfoServiceImpl implements SysCommentInfoService {
    @Autowired
    private SysCommentInfoMapper sysCommentInfoService;
    @Autowired
    private SysCommentReplyMapper sysCommentReplyMapper;
    @Autowired
    private SysUserMapper userMapper;
    //发布评论
    @Override
    public JSONObject insertCommentInfo(CommentInfo commentInfo) {
        User user=userMapper.selectOne(commentInfo.getUserid());
        commentInfo.setUserhead(user.getUserhead());
        commentInfo.setUsername(user.getUsername());
        if(!Inti.checkObjectFieldIsNull(commentInfo)){
            return null;
        }else {
            sysCommentInfoService.insert(commentInfo);
            return Inti.GetJson(commentInfo);
        }
    }

    @Override
    public CommentInfo selectone(String id) {
        return sysCommentInfoService.selectone(id);
    }

    //显示所有评论
    @Override
    public List<Object> selectAllCommentInfo(String invi_id) {
        return sysCommentInfoService.selectAll(invi_id);
    }

    //显示部分评论
    @Override
    public List<Object> selectSonCommentInfo(String invi_id, Integer start, Integer end) {
        return sysCommentInfoService.selectson(invi_id,start,end);
    }


    //删除评论
    @Override
    public void deleteCommentInfo(String info_id) {
        if(sysCommentReplyMapper.selectinfo(info_id,0,1)!=null){
            sysCommentReplyMapper.deleteinfo(info_id);
        }
        CommentInfo commentInfo=selectone(info_id);
        sysCommentInfoService.deleteone(info_id);
        String spath= publicData.FILE_INVI+commentInfo.getInviid()+"\\"+commentInfo.getInfoid();
        InFile.deleteFiles(spath);

    }

    @Override
    public void updateAddlikes(String info_id) {
        sysCommentInfoService.updateAddlikes(info_id);
    }

    @Override
    public void updateDonelikes(String info_id) {
        sysCommentInfoService.updateDonelikes(info_id);

    }

    @Override
    public List<Object> selectAll() {
        return sysCommentInfoService.selectInfoAll();
    }

    @Override
    public List<Object> selectUser(String userid) {
        return sysCommentInfoService.selectuser(userid);
    }
}
