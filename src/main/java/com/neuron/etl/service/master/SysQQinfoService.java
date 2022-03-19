package com.neuron.etl.service.master;

import com.neuron.etl.model.master.QQinfo;

/**
 * @Author: FengJie
 * #Description: SysQQinfoService
 * #Date: 2021/5/7 00:03
 */
public interface SysQQinfoService {
    void insertQQinfo(QQinfo qinfo);
    QQinfo selectoneQQInfo(String Token);
    void updateQQinfo(QQinfo qinfo);
}
