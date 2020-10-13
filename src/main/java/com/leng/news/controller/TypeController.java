package com.leng.news.controller;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Type;
import com.leng.news.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("type")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @RequestMapping("selectByName.do")
    public Map<String, Object> selectByName(Type type, int page, int limit) {
        PageInfo<Type> info = typeService.selectByName(type, page, limit);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", info.getList());
        res.put("count", info.getTotal());
        res.put("code", 0);
        return res;
    }

    @RequestMapping("insert.do")
    public int insert(Type type) {
        return typeService.insert(type);
    }

    @RequestMapping("delete.do")
    public int delete(Type type) {
        return typeService.delete(type);
    }

    @RequestMapping("update.do")
    public int update(Type type) {
        return typeService.update(type);
    }

    @RequestMapping("selectById.do")
    public Type selectById(Type type) {
        return typeService.selectById(type);
    }

    @RequestMapping("selectByAll")
    public List<Type> selectByAll() {
        return typeService.selectByAll();
    }

}
