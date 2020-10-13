package com.leng.news.domain;

import lombok.Data;

import java.util.Date;

@Data
public class News {

    private Integer id; // 无意义，主键
    private String title; // 文章标题
    private Integer typeId; // 类型id
    private String typeName;
    private String introduction; // 文章简介
    private String content; // 文章内容
    private Date addTime; // 添加时间
    private String addTimeStr;
    private Date releaseTime; // 发布时间
    private String releaseTimeStr;
    private Integer userId; // 发布者
    private String nickName;
    private Integer status; // 状态  0 未提交，1 未审核，2 未通过，3通过
    private String statusStr;
    private Integer click; // 点击量
}
