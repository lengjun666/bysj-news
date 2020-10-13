package com.leng.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leng.news.dao.ITypeDao;
import com.leng.news.domain.Type;
import com.leng.news.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private ITypeDao typeDao;

    // 根据类型名 模糊查询
    public PageInfo<Type> selectByName(Type type, int page, int limit) {
        PageHelper.startPage(page, limit);
        String val = type.getTypeName();
        val = val == null ? "" : val;
        type.setTypeName("%" + val + "%");
        List<Type> types = typeDao.selectByName(type);
        return new PageInfo<Type>(types);
    }

    public int insert(Type type) {
        //  如果类型名称重复，则不允许添加，否则可以添加
        Type type1 = new Type();
        type1.setTypeName(type.getTypeName());
        Type typeTemp = findByName(type1);
        if (typeTemp == null) {
            return typeDao.insert(type);
        } else {
            return 2;
        }
    }

    // 根据id 删除类型
    public int delete(Type type) {
        return typeDao.delete(type);
    }

    // 根据id 更新类型
    public int update(Type type) {
        return typeDao.update(type);
    }

    // 根据id 查询类型
    public Type selectById(Type type) {
        return typeDao.selectById(type);
    }

    // 查询所有
    public List<Type> selectByAll() {
        return typeDao.selectByAll();
    }

    // 根据类型名精确查询
    public Type findByName(Type type) {
        return typeDao.findByName(type);
    }
}
