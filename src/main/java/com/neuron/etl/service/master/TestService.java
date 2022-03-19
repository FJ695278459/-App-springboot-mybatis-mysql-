package com.neuron.etl.service.master;

import com.neuron.etl.mapper.master.SysTestMapper;
import com.neuron.etl.model.master.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * @Author: FengJie
 * #Description: TestService
 * #Date: 2021/5/9 23:30
 */

@Service
public class TestService {

    @Autowired
    SysTestMapper testMapper;

    public Test o(Integer s){
        return testMapper.selectOne(s);
    }
    public Test k(Integer s1,Integer s2){
        return testMapper.selectOnes(s1,s2);
    }
    public void ti(Date time,Integer d){
        testMapper.updateTestTime(time,d);
    }
}
