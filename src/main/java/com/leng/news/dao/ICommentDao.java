package com.leng.news.dao;

import com.leng.news.domain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ICommentDao {

    // 根据文章id 查询评论
    @Select("select * from comment where newsid = #{newsId}")
    List<Comment> selectByNewsId(Comment comment);

    // 添加评论
    @Insert("insert into comment (userid,newsid,comment) values(#{userId},#{newsId},#{comment})")
    int insert(Comment comment);

    // 根据id 删除评论
    @Delete("delete from comment where id = #{id}")
    int delete(Comment comment);
}
