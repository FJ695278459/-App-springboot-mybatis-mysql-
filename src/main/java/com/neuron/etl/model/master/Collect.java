package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Author: FengJie
 * #Description: Collect
 * #Date: 2021/5/6 22:35
 */

//收藏帖子

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {
    private String collectid;
    private String inviid;//*
    private String userid;//*
    private Timestamp intime;
}
