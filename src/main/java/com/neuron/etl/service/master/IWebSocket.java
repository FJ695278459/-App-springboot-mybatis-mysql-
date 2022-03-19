package com.neuron.etl.service.master;

import com.neuron.etl.model.master.Crowd;

import java.io.IOException;

/**
 * @Author: FengJie
 * #Description: IWebSocket
 * #Date: 2021/7/23 14:28
 * 长连接，实时通讯
 */
public interface IWebSocket {

    /**
     * @author FengJie
     * @date 2021-07-23 15:08
     * 创建群聊
     */
    Crowd CreationCrowd(String name,Integer numMAX);

    /**
     * @author FengJie
     * @date 2021-07-23 14:29
     * 一对一聊天
     */
    void PutSentOne(String json);
    /**
     * @author FengJie
     * @date 2021-07-23 14:31
     * 群聊
     */
    void PutSentSum(String json);
    /**
     * @author FengJie
     * @date 2021-07-23 14:31
     * 系统通知，公告等等
     */
    void PutSentSys(String s) throws IOException;


    /**
     * @author FengJie
     * 获取在线人数
     * @date 2021-07-31 22:58
     */
    int numsuer();
}
