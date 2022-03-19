package com.neuron.etl.service.master.impl;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.mapper.master.SysCommentReplyMapper;
import com.neuron.etl.mapper.master.SysInvitationMapper;
import com.neuron.etl.mapper.master.SysUserMapper;
import com.neuron.etl.model.master.CommentReply;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysCommentReplyService;
import com.neuron.etl.util.InFile;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.publicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysCommentReplyImpl
 * #Date: 2021/5/7 00:07
 */

@Service
public class SysCommentReplyServiceImpl implements SysCommentReplyService {
    @Autowired
    private SysCommentReplyMapper sysCommentReplyMapper;
    @Autowired
    private SysUserMapper userMapper;
    @Override
    public JSONObject InsertCOmmentReply(CommentReply commentReply) {
        User user=userMapper.selectOne(commentReply.getUserid());
        commentReply.setUserhead(user.getUserhead());
        commentReply.setUsername(user.getUsername());
        if(!Inti.checkObjectFieldIsNull(commentReply)){
            return null;
        }else {
            sysCommentReplyMapper.insert(commentReply);
            return Inti.GetJson(commentReply);
        }
    }
    @Override
    public CommentReply selectone(String id) {
        return sysCommentReplyMapper.selectone(id);
    }

    @Override
    public List<Object> selectAllCommentReply(String id) {
        return sysCommentReplyMapper.selectAll(id);
    }

    @Override
    public List<Object> selectinfoCommentInvi(String invi_id) {
        return sysCommentReplyMapper.selectinvi(invi_id);
    }

    @Override
    public List<Object> selectSonCommentReply(String info_id, Integer strat, Integer end) {
        return sysCommentReplyMapper.selectinfo(info_id,strat,end);
    }

    @Override
    public void deleteCommentReply(String reply_id) {
        CommentReply commentReply=selectone(reply_id);

        sysCommentReplyMapper.deleteone(reply_id);
        String spath= publicData.FILE_INVI+commentReply.getInviid()+"\\"+commentReply.getInfoid()+"\\"+commentReply.getReplyid();
        InFile.deleteFiles(spath);
    }
    @Override
    public void updateAddlikes(String reply_id) {
        sysCommentReplyMapper.updateAddlikes(reply_id);
    }

    @Override
    public void updateDonelikes(String reply_id) {
        sysCommentReplyMapper.updateDonelikes(reply_id);
    }

    @Override
    public List<Object> selectAll() {
        return sysCommentReplyMapper.selectReplyAll();
    }

    @Override
    public List<Object> SelecUserAll(String userid) {
        return sysCommentReplyMapper.selectuser(userid);
    }
}
