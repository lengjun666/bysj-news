package com.leng.news.domain;

import lombok.Data;

@Data
public class Img {

    private Integer id; // 无意义，主键
    private Integer newsId; // 文章id
    private String src; // 路径
}
