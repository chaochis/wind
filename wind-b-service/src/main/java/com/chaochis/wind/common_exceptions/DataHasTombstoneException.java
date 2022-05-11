package com.chaochis.wind.common_exceptions;

/**
 * 数据对象已被逻辑删除异常
 * @author 刘超/chaochis
 */
public class DataHasTombstoneException extends Exception{
  public DataHasTombstoneException() {
    super();
  }
  public DataHasTombstoneException(String message) {
    super(message);
  }
}
