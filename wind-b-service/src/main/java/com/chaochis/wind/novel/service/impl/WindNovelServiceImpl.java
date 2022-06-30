package com.chaochis.wind.novel.service.impl;

import com.chaochis.wind.enums.DataStatus;
import com.chaochis.wind.novel.mapper.WindNovelMapper;
import com.chaochis.wind.novel.service.WindNovelService;
import com.chaochis.wind.novel.vo.WindNovel;
import com.chaochis.wind.querywrapper.EntityQueryWrapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 小说服务类
 * @author 刘超/chaochis
 */
@Service("windNovelService")
public class WindNovelServiceImpl implements WindNovelService {

  @Autowired
  private WindNovelMapper windNovelMapper;

  public List<WindNovel> getNovelList(WindNovel windNovel){
    return this.windNovelMapper.getNovelList(windNovel);
  }

  @Override
  public void addNovel(WindNovel windNovel) {

  }

  @Override
  public void updateNovel(WindNovel windNovel) {

  }

  @Override
  public void tombstoneWxAccount(String novelId) throws Exception {
    var windNovel = this.windNovelMapper.selectById(novelId);
    if (windNovel.getNovelStatus() == DataStatus.Deleted) {
      throw new Exception("本书已被删除，请勿重复删除!");
    } else {
      windNovel.setNovelStatus(DataStatus.Deleted);
      windNovel.setUpdateDate(LocalDateTime.now());
      this.windNovelMapper.updateById(windNovel);
    }
  }

  @Override
  public List<WindNovel> getNovelByUserId(String userId) {
    var windNovel = new WindNovel();
    windNovel.setCreateById(userId);
    return this.windNovelMapper.getNovelList(windNovel);
  }

  @Override
  public WindNovel getNovelByNovelId(String novelId) {
    return this.windNovelMapper.selectById(novelId);
  }
}
