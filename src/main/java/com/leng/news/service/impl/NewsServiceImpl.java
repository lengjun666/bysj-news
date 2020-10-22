package com.leng.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leng.news.dao.INewsDao;
import com.leng.news.domain.News;
import com.leng.news.service.INewsService;
import com.leng.news.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements INewsService {

    @Autowired
    private INewsDao newsDao;

    // 根据文章标题和状态 查询文章
    public PageInfo<News> selectByTitleAndStatus(News news, int page, int limit) {
        PageHelper.startPage(page, limit);
        String val = news.getTitle();
        val = val == null ? "" : val;
        news.setTitle("%" + val + "%");
        List<News> newsList = setTimeAndSetStatus(newsDao.selectByTitleAndStatus(news));
        return new PageInfo<News>(newsList);
    }

    // 根据id 查询文章
    public News selectById(News news) {
        News news1 = newsDao.selectById(news);
        if (news1.getAddTime() != null) {
            news1.setAddTimeStr(DateUtils.date2String(news1.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (news1.getReleaseTime() != null) {
            news1.setReleaseTimeStr(DateUtils.date2String(news1.getReleaseTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        return news1;
    }

    // 根据id 更新文章状态
    public int updateStatusById(News news) {
        news.setReleaseTime(new Date());
        return newsDao.updateStatusById(news);
    }

    // 根据类型id 查询文章
    public List<News> selectByTypeId(Integer typeId) {
        List<News> newsList = setTimeAndSetStatus(newsDao.selectByTypeId(typeId));
        return newsList;
    }

    // 根据用户id 查询文章
    public PageInfo<News> selectByUserId(News news, int page, int limit) {
        PageHelper.startPage(page, limit);
        List<News> newsList = setTimeAndSetStatus(newsDao.selectByUserId(news));
        return new PageInfo<News>(newsList);
    }

    // 根据文章标题和用户id 查询文章
    public PageInfo<News> selectByTitleAndUserId(News news, int page, int limit) {
        PageHelper.startPage(page, limit);
        String val = news.getTitle();
        val = val == null ? "" : val;
        news.setTitle("%" + val + "%");
        List<News> newsList = setTimeAndSetStatus(newsDao.selectByTitleAndUserId(news));
        return new PageInfo<News>(newsList);
    }

    // 根据文章点击量 查询文章
    public List<News> selectByClick() {
        List<News> newsList = setTimeAndSetStatus(newsDao.selectByClick());
        return newsList;
    }

    // 更新文章 点击量
    public int updateClick(Integer id) {
        return newsDao.updateClick(id);
    }

    // 添加文章 设置状态
    public int insertStatus(News news) {
        news.setReleaseTime(new Date());
        return newsDao.insertStatus(news);
    }

    // 根据文章id 更新文章 设置状态
    public int update(News news) {
        news.setReleaseTime(new Date());
        return newsDao.update(news);
    }

    // 根据id 删除文章
    public int delete(News news) {
        return newsDao.delete(news);
    }

    // 设置文章 时间和状态
    public List<News> setTimeAndSetStatus(List<News> newsList) {
        for (News news1 : newsList) {
            if (news1.getAddTime() != null) {
                news1.setAddTimeStr(DateUtils.date2String(news1.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (news1.getReleaseTime() != null) {
                news1.setReleaseTimeStr(DateUtils.date2String(news1.getReleaseTime(), "yyyy-MM-dd HH:mm:ss"));
            }
//            0 未提交，1 未审核，2 未通过，3通过，4下架
            if (news1.getStatus() != null) {
                if (news1.getStatus() == 0) {
                    news1.setStatusStr("未提交");
                } else if (news1.getStatus() == 1) {
                    news1.setStatusStr("未审核");
                } else if (news1.getStatus() == 2) {
                    news1.setStatusStr("未通过");
                } else if (news1.getStatus() == 3) {
                    news1.setStatusStr("通过");
                }
            }
        }
        return newsList;
    }
}
