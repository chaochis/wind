package com.chaochis.windbadminweb.user.params;

import com.chaochis.wind.config.page_config.page_vo.RequestPage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class WxAccountQueryVo extends RequestPage {
  private String accountName;
}
