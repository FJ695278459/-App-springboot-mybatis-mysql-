package com.neuron.etl.service.master.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author: FengJie
 * #Description: WebSocketConfig
 * #Date: 2021/8/2 01:00
 */



@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "dev")
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
