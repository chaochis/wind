package com.chaochis.windbadminweb.user.web;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.chaochis.wind.common_exceptions.UserHasTombstoneException;
import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.config.page_config.NeedPageHelper;
import com.chaochis.wind.constant.DatabaseInfoNullDefault;
import com.chaochis.wind.enums.AccountType;
import com.chaochis.wind.enums.DataStatus;
import com.chaochis.wind.exceptions.ParamsEmptyException;
import com.chaochis.wind.user.service.WxAccountService;
import com.chaochis.wind.user.vo.WxAccount;
import com.chaochis.wind.util.IpUtil;
import com.chaochis.wind.util.id_generator.IdGenerator;
import com.chaochis.windbadminweb.user.params.WxAccountQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 刘超/chaochis
 */
@RestController
@RequestMapping("/wxAccount")
public class WxAccountController {

  @Autowired
  private WxAccountService wxAccountService;


  /**
   * 管理后台获取微信用户列表
   * @param vo 要查询的微信用户对象
   * @return 微信用户列表
   */
  @GetMapping("/getWxAccountList")
  @NeedPageHelper
  public ApiResult<List<WxAccount>> getWxAccountList(WxAccountQueryVo vo) {
    var searchWxAccount = new WxAccount();
    searchWxAccount.setWxNickName(vo.getAccountName());
    return ApiResult.success(this.wxAccountService.getWxAccountList(searchWxAccount));
  }

  /**
   * 更新微信用户
   * @return 返回更新后的微信用户对象
   */
  @PostMapping("/updateWxAccountInfo")
  public ApiResult<WxAccount> updateWxAccount() {
    return ApiResult.success(new WxAccount());
  }

  /**
   * 逻辑删除微信用户
   * @param accountId 要删除的微信用户的accountId
   * @return 是否删除成功
   */
  @GetMapping("/tombstoneWxUser")
  public ApiResult<Boolean> tombstoneWxAccount(String accountId) throws UserHasTombstoneException {
    this.wxAccountService.tombstoneWxAccount(accountId);
    return ApiResult.success(true);
  }

  /**
   * 物理删除微信用户
   * @param accountId 账户id
   * @return 是否成功删除
   * @throws Exception 删除异常
   */
  @GetMapping("/deleteWxUser")
  public ApiResult<Boolean> deleteWxAccount(String accountId) throws Exception {
    this.wxAccountService.deleteWxAccount(accountId);
    return ApiResult.success(true);
  }

}
