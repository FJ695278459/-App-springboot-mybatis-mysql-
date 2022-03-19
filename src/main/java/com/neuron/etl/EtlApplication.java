package com.neuron.etl;

import com.neuron.etl.model.master.Token;
import com.neuron.etl.service.master.SysLogin;
import com.neuron.etl.service.master.SysSonService;
import com.neuron.etl.util.publicData;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.annotation.Resource;


@Configuration
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@MapperScan(value = "com.neuron.etl.mapper.**")
public class EtlApplication extends WebMvcConfigurerAdapter {


    private final static Logger logger = LoggerFactory.getLogger(EtlApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(EtlApplication.class, args);

    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

    @Bean
    ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

}
