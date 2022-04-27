package com.chaochis.wind.user.params;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WxEncryptedData {
  String encryptedData;
  String iv;
}
