package com.chaochis.wind.config.cors_config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 */
@Configuration
@Slf4j
public class CorsConfig {

  /**
   * 跨域设置配置
   * @param corsProperties
   * @return
   */
  @Bean
  public FilterRegistrationBean<CorsFilter> corsFilter(CorsProperties corsProperties){
    System.out.println("跨域设置corsPropertis:" + corsProperties.toString());
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    // 跨域配置
    corsConfiguration.setAllowCredentials(corsProperties.isAllowCredentials());
    if (corsProperties.isAllowCredentials()) {
      corsConfiguration.setAllowedMethods(corsProperties.getAllowedOrigins());
    } else {
      corsConfiguration.setAllowedOrigins(corsProperties.getAllowedOrigins());
    }
    corsConfiguration.setAllowedHeaders(corsProperties.getAllowedHeaders());
    corsConfiguration.setAllowedMethods(corsProperties.getAllowedMethods());
    corsConfiguration.setExposedHeaders(corsProperties.getExposedHeaders());
    corsConfiguration.setMaxAge(corsConfiguration.getMaxAge());

    source.registerCorsConfiguration(corsProperties.getPath(), corsConfiguration);
    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    bean.setEnabled(corsProperties.isEnable());
    return bean;
  }
}
