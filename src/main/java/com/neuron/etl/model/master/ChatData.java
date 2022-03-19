package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: FengJie
 * #Description: ChatData
 * #Date: 2021/6/14 12:04
 * 聊天消息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatData {

    //在线人数
    private Integer num;
    //用户名，id等
    private String sid;
    //消息类容
    private String message;
    //时间
    private String date;

}
