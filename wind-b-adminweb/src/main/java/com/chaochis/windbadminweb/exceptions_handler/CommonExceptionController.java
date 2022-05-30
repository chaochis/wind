package com.chaochis.windbadminweb.exceptions_handler;

import com.chaochis.wind.common_exceptions.UserHasTombstoneException;
import com.chaochis.wind.config.api.ApiCode;
import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.exceptions.PermissionNotAllowedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理类
 * @author 刘超/chaochis
 */
@RestControllerAdvice
public class CommonExceptionController {

  /**
   * 处理用户已被逻辑删除的异常
   * @param e 对应的异常信息
   * @return 返回的结果
   */
  @ExceptionHandler(UserHasTombstoneException.class)
  public ApiResult<Boolean> userHasTombstone(UserHasTombstoneException e) {
    return ApiResult.build(e.getMessage(), null, ApiCode.UserHasDelete, null);
  }

  /**
   * 处理未被授权的异常
   * @param e 异常信息
   * @return 返回的结果
   */
  @ExceptionHandler(PermissionNotAllowedException.class)
  public ApiResult<Boolean> permissionNotAllowed (PermissionNotAllowedException e) {
    return ApiResult.fail(e);
  }

  /**
   * 通用异常处理类
   * @param e 异常信息
   * @return 返回的结果
   */
  @ExceptionHandler(Exception.class)
  public ApiResult<Boolean>exceptionHandler(Exception e) {
      return ApiResult.fail(e);
  }
}
