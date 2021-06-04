package com.southwind.config;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

@org.springframework.context.annotation.Configuration
class MyBatisConfig implements ConfigurationCustomizer {
    @Override
    public void customize(org.apache.ibatis.session.Configuration configuration) {
        configuration.addInterceptor(new PageInterceptor());
//    configuration.addInterceptor(new UserInterceptor());
    }
}
