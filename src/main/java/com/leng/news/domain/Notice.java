package com.leng.news.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {

    private Integer id; // 无意义，主键
    private Integer userId; // 用户id
    private String notice; // 通知公告
    private Date addTime; // 添加时间
    private String addTimeStr;
}
