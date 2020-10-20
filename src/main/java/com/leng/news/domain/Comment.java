package com.leng.news.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {

    private Integer id; // 无意义，主键
    private Integer userId; // 用户id
    private Integer newsId; // 文章id
    private String comment; // 评论内容
    private Date addTime; // 添加时间
    private String addTimeStr;
}
