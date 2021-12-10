package com.example.mybatisplusmultitabledemo.config;

import com.example.mybatisplusmultitabledemo.service.MultiTableRelationServiceImpl;
import com.lzb.mpmt.service.multiwrapper.MultiTableRelationService;
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
