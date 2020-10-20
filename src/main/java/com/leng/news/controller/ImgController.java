package com.leng.news.controller;

import com.leng.news.domain.UserInfo;
import com.leng.news.service.IImgService;
import com.leng.news.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("img")
public class ImgController {

    @Autowired
    private IImgService imgService;

    @Autowired
    private IUserService userService;

    @RequestMapping("layeditImg.do")
    public Map<String, Object> layeditImg(@Param("file") MultipartFile file) {
        Map<String, Object> res = imgService.layeditImg(file);
        return res;
    }

    @RequestMapping("userImg.do")
    public Map<String, Object> userImg(@Param("file") MultipartFile file, UserInfo userInfo) {
        Map<String, Object> res = imgService.userImg(file, userInfo);
        return res;
    }

    @RequestMapping("newsImg.do")
    public Map<String, Object> newsImg(@Param("file") MultipartFile file) {
        Map<String, Object> res = imgService.newsImg(file);
        return res;
    }
}
