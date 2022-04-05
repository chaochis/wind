package com.chaochis.wind.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 数据状态
 * @author chaochis
 */
public enum DataStatus {
  /**
   *
   */
  Normal(1);
  @EnumValue
  private final Integer value;
  DataStatus(Integer value) {
    this.value = value;
  }

}
