package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Author: FengJie
 * #Description: Message
 * #Date: 2021/5/31 16:37
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notecard {
    private String id;
    private String content;
    private Timestamp posttime;
}
