package com.leng.news.controller;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Role;
import com.leng.news.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("selectByName.do")
    public Map<String, Object> selectByName(Role role, int page, int limit) {
        PageInfo<Role> info = roleService.selectByName(role, page, limit);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", info.getList());
        res.put("count", info.getTotal());
        res.put("code", 0);
        return res;
    }
}
