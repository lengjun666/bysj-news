package com.leng.news.service;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Notice;

public interface INoticeService {

    PageInfo<Notice> selectAll(Notice notice, int page, int limit);

    int insert(Notice notice);

    Notice selectById(Notice notice);

    int delete(Notice notice);

    Notice selectOne();
}
