package com.neuron.etl.service.master.impl;

import com.neuron.etl.mapper.master.SysQQinfoMapper;
import com.neuron.etl.model.master.QQinfo;
import com.neuron.etl.service.master.SysQQinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: FengJie
 * #Description: SysQQinfoImpl
 * #Date: 2021/5/7 00:08
 */


//登录接口
@Service
public class SysQQinfoServiceImpl implements SysQQinfoService {

    @Autowired
    private SysQQinfoMapper qQinfoMapper;

    //注册
    @Override
    public void insertQQinfo(QQinfo qinfo) {
        qQinfoMapper.insertAll(qinfo);
    }

    //查询
    @Override
    public QQinfo selectoneQQInfo(String Token) {

        return qQinfoMapper.selectOne(Token);
    }

    //登录
    @Override
    public void updateQQinfo(QQinfo qinfo) {
        qQinfoMapper.updateQQinfo(qinfo);
    }
}
