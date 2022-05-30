package com.chaochis.wind.config.page_config.page_vo;

import com.chaochis.wind.vo.BasePage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class RequestPage extends BasePage {
  private String order;
}
