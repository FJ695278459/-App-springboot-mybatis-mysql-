package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.History;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: History
 * #Date: 2021/5/6 23:49
 */

//历史浏览
@Repository
public interface SysHistoryMapper {
    void insert(History history);
    //浏览查询
    List<Object> selectAll(@Param("userid")String user_id);
    //查询用户历史浏览数
    Integer numBerHistory(@Param("userid")String userid);

    //删除第一条
    void deleteone();
    //删除指定的一条
    void deleteson(@Param("historyid") String id);

}
