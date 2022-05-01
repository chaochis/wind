package com.chaochis.wind.config.api;

import com.chaochis.wind.config.page_config.page_vo.ResponsePage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 统一返回的json格式的数据类
 * @author 刘超/chaochis
 */
@Data
@ToString
@AllArgsConstructor
public class ApiResult<T> implements Serializable {
  private String msg;
  private T result;
  private ApiCode apiCode;
  private ResponsePage page;

  public static <T> ApiResult<T> success() {
    return build(null, null, ApiCode.Success, null);
  }
  public static <T> ApiResult<T> success(T result) {
    return build(null, result, ApiCode.Success, null);
  }

  public static <T> ApiResult<T> success(T result, ResponsePage page) {
    return build(null, result, ApiCode.Success, page);
  }

  public static ApiResult<Boolean> fail() {
    return build(null, false, ApiCode.Fail, null);
  }

  public static ApiResult<Boolean> fail(String msg) {
    return build(msg, false, ApiCode.Fail, null);
  }

  public static  ApiResult<Boolean> fail(Exception exception) {
    return build(exception.getMessage(), false, ApiCode.Fail, null);
  }
  private static <T> ApiResult<T> build(String msg, T result, ApiCode apiCode, ResponsePage page) {
    return new ApiResult<T>(msg, result, apiCode, page);
  }

}
