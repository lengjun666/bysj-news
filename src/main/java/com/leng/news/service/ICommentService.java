package com.leng.news.service;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Comment;

public interface ICommentService {
    PageInfo<Comment> selectByNewsId(Comment comment, int page, int limit);

    int insert(Comment comment);

    int delete(Comment comment);
}
