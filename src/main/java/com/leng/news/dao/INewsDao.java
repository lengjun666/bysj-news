package com.leng.news.dao;

import com.leng.news.domain.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface INewsDao {

    // 根据文章标题和文章状态 查询文章
    @Select("select * from news where title like #{title} and status = #{status} order by releasetime desc")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "typeId", column = "typeid"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "content", column = "content"),
            @Result(property = "addTime", column = "addtime"),
            @Result(property = "releaseTime", column = "releasetime"),
            @Result(property = "userId", column = "userid"),
            @Result(property = "status", column = "status"),
            @Result(property = "click", column = "click"),
            @Result(property = "typeName", column = "typeid", javaType = String.class, one = @One(select = "com.leng.news.dao.ITypeDao.selectTypeNameById")),
            @Result(property = "nickName", column = "userid", javaType = String.class, one = @One(select = "com.leng.news.dao.IUserDao.selectNickNameById"))
    })
    List<News> selectByTitleAndStatus(News news);

    // 根据id 查询文章
    @Select("select * from news where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "typeId", column = "typeid"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "content", column = "content"),
            @Result(property = "addTime", column = "addtime"),
            @Result(property = "releaseTime", column = "releasetime"),
            @Result(property = "userId", column = "userid"),
            @Result(property = "status", column = "status"),
            @Result(property = "click", column = "click"),
            @Result(property = "typeName", column = "typeid", javaType = String.class, one = @One(select = "com.leng.news.dao.ITypeDao.selectTypeNameById")),
            @Result(property = "nickName", column = "userid", javaType = String.class, one = @One(select = "com.leng.news.dao.IUserDao.selectNickNameById"))
    })
    News selectById(News news);

    // 根据id 更新文章状态
    @Update("update news set status = #{status} where id = #{id}")
    int updateStatusById(News news);

    // 根据用户id 查询文章
    @Select("select * from news where userid = #{userId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "typeId", column = "typeid"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "content", column = "content"),
            @Result(property = "addTime", column = "addtime"),
            @Result(property = "releaseTime", column = "releasetime"),
            @Result(property = "userId", column = "userid"),
            @Result(property = "status", column = "status"),
            @Result(property = "click", column = "click"),
            @Result(property = "typeName", column = "typeid", javaType = String.class, one = @One(select = "com.leng.news.dao.ITypeDao.selectTypeNameById")),
            @Result(property = "nickName", column = "userid", javaType = String.class, one = @One(select = "com.leng.news.dao.IUserDao.selectNickNameById"))
    })
    List<News> selectByUserId(News news);

    // 根据标题和用户id 查询 状态为 未提交的文章
    @Select("select * from news where title like #{title} and status = #{status} and userid = #{userId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "typeId", column = "typeid"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "content", column = "content"),
            @Result(property = "addTime", column = "addtime"),
            @Result(property = "releaseTime", column = "releasetime"),
            @Result(property = "userId", column = "userid"),
            @Result(property = "status", column = "status"),
            @Result(property = "click", column = "click"),
            @Result(property = "typeName", column = "typeid", javaType = String.class, one = @One(select = "com.leng.news.dao.ITypeDao.selectTypeNameById")),
            @Result(property = "nickName", column = "userid", javaType = String.class, one = @One(select = "com.leng.news.dao.IUserDao.selectNickNameById"))
    })
    List<News> selectByTitleAndUserId(News news);

    // 添加文章 设置状态
    @Insert("insert into news (title,typeid,introduction,content,userid,status) values (#{title},#{typeId},#{introduction},#{content},#{userId},#{status})")
    int insertStatus(News news);

    // 根据文章id 更新文章
    @Update("update news set title = #{title}, typeid = #{typeId}, introduction = #{introduction}, content = #{content}, status = #{status} where id = #{id}")
    int update(News news);

    // 根据id 删除文章
    @Delete("delete from news where id = #{id}")
    int delete(News news);

    // 根据类型id 查询文章
    @Select("select * from news where typeid = #{typeId} and status = 3 order by click desc")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "typeId", column = "typeid"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "content", column = "content"),
            @Result(property = "addTime", column = "addtime"),
            @Result(property = "releaseTime", column = "releasetime"),
            @Result(property = "userId", column = "userid"),
            @Result(property = "status", column = "status"),
            @Result(property = "click", column = "click"),
            @Result(property = "typeName", column = "typeid", javaType = String.class, one = @One(select = "com.leng.news.dao.ITypeDao.selectTypeNameById")),
            @Result(property = "nickName", column = "userid", javaType = String.class, one = @One(select = "com.leng.news.dao.IUserDao.selectNickNameById"))
    })
    List<News> selectByTypeId(Integer typeId);


    // 根据点击量查询 文章
    @Select("select * from news where status = 3 order by click desc")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "typeId", column = "typeid"),
            @Result(property = "introduction", column = "introduction"),
            @Result(property = "content", column = "content"),
            @Result(property = "addTime", column = "addtime"),
            @Result(property = "releaseTime", column = "releasetime"),
            @Result(property = "userId", column = "userid"),
            @Result(property = "status", column = "status"),
            @Result(property = "click", column = "click"),
            @Result(property = "typeName", column = "typeid", javaType = String.class, one = @One(select = "com.leng.news.dao.ITypeDao.selectTypeNameById")),
            @Result(property = "nickName", column = "userid", javaType = String.class, one = @One(select = "com.leng.news.dao.IUserDao.selectNickNameById"))
    })
    List<News> selectByClick();

    @Update("update news set click = click + 1 where id = #{id}")
    int updateClick(Integer id);
}
