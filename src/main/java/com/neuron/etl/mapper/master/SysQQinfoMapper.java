package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.QQinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
/**
 * @Author: FengJie
 * #Description: SysQQinfoMapper
 * #Date: 2021/5/6 22:38
 */
//QQ登录接口
@Repository
public interface SysQQinfoMapper {
    //QQ注册
    void insertAll(QQinfo qinfo);
    //QQ查询
    QQinfo selectOne(@Param("QQToken") String Token);
    //QQ登录
    void updateQQinfo(QQinfo qinfo);
}
