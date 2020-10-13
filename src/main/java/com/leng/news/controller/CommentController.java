package com.leng.news.controller;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Comment;
import com.leng.news.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @RequestMapping("selectByNewsId.do")
    public Map<String, Object> selectByName(Comment comment, int page, int limit) {
        PageInfo<Comment> info = commentService.selectByNewsId(comment, page, limit);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", info.getList());
        res.put("count", info.getTotal());
        res.put("code", 0);
        return res;
    }

    @RequestMapping("insert.do")
    public int insert(Comment comment) {
        return commentService.insert(comment);
    }

    @RequestMapping("delete.do")
    public int delete(Comment comment) {
        return commentService.delete(comment);
    }

}
