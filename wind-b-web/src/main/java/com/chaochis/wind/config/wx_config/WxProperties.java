package com.chaochis.wind.config.wx_config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "wind.wx")
@Getter
@Setter
public class WxProperties {
  // 小程序的appid
  private String appid;

  // 小程序的密钥
  private String secret;
}
