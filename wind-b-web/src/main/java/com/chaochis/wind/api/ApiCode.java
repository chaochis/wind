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
  Success(200, 0),
  Fail(100, 1);
  @JsonValue
  private final Integer value;
  private final Integer id;
  ApiCode(Integer value, Integer id) {
    this.value = value;
    this.id = id;
  }
}
