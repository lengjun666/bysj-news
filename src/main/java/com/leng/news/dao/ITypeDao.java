package com.leng.news.dao;

import com.leng.news.domain.Type;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ITypeDao {

    // 根据类型名 模糊查询
    @Select("select * from type where typename like #{typeName}")
    List<Type> selectByName(Type type);

    @Select("select * from type where typename = #{typeName}")
    Type findByName(Type type);

    // 根据类型名 精确查询
    @Insert("insert into type (typename) values(#{typeName})")
    int insert(Type type);

    // 根据 id 删除类型
    @Delete("delete from type where id = #{id}")
    int delete(Type type);

    // 根据id 更新类型
    @Update("update type set typename = #{typeName} where id = #{id}")
    int update(Type type);

    // 根据id 查询
    @Select("select * from type where id = #{id}")
    Type selectById(Type type);

    // 查询所有
    @Select("select * from type")
    List<Type> selectByAll();

    @Select("select typename from type where id = #{id}")
    String selectTypeNameById(Integer id);
}
