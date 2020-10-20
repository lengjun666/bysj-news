package com.leng.news.controller;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Activity;
import com.leng.news.service.IActivityService;
import com.leng.news.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    @Autowired
    private IUserService userService;

    @RequestMapping("selectByName.do")
    public Map<String, Object> selectByName(Activity activity, int page, int limit) {
        PageInfo<Activity> info = activityService.selectByName(activity, page, limit);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", info.getList());
        res.put("count", info.getTotal());
        res.put("code", 0);
        return res;
    }

    @RequestMapping("insert.do")
    public int insert(Activity activity) {
        activity.setUserId(userService.selectId());
        return activityService.insert(activity);
    }

    @RequestMapping("selectById.do")
    public Activity selectById(Activity activity) {
        System.out.println(activity);
        return activityService.selectById(activity);
    }

    @RequestMapping("delete.do")
    public int delete(Activity activity) {
        return activityService.delete(activity);
    }

    @RequestMapping("updateStatus.do")
    public int updateStatus(Activity activity) {
        return activityService.updateStatus(activity);
    }

    @RequestMapping("selectByStatus.do")
    public List<Activity> selectByStatus() {
        return activityService.selectByStatus();
    }
}
