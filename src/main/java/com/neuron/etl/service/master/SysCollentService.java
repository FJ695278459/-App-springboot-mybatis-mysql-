package com.neuron.etl.service.master;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.Collect;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysCollentService
 * #Date: 2021/5/6 23:58
 */

//搜藏帖
public interface SysCollentService {
    JSONObject insetrhistory(Collect collect);
    List<Object> Selecthistory(String id);
    Integer numBerCollectSeve(String userid);
    void deletehistory(String id);
}
