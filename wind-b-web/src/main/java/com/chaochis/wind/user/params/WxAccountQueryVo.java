package com.chaochis.wind.user.params;

import com.chaochis.wind.base.vo.BasePage;
import com.chaochis.wind.config.page_config.page_vo.RequestPage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class WxAccountQueryVo extends RequestPage {
  private String accountName;
}
