package com.leng.news.service;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    PageInfo<UserInfo> selectByName(UserInfo userInfo, int page, int limit);

    int delete(UserInfo userInfo);

    int updateStatus(UserInfo userInfo);

    int updatePassword(UserInfo userInfo);

    int insert(UserInfo userInfo);

    int selectPasswordById(UserInfo userInfo);

    int update(UserInfo userInfo);

    UserInfo selectById();

    Integer selectId();

}
