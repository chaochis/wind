package com.chaochis.wind.user.service;

import com.chaochis.wind.user.vo.WxAccount;

import java.util.List;

public interface WxAccountService {
  List<WxAccount> getWxAccountList();

  WxAccount getWxAccountByOpenId(String openId);

  void addWxAccount(WxAccount wxAccount);

  void updateWxAccount(WxAccount wxAccount);
}
