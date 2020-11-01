package com.leng.news.controller;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.UserInfo;
import com.leng.news.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("selectByName.do")
    public Map<String, Object> selectByName(UserInfo userInfo, int page, int limit) {
        PageInfo<UserInfo> info = userService.selectByName(userInfo, page, limit);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", info.getList());
        res.put("count", info.getTotal());
        res.put("code", 0);
        return res;
    }

    @RequestMapping("insert.do")
    public int insert(UserInfo userInfo) {
        return userService.insert(userInfo);
    }

    @RequestMapping("delete.do")
    public int delete(UserInfo userInfo) {
        return userService.delete(userInfo);
    }

    @RequestMapping("updateStatus.do")
    public int updateStatus(UserInfo userInfo) {
        return userService.updateStatus(userInfo);
    }

    @RequestMapping("updatePassword.do")
    public int updatePassword(UserInfo userInfo) {
        return userService.updatePassword(userInfo);
    }

    @RequestMapping("selectPasswordById.do")
    public int selectPasswordById(UserInfo userInfo) {
        return userService.selectPasswordById(userInfo);
    }

    @RequestMapping("selectById.do")
    public UserInfo selectById() {
        return userService.selectById();
    }

    @RequestMapping("update.do")
    public int update(UserInfo userInfo) {
        return userService.update(userInfo);
    }

}

