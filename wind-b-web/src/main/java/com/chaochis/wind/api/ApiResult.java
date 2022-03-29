package com.chaochis.wind.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author chao
 */
@Data
@ToString
@AllArgsConstructor
public class ApiResult<T> implements Serializable {
  private String msg;
  private T result;
  private ApiCode apiCode;

  public static <T> ApiResult<T> success() {
    return build(null, null, ApiCode.Success);
  }
  public static <T> ApiResult<T> success(T result) {
    return build(null, result, ApiCode.Success);
  }

  public static ApiResult<Boolean> fail() {
    return build(null, false, ApiCode.Fail);
  }

  public static ApiResult<Boolean> fail(String msg) {
    return build(msg, false, ApiCode.Fail);
  }

  public static  ApiResult<Boolean> fail(Exception exception) {
    return build(exception.getMessage(), false, ApiCode.Fail);
  }
  private static <T> ApiResult<T> build(String msg, T result, ApiCode apiCode) {
    return new ApiResult<T>(msg, result, apiCode);
  }
}
