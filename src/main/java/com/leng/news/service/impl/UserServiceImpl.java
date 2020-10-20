package com.leng.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leng.news.dao.IUserDao;
import com.leng.news.domain.Role;
import com.leng.news.domain.UserInfo;
import com.leng.news.service.IUserService;
import com.leng.news.utils.DateUtils;
import com.leng.news.utils.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // 用户登录验证
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的User对象封装成UserDetails
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0, true, true, true, getAuthority(userInfo.getRole()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(Role role) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return list;
    }

    // 根据用户名 模糊查询
    public PageInfo<UserInfo> selectByName(UserInfo userInfo, int page, int limit) {
        PageHelper.startPage(page, limit);
        String val = userInfo.getUsername();
        val = val == null ? "" : val;
        userInfo.setUsername("%" + val + "%");
        List<UserInfo> userList = userDao.selectByName(userInfo);
        for (UserInfo user : userList) {
            if (user.getAddTime() != null) {
                user.setAddTimeStr(DateUtils.date2String(user.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        return new PageInfo<UserInfo>(userList);
    }

    // 注册，添加 用户
    public int insert(UserInfo userInfo) {
        UserInfo userTemp = findByName(userInfo.getUsername());
        if (userTemp == null) {
            // 密码加密
            userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
            return userDao.insert(userInfo);
        } else {
            return 2;
        }
    }

    // 根据id 删除用户
    public int delete(UserInfo userInfo) {
        return userDao.delete(userInfo);
    }

    // 根据id 更新用户状态
    public int updateStatus(UserInfo userInfo) {
        return userDao.updateStatus(userInfo);
    }

    // 根据id 更新用户密码
    public int updatePassword(UserInfo userInfo) {
        userInfo.setId(selectId());
        // 密码加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        return userDao.updatePassword(userInfo);
    }

    // 根据id查询密码 验证密码是否正确
    public int selectPasswordById(UserInfo userInfo) {
        userInfo.setId(selectId());
        UserInfo userInfoTemp = userDao.selectPasswordById(userInfo);
        if (bCryptPasswordEncoder.matches(userInfo.getPassword(), userInfoTemp.getPassword())) {
            return 2;
        } else {
            return 1;
        }
//        if (userInfo.getPassword().equals(userInfoTemp.getPassword())){
//            return 2;
//        }else {
//            return 1;
//        }
    }

    // 根据id 查询用户信息
    public UserInfo selectById() {
        UserInfo userInfo = userDao.selectById(selectId());
        return userInfo;
    }

    // 根据id 更新用户信息
    public int update(UserInfo userInfo) {
        userInfo.setId(selectId());
        return userDao.update(userInfo);
    }

    // 根据用户名 精确查询
    public UserInfo findByName(String username) {
        return userDao.findByUsername(username);
    }

    // 根据username 获取userId
    public Integer selectId() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(UserInfoUtils.getUserName());
        // 判断用户名是否存在
        if (userInfo.getUsername() == null) {
            // 不存在
            return 0;
        } else {
            // 存在 查询id 返回id
            return userDao.selectId(userInfo);
        }
    }
}
