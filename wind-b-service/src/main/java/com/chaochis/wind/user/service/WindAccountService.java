package com.chaochis.wind.user.service;

import com.chaochis.wind.user.vo.WindAccount;

import java.util.List;

public interface WindAccountService {
  List<WindAccount> getWindAccountList(WindAccount windAccount);
}
