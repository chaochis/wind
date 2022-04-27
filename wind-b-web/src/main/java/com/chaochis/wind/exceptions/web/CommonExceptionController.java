package com.chaochis.wind.exceptions.web;

import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.exceptions.exceptionVo.PermissionNotAllowedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionController {
  @ExceptionHandler(PermissionNotAllowedException.class)
  public ApiResult<Boolean> permissionNotAllowed (PermissionNotAllowedException e) {
    return ApiResult.fail(e);
  }
}
