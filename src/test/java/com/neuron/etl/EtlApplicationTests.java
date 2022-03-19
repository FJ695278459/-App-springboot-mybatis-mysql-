package com.neuron.etl;

import com.neuron.etl.mapper.master.SysTestMapper;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysUserService;
import com.neuron.etl.service.master.TestService;
import com.neuron.etl.service.master.web.WebScoteAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.neuron.etl.util.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

@SpringBootTest(classes={EtlApplication.class})
@RunWith(SpringRunner.class)

class EtlApplicationTests {
    @Autowired
    com.neuron.etl.model.master.Test test;
    @Autowired
     private SysUserService sysUserService;
    @Autowired
    private TestService testService;
    @Test
    void mainTest() {
        System.out.println("wd");
//        User user = GetName(id);
//        System.out.println(user);
    }

    private  User GetName(String userid){
        User user = sysUserService.selectOneUser(userid);
        System.out.println(user);
        return user;
    }

}
