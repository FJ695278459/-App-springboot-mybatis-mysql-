package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.Collect;
import com.neuron.etl.model.master.History;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysCollentMapper
 * #Date: 2021/5/6 23:53
 */

@Repository
public interface SysCollentMapper {
    void insert(Collect collect);
    //浏览查询
    List<Object> selectAll(@Param("userid")String user_id);
    Integer numBerCollect(@Param("userid")String userid);
    //删除第一条
    void deleteone();
    //删除指定的一条
    void deleteson(@Param("collectid") String id);
}
