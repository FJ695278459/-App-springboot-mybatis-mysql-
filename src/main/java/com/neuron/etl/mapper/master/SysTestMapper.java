package com.neuron.etl.mapper.master;

import com.neuron.etl.model.master.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.List;

/**
 * @Author wxl
 * @Date 2020-04-01 17:37
 * @Description TODO
 * @Version 1.0
 */

//测试接口
@Repository
public interface SysTestMapper {
    List<Test> getTest();
    boolean insertTest(Test test);
    Test selectOne(@Param("id") Integer ids);
    Test selectOnes(@Param("p") Integer ids,@Param("k") Integer i);
    void updateTestTime(@Param("time")Date time,@Param("id")Integer id);
}
