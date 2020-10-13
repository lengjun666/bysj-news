package com.leng.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leng.news.dao.INoticeDao;
import com.leng.news.domain.Notice;
import com.leng.news.service.INoticeService;
import com.leng.news.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private INoticeDao noticeDao;

    // 查询所有通知
    public PageInfo<Notice> selectAll(Notice notice, int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Notice> notices = noticeDao.selectAll(notice);
        for (Notice noticeTemp : notices) {
            if (noticeTemp.getAddTime() != null) {
                noticeTemp.setAddTimeStr(DateUtils.date2String(noticeTemp.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        return new PageInfo<Notice>(notices);
    }

    // 添加
    public int insert(Notice notice) {
        return noticeDao.insert(notice);
    }

    // 根据 id 查询通知
    public Notice selectById(Notice notice) {
        return noticeDao.selectById(notice);
    }

    // 根据id 删除通知
    public int delete(Notice notice) {
        return noticeDao.delete(notice);
    }

    // 查询最新的一个通知
    public Notice selectOne() {
        Notice notice = noticeDao.selectByOne();
        if (notice.getAddTime() != null) {
            notice.setAddTimeStr(DateUtils.date2String(notice.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        return notice;
    }
}
