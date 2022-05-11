package com.chaochis.wind.user.service;

import com.chaochis.wind.common_exceptions.DataHasTombstoneException;
import com.chaochis.wind.user.vo.WxAccount;

import java.util.List;

public interface WxAccountService {
  List<WxAccount> getWxAccountList(WxAccount wxAccount);

  WxAccount getWxAccountByOpenId(String openId);

  void addWxAccount(WxAccount wxAccount);

  void updateWxAccount(WxAccount wxAccount);

  void tombstoneWxAccount(WxAccount wxAccount) throws DataHasTombstoneException;
}
