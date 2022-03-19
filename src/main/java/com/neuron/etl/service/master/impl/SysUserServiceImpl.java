package com.neuron.etl.service.master.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.neuron.etl.mapper.master.SysUserMapper;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysCollentService;
import com.neuron.etl.service.master.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.US_ASCII;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysCollentService
 * #Date: 2021/5/7 00:05
 */


@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    //查询用户
    @Override
    public void InsertOtherUser(User user) {
    }

    //插入用户完整信息
    @Override
    public void InsertMastUser(User user) {
        userMapper.insertMast(user);
    }

    //查询
    @Override
    public User selectOneUser(String user_id) {
        return userMapper.selectOne(user_id);
    }

    @Override
    public User selectOneQQUser(String QQToken) {
        return userMapper.selectOneQQ(QQToken);
    }

    //修改登录时间
    @Override
    public void updateUserTegTime(String user_id, Timestamp RegTime) {
        userMapper.updateUserTegTime(user_id, RegTime);
    }

    //修改资料
    @Override
    public void updateNameinfo(User user) {
        userMapper.updateNameinfo(user);
    }

    //改变头像
    @Override
    public void updateHeadinfo( String head,String user_id) {
        userMapper.updateHeadinfo(head,user_id);
    }

    //改变学校，学号，关乎查课表
    @Override
    public void updateSoninfo(User user) {
        userMapper.updateSoninfo(user);
    }

    //帖子搜藏数
    @Override
    public void updateCollectinfo(String user_id) {
        userMapper.updateCollectinfo(user_id);
    }

    //发帖数
    @Override
    public void updatePostnumbertinfo(String user_id) {
        userMapper.updatePostnumbertinfo(user_id);
    }

    //擦寻搜藏数
    @Override
    public Integer selectCollect(String user_id) {
        return null;
    }

    //发帖数
    @Override
    public Integer selectPostnumber(String user_id) {
        return null;
    }

    //积分
    @Override
    public Integer selectScore(String user_id) {
        return null;
    }

    //改变积分
    @Override
    public void updateScoreinfo(User user) {
        userMapper.updateScoreinfo(user);
    }

    @Override
    public void updateuserall(User user) {
        userMapper.updateall(user);
    }
    @Override
    public User selectPhone(String phone) {
        return userMapper.selectPhone(phone);
    }

    @Override
    public List<Object> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<Object> selectUserLike(String str) {
        return userMapper.selectUserLike(str);
    }
}
