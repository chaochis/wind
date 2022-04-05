package com.chaochis.wind.api;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author chaochis
 */
@Getter
public enum ApiCode {
  /**
   * success - 请求成功 , fail - 请求失败
   */
  Success(200),
  Fail(100);
  @JsonValue
  private final Integer value;
  ApiCode(Integer value) {
    this.value = value;
  }
}
