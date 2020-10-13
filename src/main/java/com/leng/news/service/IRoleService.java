package com.leng.news.service;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Role;

public interface IRoleService {
    PageInfo<Role> selectByName(Role role, int page, int limit);

}
