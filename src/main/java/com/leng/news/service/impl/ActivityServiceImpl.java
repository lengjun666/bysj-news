package com.leng.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leng.news.dao.IActivityDao;
import com.leng.news.domain.Activity;
import com.leng.news.service.IActivityService;
import com.leng.news.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements IActivityService {

    @Autowired
    private IActivityDao activityDao;

    // 根据标题 模糊查询
    public PageInfo<Activity> selectByName(Activity activity, int page, int limit) {
        PageHelper.startPage(page, limit);
        String val = activity.getTitle();
        val = val == null ? "" : val;
        activity.setTitle("%" + val + "%");
        List<Activity> activities = activityDao.selectByName(activity);
        // 日期转字符串
        for (Activity activityTemp : activities) {
            if (activityTemp.getAddTime() != null) {
                activityTemp.setAddTimeStr(DateUtils.date2String(activityTemp.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (activityTemp.getEndTime() != null) {
                activityTemp.setEndTimeStr(DateUtils.date2String(activityTemp.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        return new PageInfo<Activity>(activities);
    }

    // 添加 活动
    public int insert(Activity activity) {
        // 字符串转日期
        if (activity.getTimeStr() != null) {
            String[] strArr = activity.getTimeStr().split("→");
            activity.setAddTimeStr(strArr[0]);
            activity.setEndTimeStr(strArr[1]);
            try {
                activity.setAddTime(DateUtils.string2Date(activity.getAddTimeStr(), "yyyy-MM-dd HH:mm:ss"));
                activity.setEndTime(DateUtils.string2Date(activity.getEndTimeStr(), "yyyy-MM-dd HH:mm:ss"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return activityDao.insert(activity);
    }

    // 根据id 删除活动
    public int delete(Activity activity) {
        return activityDao.delete(activity);
    }

    // 根据id 更新活动状态
    public int updateStatus(Activity activity) {
        return activityDao.updateStatus(activity);
    }

    // 根据id 查询活动
    public Activity selectById(Activity activity) {
        Activity activity1 = activityDao.selectById(activity);
        if (activity1.getAddTime() != null) {
            activity1.setAddTimeStr(DateUtils.date2String(activity1.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (activity1.getEndTime() != null) {
            activity1.setEndTimeStr(DateUtils.date2String(activity1.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        return activity1;
    }

    // 查询所有状态为 开启的活动
    public List<Activity> selectByStatus() {
        return activityDao.selectByStatus();
    }
}
