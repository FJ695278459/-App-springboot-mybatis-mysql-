package com.neuron.etl.model.master;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;
@Data
//有参构造
@AllArgsConstructor
//无参构造
@NoArgsConstructor

@Component
public class Test {
    @Value("3321")
    private Integer id;
    @Value("123456")
    private String password;
    private Timestamp time;
    private List<Object> list;
//    @Override

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", time=" + time +
                ", list=" + list +
                '}';
    }
}
