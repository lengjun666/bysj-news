package com.leng.news.dao;

import com.leng.news.domain.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface INoticeDao {

    @Select("select * from notice order by addtime desc")
    List<Notice> selectAll(Notice notice);

    @Insert("insert into notice (userid,notice) values(#{userId},#{notice})")
    int insert(Notice notice);

    @Select("select * from notice where id = #{id}")
    Notice selectById(Notice notice);

    @Delete("delete from notice where id = #{id}")
    int delete(Notice notice);

    @Select("select * from notice order by addtime desc limit 1")
    Notice selectByOne();
}
