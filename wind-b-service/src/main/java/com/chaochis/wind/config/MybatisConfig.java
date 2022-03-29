package com.chaochis.wind.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chaochis
 */
@Configuration
@MapperScan({"com.chaochis.wind.*.mapper"})
public class MybatisConfig {
}
