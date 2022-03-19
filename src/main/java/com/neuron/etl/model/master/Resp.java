package com.neuron.etl.model.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: FengJie
 * #Description: Resp
 * #Date: 2021/5/8 17:26
 */
//文件上传回复信息
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resp<E> {
    private String code;
    private String message;
    private E body;
    public static <E> Resp<E> success(E body,String s){
        return new Resp("200",s,body);
    }
    public static <E> Resp <E> fail(String code,String message){
        return new Resp(code,message,null);
    }
}
