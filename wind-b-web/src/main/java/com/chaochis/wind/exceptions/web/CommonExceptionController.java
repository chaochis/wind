package com.chaochis.wind.exceptions.web;

import com.chaochis.wind.common_exceptions.DataHasTombstoneException;
import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.exceptions.exceptionVo.PermissionNotAllowedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionController {

  /**
   * 处理数据已被逻辑删除的异常
   * @param e
   * @return
   */
  @ExceptionHandler(DataHasTombstoneException.class)
  public ApiResult<Boolean> dataHasTombstone(DataHasTombstoneException e) {
    return ApiResult.fail(e);
  }
  @ExceptionHandler(PermissionNotAllowedException.class)
  public ApiResult<Boolean> permissionNotAllowed (PermissionNotAllowedException e) {
    return ApiResult.fail(e);
  }
}
