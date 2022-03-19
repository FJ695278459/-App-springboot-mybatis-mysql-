package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.AppMag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sun.security.util.ObjectIdentifier;

import java.util.*;
/**
 * @Author: FengJie
 * #Description: SysMagMapper
 * #Date: 2021/6/5 13:37
 */

@Repository
public interface SysMagMapper {
    void insertAppmag(AppMag appMag);
    //查询某个版本的使用个数
    AppMag selectAppmagOne(@Param("VersionCode")String versioncode);
    //查询所有版本的使用个数
    List<Object> selectAppmagAll();
    //使用个数+1
    void updateAppmag(@Param("VersionCode")String versioncode);
}
