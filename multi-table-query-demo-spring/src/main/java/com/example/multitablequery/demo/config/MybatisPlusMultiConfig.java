package com.example.multitablequery.demo.config;

import com.bebetter.mtq.service.multiwrapper.MultiTableRelationService;
import com.example.multitablequery.demo.service.MultiTableRelationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 */
@Configuration
public class MybatisPlusMultiConfig {

    /**
     * 查询表和表之间的关系
     */
    @Bean
    public MultiTableRelationService multiTableRelationService() {
        return new MultiTableRelationServiceImpl();
    }

}
