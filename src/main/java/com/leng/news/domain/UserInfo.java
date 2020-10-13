package com.leng.news.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {

    private Integer id; // 无意义，主键
    private String username; // 用户名，唯一，不可修改
    private String password; // 密码，加密
    private String nickName; // 昵称
    private String sex;
    private String email; // 邮箱
    private String phone; // 手机号
    private Date addTime; // 注册时间
    private String addTimeStr;
    private String img; // 头像路径
    private Integer roleId; // 角色id
    private Integer status; // 状态 0 正常， 1封号
    private String statusStr;
    private String roleDesc; // 角色描述
    private Role role;
}
