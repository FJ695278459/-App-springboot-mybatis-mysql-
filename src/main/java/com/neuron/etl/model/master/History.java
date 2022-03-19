package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Author: FengJie
 * #Description: History
 * #Date: 2021/5/6 22:30
 */
//历史浏览

@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    private String historyid;
    private String  inviid;//*
    private String userid;//*
    private Timestamp intime;
}
