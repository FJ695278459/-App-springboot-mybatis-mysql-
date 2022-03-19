package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: FengJie
 * #Description: Token
 * #Date: 2021/7/2 00:42
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private String userid;
    private String token;
}
