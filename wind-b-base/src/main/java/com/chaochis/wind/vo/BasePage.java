package com.chaochis.wind.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class BasePage {
  private Integer pageLimit;
  private Integer pageIndex;
}
