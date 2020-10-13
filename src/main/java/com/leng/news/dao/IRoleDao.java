package com.leng.news.dao;

import com.leng.news.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    // 根据角色名 查询角色
    @Select("select * from role where roleName like #{roleName}")
    List<Role> selectByName(Role role);

    // 根据id 查询角色描述
    @Select("select roleDesc from role where id = #{id}")
    String selectRoleDescById(Integer id);

    // 根据id 查询角色
    @Select("select * from role where id = #{id}")
    Role selectRoleById(Integer id);

}
