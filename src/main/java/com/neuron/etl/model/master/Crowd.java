package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Author: FengJie
 * #Description: Crowd
 * #Date: 2021/7/23 15:06
 * 群聊
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Crowd {
    //id
    private String id;
    //人数
    private Integer num;
    //最大人数
    private Integer numMAx;
    //名字
    private String name;
    //创建时间
    private Timestamp timestamp;
}
