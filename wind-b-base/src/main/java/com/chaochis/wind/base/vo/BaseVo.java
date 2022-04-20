package com.chaochis.wind.base.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BaseVo {
  private String createById;
  private Date createDate;
  private String updateById;
  private Date updateDate;
}
