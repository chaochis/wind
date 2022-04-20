package com.chaochis.wind.exception;

public class PermissionNotAllowedException extends RuntimeException {
  public PermissionNotAllowedException() {
    super();
  }

  public PermissionNotAllowedException(String message) {
      super(message);
  }
}
