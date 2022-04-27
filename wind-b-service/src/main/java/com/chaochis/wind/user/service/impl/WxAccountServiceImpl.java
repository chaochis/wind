package com.chaochis.wind.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaochis.wind.user.mapper.WxAccountMapper;
import com.chaochis.wind.user.service.WxAccountService;
import com.chaochis.wind.user.vo.WxAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wxAccountService")
public class WxAccountServiceImpl implements WxAccountService {
  @Autowired
  private WxAccountMapper wxAccountMapper;


  @Override
  public List<WxAccount> getWxAccountList() {
    return this.wxAccountMapper.selectList(new QueryWrapper<>());
  }

  @Override
  public WxAccount getWxAccountByOpenId(String openId) {
    QueryWrapper<WxAccount> queryWrap = new QueryWrapper<>();
    queryWrap.eq("open_id", openId);
    return this.wxAccountMapper.selectOne(queryWrap);
  }

  @Override
  public void addWxAccount(WxAccount wxAccount) {
    this.wxAccountMapper.insert(wxAccount);
  }

  @Override
  public void updateWxAccount(WxAccount wxAccount) {
    this.wxAccountMapper.updateById(wxAccount);
  }
}
