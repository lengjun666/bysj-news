package com.leng.news.service;

import com.leng.news.domain.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface IImgService {
    Map<String, Object> layeditImg(MultipartFile img);

    Map<String, Object> newsImg(MultipartFile file);

    Map<String, Object> userImg(MultipartFile file, UserInfo userInfo);
}
