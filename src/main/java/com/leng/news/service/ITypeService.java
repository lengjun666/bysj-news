package com.leng.news.service;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Type;

import java.util.List;

public interface ITypeService {
    PageInfo<Type> selectByName(Type type, int page, int limit);

    int insert(Type type);

    int delete(Type type);

    int update(Type type);

    Type selectById(Type type);

    List<Type> selectByAll();
}
