package com.leng.news.dao;

import com.leng.news.domain.Role;
import com.leng.news.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    // 根据用户名 模糊查询
    @Select("select * from user where username like #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickName", column = "nickname"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "addTime", column = "addTime"),
            @Result(property = "img", column = "img"),
            @Result(property = "roleId", column = "roleid"),
            @Result(property = "status", column = "status"),
            @Result(property = "roleDesc", column = "roleid", javaType = String.class, one = @One(select = "com.leng.news.dao.IRoleDao.selectRoleDescById"))
    })
    List<UserInfo> selectByName(UserInfo userInfo);

    // 根据id 删除用户
    @Delete("delete from user where id = #{id}")
    int delete(UserInfo userInfo);

    // 根据id 更新用户状态
    @Update("update user set status = #{status} where id = #{id}")
    int updateStatus(UserInfo userInfo);

    // 根据id 更新密码
    @Update("update user set password = #{password} where id = #{id} ")
    int updatePassword(UserInfo userInfo);

    // 注册，添加 用户
    @Insert("insert into user (username,password,sex,email,phone,roleid) values (#{username},#{password},#{sex},#{email},#{phone},#{roleId})")
    int insert(UserInfo userInfo);

    // 根据id 查询密码
    @Select("select * from user where id = #{id}")
    UserInfo selectPasswordById(UserInfo userInfo);

    // 根据用户名 精确查询
    @Select("select * from user where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickName", column = "nickname"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "addTime", column = "addTime"),
            @Result(property = "img", column = "img"),
            @Result(property = "roleId", column = "roleid"),
            @Result(property = "status", column = "status"),
            @Result(property = "role", column = "roleid", javaType = Role.class, one = @One(select = "com.leng.news.dao.IRoleDao.selectRoleById"))
    })
    UserInfo findByUsername(String username);

    // 根据id 更新用户信息
    @Update("update user set nickname = #{nickName}, roleid = #{roleId}, sex = #{sex}, email = #{email}, phone = #{phone} where id = #{id}")
    int update(UserInfo userInfo);

    // 根据id 查询用户详情
    @Select("select * from user where id = #{id}")
    UserInfo selectById(UserInfo userInfo);

    @Select("select nickname from user where id = #{id}")
    String selectNickNameById(Integer id);
}
