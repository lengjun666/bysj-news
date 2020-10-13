package com.leng.news.controller;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.News;
import com.leng.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @RequestMapping("selectByTitleAndStatus.do")
    public Map<String, Object> selectByTitleAndStatus(News news, int page, int limit) {
        PageInfo<News> info = newsService.selectByTitleAndStatus(news, page, limit);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", info.getList());
        res.put("count", info.getTotal());
        res.put("code", 0);
        return res;
    }

    @RequestMapping("selectById.do")
    public News selectById(News news) {
        return newsService.selectById(news);
    }

    @RequestMapping("updateStatusById.do")
    public int updateStatusById(News news) {
        return newsService.updateStatusById(news);
    }

    @RequestMapping("selectByUserId.do")
    public Map<String, Object> selectByUserId(News news, int page, int limit) {
        PageInfo<News> info = newsService.selectByUserId(news, page, limit);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", info.getList());
        res.put("count", info.getTotal());
        res.put("code", 0);
        return res;
    }

    @RequestMapping("selectByTitleAndUserId.do")
    public Map<String, Object> selectByTitleAndUserId(News news, int page, int limit) {
        PageInfo<News> info = newsService.selectByTitleAndUserId(news, page, limit);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", info.getList());
        res.put("count", info.getTotal());
        res.put("code", 0);
        return res;
    }

    @RequestMapping("selectByTypeId.do")
    public List<News> selectByTypeId(Integer typeId) {
        System.out.println(typeId);
        return newsService.selectByTypeId(typeId);
    }

    @RequestMapping("selectByClick.do")
    public List<News> selectByClick() {
        return newsService.selectByClick();
    }

    @RequestMapping("updateClick.do")
    public int updateClick(Integer id) {
        return newsService.updateClick(id);
    }

    @RequestMapping("insertStatus.do")
    public int insertStatus(News news) {
        return newsService.insertStatus(news);
    }

    @RequestMapping("update.do")
    public int update(News news) {
        return newsService.update(news);
    }

    @RequestMapping("delete.do")
    public int delete(News news) {
        return newsService.delete(news);
    }
}
