package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: FengJie
 * #Description: Module
 * #Date: 2021/5/6 22:29
 */
//大模块

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    private String id;
    private String moduleid;
    private String name;
    private String Head;
}
