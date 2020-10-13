package com.leng.news.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Activity {

    private Integer id; // 无意义，主键
    private Integer userId; // 用户id
    private String title; // 活动标题
    private String activity; // 活动内容
    private Date addTime; // 开始时间
    private String addTimeStr;
    private Date endTime; // 结束时间
    private String endTimeStr;
    private Integer status; // 状态，0 未开启，1 开启
    private String statusStr;
    private String timeStr;// 临时时间
}
