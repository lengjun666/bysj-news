package com.leng.news.domain;

import lombok.Data;

@Data
public class Role {

    private Integer id; // 无意义，主键
    private String roleName; // 角色名称
    private String roleDesc; // 角色描述
}
