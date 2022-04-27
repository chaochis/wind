package com.chaochis.wind.user.web;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.exceptions.exceptionVo.ParamsEmptyException;
import com.chaochis.wind.user.params.WxLoginRequestParams;
import com.chaochis.wind.user.service.WxAccountService;
import com.chaochis.wind.user.vo.WxAccount;
import com.chaochis.wind.util.IpUtil;
import com.chaochis.wind.util.id_generator.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author 刘超/chaochis
 */
@RestController
@RequestMapping("/user")
public class WxUserLoginController {

  @Autowired
  private WxAccountService wxAccountService;

  @Autowired
  private WxMaService wxMaService;

  @Autowired
  private UuidGenerator uuidGenerator;
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

  private WxAccount getAccountFromWxLoginParams(WxLoginRequestParams params, HttpServletRequest request) throws Exception{
    WxMaUserService wxUserMaService = this.wxMaService.getUserService();
    WxMaJscode2SessionResult result = wxUserMaService.getSessionInfo(params.getCode());
    // 暂时不用，因为获取不到union_id
   /* if(result.getUnionid() == null){
      String sessionKey = result.getSessionKey();
      String encryptedResult = AESUtil.decrypt(params.getEncryptedInfo().getEncryptedData(), sessionKey, params.getEncryptedInfo().getIv(), "UTF-8");
    }*/
    if (null == result || result.getOpenid() == null || result.getSessionKey() == null) {
      throw new Exception("未获取到微信用户的open_id或者session_key");
    }
    WxAccount wxAccount = this.wxAccountService.getWxAccountByOpenId(result.getOpenid());
    System.out.println(wxAccount);
    if (null == wxAccount) {
      wxAccount = new WxAccount();
      wxAccount.setAccountId(this.uuidGenerator.generator());
      wxAccount.setOpenId(result.getOpenid());
      wxAccount.setUnionId(result.getUnionid());
      wxAccount.setWxNickName(params.getUserInfo().getNickName());
      wxAccount.setWxAvatar(params.getUserInfo().getAvatarUrl());
      wxAccount.setRegisterIp(IpUtil.getIpAddr(request));
      wxAccount.setRegisterDate(LocalDateTime.now());
      wxAccount.setLoginIp(IpUtil.getIpAddr(request));
      wxAccount.setLoginDate(LocalDateTime.now());
      wxAccount.setToken(this.uuidGenerator.generator());
      this.wxAccountService.addWxAccount(wxAccount);
    } else {
      wxAccount.setRegisterIp(IpUtil.getIpAddr(request));
      wxAccount.setLoginDate(LocalDateTime.now());
      wxAccount.setToken(this.uuidGenerator.generator());
      this.wxAccountService.updateWxAccount(wxAccount);
    }
    return wxAccount;
  }
}
