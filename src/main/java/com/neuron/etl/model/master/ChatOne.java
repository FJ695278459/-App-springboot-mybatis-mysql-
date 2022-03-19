package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Author: FengJie
 * #Description: ChatOne
 * #Date: 2021/8/1 22:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatOne {
    //发送者id *
    private String formuserid;
    //接收者id *
    private String touserid;
    //发送类容 *
    private String content;
    //发送时间
    private Timestamp intime;
}
