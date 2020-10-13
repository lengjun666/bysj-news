package com.leng.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leng.news.dao.IRoleDao;
import com.leng.news.domain.Role;
import com.leng.news.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    public PageInfo<Role> selectByName(Role role, int page, int limit) {
        PageHelper.startPage(page, limit);
        String val = role.getRoleName();
        val = val == null ? "" : val;
        role.setRoleName("%" + val + "%");
        List<Role> roles = roleDao.selectByName(role);
        return new PageInfo<Role>(roles);
    }

}
