package com.leng.news.service;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Activity;

import java.util.List;

public interface IActivityService {
    PageInfo<Activity> selectByName(Activity activity, int page, int limit);

    int insert(Activity activity);

    Activity selectById(Activity activity);

    int delete(Activity activity);

    int updateStatus(Activity activity);

    List<Activity> selectByStatus();
}
