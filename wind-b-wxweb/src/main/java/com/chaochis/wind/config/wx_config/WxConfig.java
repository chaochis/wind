package com.chaochis.wind.config.wx_config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxConfig {
  @Autowired
  private WxProperties wxProperties;

  @Bean
  public WxMaConfig wxMaConfig() {
    WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
    config.setAppid(this.wxProperties.getAppid());
    config.setSecret(this.wxProperties.getSecret());
    config.setExpiresTime(5000);
    return config;
  }

  @Bean
  public WxMaService wxMaService(WxMaConfig maConfig) {
    WxMaService service = new WxMaServiceImpl();
    service.setWxMaConfig(maConfig);
    return service;
  }
}
