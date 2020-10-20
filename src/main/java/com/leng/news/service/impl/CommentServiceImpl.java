package com.leng.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leng.news.dao.ICommentDao;
import com.leng.news.domain.Comment;
import com.leng.news.service.ICommentService;
import com.leng.news.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentDao commentDao;

    // 根据文章id 查询评论
    public PageInfo<Comment> selectByNewsId(Comment comment, int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Comment> comments = commentDao.selectByNewsId(comment);
        for (Comment comment1 : comments) {
            if (comment1.getAddTime() != null) {
                comment1.setAddTimeStr(DateUtils.date2String(comment1.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        return new PageInfo<Comment>(comments);
    }

    // 添加评论
    public int insert(Comment comment) {
        return commentDao.insert(comment);
    }

    // 根据id 删除评论
    public int delete(Comment comment) {
        return commentDao.delete(comment);
    }
}
