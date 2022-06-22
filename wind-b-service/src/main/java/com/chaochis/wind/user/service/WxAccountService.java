package com.chaochis.wind.user.service;

import com.chaochis.wind.common_exceptions.UserHasTombstoneException;
import com.chaochis.wind.user.vo.WindUser;
import com.chaochis.wind.user.vo.WxAccount;

import java.util.List;

/**
 * 微信账户管理接口
 * @author 刘超/chaochis
 */
public interface WxAccountService {
  List<WxAccount> getWxAccountList(WxAccount wxAccount);

  WxAccount getWxAccountByOpenId(String openId);

  void addWxAccount(WxAccount wxAccount);

  void updateWxAccount(WxAccount wxAccount);

  void tombstoneWxAccount(String accountId) throws UserHasTombstoneException;

  void deleteWxAccount(String accountId) throws Exception;

  WindUser getWxBoundWindUserByAccountId(String accountId);
}
