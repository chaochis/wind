package com.chaochis.wind.user.web;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.chaochis.wind.common_exceptions.UserHasTombstoneException;
import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.constant.DatabaseInfoNullDefault;
import com.chaochis.wind.enums.AccountType;
import com.chaochis.wind.enums.DataStatus;
import com.chaochis.wind.exceptions.ParamsEmptyException;
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
public class WxAccountLoginController {

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
    var wxAccount = this.getAccountFromWxLoginParams(params, request);
    return ApiResult.success(wxAccount.getToken());
  }

  /**
   * 从微信用户登录参数中获取系统中保存的微信账户
   * @param params 请求的微信登录对象
   * @param request 原始请求
   * @return 返回找到的微信账户
   * @throws Exception 未获取到open_id, session_key时抛出的异常
   */
  private WxAccount getAccountFromWxLoginParams(WxLoginRequestParams params, HttpServletRequest request) throws Exception{
    var wxUserMaService = this.wxMaService.getUserService();
    var result = wxUserMaService.getSessionInfo(params.getCode());
    // 暂时不用，因为获取不到union_id
    /* if(result.getUnionid() == null){
      String sessionKey = result.getSessionKey();
      String encryptedResult = AESUtil.decrypt(params.getEncryptedInfo().getEncryptedData(), sessionKey, params.getEncryptedInfo().getIv(), "UTF-8");
    } */
    if (null == result || result.getOpenid() == null || result.getSessionKey() == null) {
      throw new Exception("未获取到微信用户的open_id或者session_key");
    }
    var wxAccount = this.wxAccountService.getWxAccountByOpenId(result.getOpenid());
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
      if (DataStatus.Deleted == wxAccount.getAccountStatus()) {
        throw new UserHasTombstoneException("该微信用户已被逻辑删除!");
      }
      wxAccount.setLoginIp(IpUtil.getIpAddr(request));
      wxAccount.setLoginDate(LocalDateTime.now());
      wxAccount.setToken(this.tokenGenerator.generator());
      this.wxAccountService.updateWxAccount(wxAccount);
    }
    return wxAccount;
  }
}
