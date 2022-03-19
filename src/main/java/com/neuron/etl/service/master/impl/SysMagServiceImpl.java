package com.neuron.etl.service.master.impl;

import ch.qos.logback.classic.net.SyslogAppender;
import com.neuron.etl.mapper.master.SysMagMapper;
import com.neuron.etl.model.master.AppMag;
import com.neuron.etl.service.master.SysMapSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysMagServiceImpl
 * #Date: 2021/6/7 14:29
 */

@Service
public class SysMagServiceImpl implements SysMapSercice {
    @Autowired
    private SysMagMapper sysMagMapper;

    @Override
    public void inserAppmag(AppMag appMag) {
        sysMagMapper.insertAppmag(appMag);
    }

    @Override
    public AppMag selectAppmagOne(String versioncode) {
        return sysMagMapper.selectAppmagOne(versioncode);
    }

    @Override
    public List<Object> selectAppmagAll() {
        return sysMagMapper.selectAppmagAll();
    }

    @Override
    public void updateAppmagnum(String version) {
        sysMagMapper.updateAppmag(version);
    }


}
