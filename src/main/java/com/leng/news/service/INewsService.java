package com.leng.news.service;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.News;

import java.util.List;

public interface INewsService {
    PageInfo<News> selectByTitleAndStatus(News news, int page, int limit);

    News selectById(News news);

    int updateStatusById(News news);

    PageInfo<News> selectByUserId(News news, int page, int limit);

    PageInfo<News> selectByTitleAndUserId(News news, int page, int limit);

    int insertStatus(News news);

    int update(News news);

    int delete(News news);

    List<News> selectByTypeId(Integer typeId);

    List<News> selectByClick();

    int updateClick(Integer id);
}
