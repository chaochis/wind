package com.chaochis.wind.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaochis.wind.novel.vo.WindNovel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WindNovelMapper extends BaseMapper<WindNovel> {
  List<WindNovel> getNovelList(WindNovel windNovel);
}
