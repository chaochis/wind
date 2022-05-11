package com.chaochis.wind.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaochis.wind.user.vo.WxAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WxAccountMapper extends BaseMapper<WxAccount> {
  List<WxAccount> getWxAccountList(WxAccount wxAccount);
}
