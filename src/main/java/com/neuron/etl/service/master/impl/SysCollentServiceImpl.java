package com.neuron.etl.service.master.impl;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.mapper.master.SysCollentMapper;
import com.neuron.etl.model.master.Collect;
import com.neuron.etl.model.master.Invitation;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysCollentService;
import com.neuron.etl.service.master.SysInvitationService;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.Ramdnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysUserImpl
 * #Date: 2021/5/7 00:08
 */

@Service
public class SysCollentServiceImpl implements SysCollentService {

    @Autowired
    private SysCollentMapper sysCollentMapper;
    @Autowired
    private SysUserServiceImpl sysUserService;
    @Autowired
    private SysInvitationService sysInvitationService;
    @Override
    public JSONObject insetrhistory(Collect collect) {
        collect.setCollectid(Ramdnum.getnum());
        collect.setIntime(Ramdnum.getdate());
        sysCollentMapper.insert(collect);
        sysUserService.updateCollectinfo(collect.getUserid());
        JSONObject jsonObject;
        Invitation invitation=sysInvitationService.selectOneInvitation(collect.getInviid());
        jsonObject= Inti.GetJson(invitation);
        User user=sysUserService.selectOneUser(collect.getUserid());
        jsonObject.put("collects",user.getCollects());
        return jsonObject;
    }

    //查询一个用户所所有的收藏帖子
    @Override
    public List<Object> Selecthistory(String id) {
        return sysCollentMapper.selectAll(id);
    }

    @Override
    public Integer numBerCollectSeve(String userid) {
        return sysCollentMapper.numBerCollect(userid);
    }

    //用户删除指定的收藏帖子
    @Override
    public void deletehistory(String id) {
        sysCollentMapper.deleteson(id);
    }
}
