package com.leng.news.service.impl;

import com.leng.news.dao.IImgDao;
import com.leng.news.service.IImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImgServiceImpl implements IImgService {

    @Autowired
    private IImgDao imgDao;
}
