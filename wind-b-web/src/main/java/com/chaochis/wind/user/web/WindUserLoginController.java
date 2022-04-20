package com.chaochis.wind.user.web;

import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.user.params.WxLoginRequestParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaochis
 */
@RestController
@RequestMapping("/user")
public class WindUserLoginController {

  /**
   * 微信小程序那边来登录的用户
   * @param params 微信小程序的信息
   * @return 返回的token
   */
  @PostMapping("/loginOrRegisterByWx")
  public ApiResult<String> loginOrRegisterByWx(WxLoginRequestParams params){
    return ApiResult.success("hello");
  }
}
