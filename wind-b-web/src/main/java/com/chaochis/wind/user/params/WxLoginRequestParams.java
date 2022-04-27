package com.chaochis.wind.user.params;

import com.chaochis.wind.base.controller.BaseRequestParams;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WxLoginRequestParams extends BaseRequestParams {
  String code;
  WxEncryptedData encryptedInfo;
  WxUserInfo userInfo;
}
