package com.neuron.etl.service.master;

import com.neuron.etl.model.master.History;

import java.util.*;
/**
 * @Author: FengJie
 * #Description: SysHistoryService
 * #Date: 2021/5/7 00:02
 */

//历史帖子
public interface SysHistoryService {
    void insetrhistory(History history);
    List<Object> Selecthistory(String id);
    Integer numBerHistotySeve(String userid);
    void deletehistory(String id);
}
