package com.example.demo.conf;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }


}
