package com.neuron.etl.service.master.impl;

import com.neuron.etl.mapper.master.SysHistoryMapper;
import com.neuron.etl.model.master.History;
import com.neuron.etl.service.master.SysHistoryService;
import com.neuron.etl.util.Ramdnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysHistoryImpl
 * #Date: 2021/5/7 00:08
 */

@Service
public class SysHistoryServiceImpl implements SysHistoryService {

    private Integer NUM_MAX=100;
    @Autowired
    private SysHistoryMapper sysHistoryMapper;
    //历史浏览
    @Override
    public void insetrhistory(History history) {
        history.setHistoryid(Ramdnum.getnum());
        history.setIntime(Ramdnum.getdate());
        //如果大于历史浏览大于100条，删除第一条
        if(sysHistoryMapper.selectAll(history.getUserid()).size()>NUM_MAX){
            sysHistoryMapper.deleteone();
        }
        sysHistoryMapper.insert(history);
    }

    //一个用户的全部浏览记录
    @Override
    public List<Object> Selecthistory(String userid) {
        return sysHistoryMapper.selectAll(userid);
    }

    @Override
    public Integer numBerHistotySeve(String userid) {
        return sysHistoryMapper.numBerHistory(userid);
    }

    //删除浏览的帖子
    @Override
    public void deletehistory(String id) {
        sysHistoryMapper.deleteson(id);
    }
}
