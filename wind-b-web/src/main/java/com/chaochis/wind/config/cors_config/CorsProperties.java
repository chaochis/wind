package com.chaochis.wind.config.cors_config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "wind.cors")
public class CorsProperties {
  private boolean enable = true; //是否开启cors
  private String path = "/**"; //cors过滤的路径
  private List<String> allowedOrigins = Collections.singletonList(CorsConfiguration.ALL);//允许访问的源
  private List<String> allowedHeaders = Collections.singletonList(CorsConfiguration.ALL);//允许访问的请求头
  private boolean allowCredentials = true; // 是否发送cookie
  private List<String> allowedMethods = Collections.singletonList(CorsConfiguration.ALL);//允许访问的请求方法
  private List<String> exposedHeaders = Collections.singletonList("token"); // 允许响应的头
  private Long maxAge = 1800L;//该响应的有效时间默认为30分钟，在有效时间内，浏览器无须为同一请求再次发起预检请求
}
