package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.websocket.Session;
import java.sql.Timestamp;

/**
 * @Author: FengJie
 * #Description: UserWeb
 * #Date: 2021/7/23 14:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWeb {
    private String Userid;

    private Session session;
    private Timestamp timestamp;
}
