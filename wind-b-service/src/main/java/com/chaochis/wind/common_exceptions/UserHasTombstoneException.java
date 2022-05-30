package com.chaochis.wind.common_exceptions;

/**
 * 数据对象已被逻辑删除异常
 * @author 刘超/chaochis
 */
public class UserHasTombstoneException extends Exception{
  public UserHasTombstoneException() {
    super();
  }
  public UserHasTombstoneException(String message) {
    super(message);
  }
}
