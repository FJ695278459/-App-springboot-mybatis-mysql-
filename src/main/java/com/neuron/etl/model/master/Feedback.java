package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Author: FengJie
 * #Description: feedback
 * #Date: 2021/6/30 15:47
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    private String feedbackid;
    private String userid;
    private String content;
    private Timestamp intime;
    private String mold;
}
