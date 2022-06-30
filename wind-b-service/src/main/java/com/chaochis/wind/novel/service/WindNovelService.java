package com.chaochis.wind.novel.service;

import com.chaochis.wind.novel.vo.WindNovel;

import java.util.List;

/**
 * 小说表服务类
 * @author 刘超/chaochis
 */
public interface WindNovelService {
  /**
   * 获取小说列表
   * @param windNovel 要查询的小说参数
   * @return 返回查询到的小说列表
   */
  List<WindNovel> getNovelList(WindNovel windNovel);

  /**
   * 添加一本新的小说
   * @param windNovel 要添加的小说所有参数
   */
  void addNovel(WindNovel windNovel);

  /**
   * 更新小说的信息
   * @param windNovel 要更新的小说信息
   */
  void updateNovel(WindNovel windNovel);

  /**
   * 逻辑删除某部小说
   * @param novelId 小说id
   */
  void tombstoneWxAccount(String novelId) throws Exception;

  /**
   * 获取某个用户名下的所有小说
   * @param userId 用户id
   * @return 返回该用户创建的所有小说
   */
  List<WindNovel> getNovelByUserId(String userId);

  /**
   * 根据小说id获取小说信息
   * @param novelId 小说id
   * @return 小说id对应的小说
   */
  WindNovel getNovelByNovelId(String novelId);
}
