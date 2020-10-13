package com.leng.news.controller;

import com.github.pagehelper.PageInfo;
import com.leng.news.domain.Notice;
import com.leng.news.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @RequestMapping("selectAll.do")
    public Map<String, Object> selectAll(Notice notice, int page, int limit) {
        PageInfo<Notice> info = noticeService.selectAll(notice, page, limit);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", info.getList());
        res.put("count", info.getTotal());
        res.put("code", 0);
        return res;
    }

    @RequestMapping("insert.do")
    public int insert(Notice notice) {
        return noticeService.insert(notice);
    }

    @RequestMapping("selectById.do")
    public Notice selectById(Notice notice) {
        return noticeService.selectById(notice);
    }

    @RequestMapping("delete.do")
    public int delete(Notice notice) {
        return noticeService.delete(notice);
    }

    @RequestMapping("selectOne.do")
    public Notice selectOne() {
        return noticeService.selectOne();
    }
}
