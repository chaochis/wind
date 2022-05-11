package com.chaochis.wind.user.web;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.chaochis.wind.base.constant.DatabaseInfoNullDefault;
import com.chaochis.wind.common_exceptions.DataHasTombstoneException;
import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.config.page_config.NeedPageHelper;
import com.chaochis.wind.enums.AccountType;
import com.chaochis.wind.enums.DataStatus;
import com.chaochis.wind.exceptions.exceptionVo.ParamsEmptyException;
import com.chaochis.wind.user.params.WxAccountQueryVo;
import com.chaochis.wind.user.params.WxLoginRequestParams;
import com.chaochis.wind.user.service.WxAccountService;
import com.chaochis.wind.user.vo.WxAccount;
import com.chaochis.wind.util.IpUtil;
import com.chaochis.wind.util.id_generator.IdGenerator;
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

  @Autowired
  private WxMaService wxMaService;

  @Autowired
  private IdGenerator mainKeyGenerator;

  @Autowired
  private IdGenerator tokenGenerator;
  /**
   * 微信小程序那边来登录的用户
   * @param params 微信小程序的信息
   * @return 返回的token
   */
  @PostMapping("/loginOrRegisterByWx")
  public ApiResult<String> loginOrRegisterByWx(@RequestBody WxLoginRequestParams params, HttpServletRequest request) throws Exception {
    if(null == params || params.getCode() == null || params.getUserInfo() == null) {
      throw new ParamsEmptyException("参数不能为空对象且code跟userInfo也不能为空!");
    }
    WxAccount wxAccount = this.getAccountFromWxLoginParams(params, request);
    return ApiResult.success(wxAccount.getToken());
  }

  /**
   * 管理后台获取微信用户列表
   * @param vo 要查询的微信用户对象
   * @return 微信用户列表
   */
  @GetMapping("/getWxAccountList")
  @NeedPageHelper
  public ApiResult<List<WxAccount>> getWxAccountList(WxAccountQueryVo vo) {
    WxAccount searchWxAccount = new WxAccount();
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
  public ApiResult<Boolean> tombstoneWxUser(String accountId) throws DataHasTombstoneException {
    WxAccount wxAccount = new WxAccount();
    wxAccount.setAccountId(accountId);
    wxAccount.setAccountStatus(DataStatus.Deleted);
    wxAccount.setAccountStatusText(DataStatus.Deleted.getText());
    wxAccount.setUpdateDate(LocalDateTime.now());
    wxAccount.setUpdateById(DatabaseInfoNullDefault.WX_ACCOUNT_UPDATE_BY_ID_NULL_DEFAULT);
    this.wxAccountService.tombstoneWxAccount(wxAccount);
    return ApiResult.success(true);
  }

  /**
   * 从微信用户登录参数中获取系统中保存的微信账户
   * @param params 请求的微信登录对象
   * @param request 原始请求
   * @return 返回找到的微信账户
   * @throws Exception 未获取到open_id, session_key时抛出的异常
   */
  private WxAccount getAccountFromWxLoginParams(WxLoginRequestParams params, HttpServletRequest request) throws Exception{
    WxMaUserService wxUserMaService = this.wxMaService.getUserService();
    WxMaJscode2SessionResult result = wxUserMaService.getSessionInfo(params.getCode());
    // 暂时不用，因为获取不到union_id
    /* if(result.getUnionid() == null){
      String sessionKey = result.getSessionKey();
      String encryptedResult = AESUtil.decrypt(params.getEncryptedInfo().getEncryptedData(), sessionKey, params.getEncryptedInfo().getIv(), "UTF-8");
    } */
    if (null == result || result.getOpenid() == null || result.getSessionKey() == null) {
      throw new Exception("未获取到微信用户的open_id或者session_key");
    }
    WxAccount wxAccount = this.wxAccountService.getWxAccountByOpenId(result.getOpenid());
    if (null == wxAccount) {
      wxAccount = new WxAccount();
      wxAccount.setAccountId(this.mainKeyGenerator.generator());
      wxAccount.setOpenId(result.getOpenid());
      wxAccount.setUnionId(result.getUnionid());
      wxAccount.setWxNickName(params.getUserInfo().getNickName());
      wxAccount.setWxAvatar(params.getUserInfo().getAvatarUrl());
      wxAccount.setRegisterIp(IpUtil.getIpAddr(request));
      wxAccount.setRegisterDate(LocalDateTime.now());
      wxAccount.setLoginIp(IpUtil.getIpAddr(request));
      wxAccount.setLoginDate(LocalDateTime.now());
      wxAccount.setToken(this.tokenGenerator.generator());
      wxAccount.setAccountStatus(DataStatus.Normal);
      wxAccount.setAccountStatusText(DataStatus.Normal.getText());
      wxAccount.setUpdateDate(LocalDateTime.now());
      wxAccount.setUpdateById(DatabaseInfoNullDefault.WX_ACCOUNT_UPDATE_BY_ID_NULL_DEFAULT);
      wxAccount.setAccountType(AccountType.WxAccount);
      wxAccount.setAccountTypeText(AccountType.WxAccount.getText());
      this.wxAccountService.addWxAccount(wxAccount);
    } else {
      wxAccount.setLoginIp(IpUtil.getIpAddr(request));
      wxAccount.setLoginDate(LocalDateTime.now());
      wxAccount.setToken(this.tokenGenerator.generator());
      this.wxAccountService.updateWxAccount(wxAccount);
    }
    return wxAccount;
  }
}
