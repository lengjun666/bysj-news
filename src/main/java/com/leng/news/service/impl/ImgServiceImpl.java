package com.leng.news.service.impl;

import com.leng.news.dao.IImgDao;
import com.leng.news.dao.IUserDao;
import com.leng.news.domain.UserInfo;
import com.leng.news.service.IImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class ImgServiceImpl implements IImgService {

    @Autowired
    private IImgDao imgDao;

    @Autowired
    private IUserDao userDao;

    // 文章 图片上传
    public Map<String, Object> layeditImg(MultipartFile file) {
        String fileName = "/upload/img/newsImg/";
        Map<String, Object> res = upload(file, fileName);
        res.remove("src");
        return res;
    }

    // 文章封面 图片上传
    public Map<String, Object> newsImg(MultipartFile file) {
        String fileName = "/upload/img/cover/";
        Map<String, Object> res = upload(file, fileName);
        res.remove("src");
        return res;
    }

    // 用户头像 图片上传
    public Map<String, Object> userImg(MultipartFile file, UserInfo userInfo) {
        String fileName = "/upload/img/userImg/";
        Map<String, Object> res = upload(file, fileName);
        userInfo.setImg(res.get("src").toString());
        imgDao.updateUserImg(userInfo);
        res.remove("src");
        return res;
    }

    public Map<String, Object> upload(MultipartFile file, String fileName) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> res = new HashMap<String, Object>();
        if (file != null) {
            String imgService = "D:\\DevTools\\Software\\phpstudy_pro\\Extensions\\Nginx1.16.1\\html";
            try {
                String substring = file.getOriginalFilename();
                // 图片的路径+文件名称
                fileName = fileName + substring;
                // 图片的在服务器上面的物理路径
                File destFile = new File(imgService, fileName);
                // 生成upload目录
                File parentFile = destFile.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();// 自动生成upload目录
                }
                // 把上传的临时图片，复制到图片服务器路径
                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(destFile));
                map = new HashMap<String, Object>();
                res = new HashMap<String, Object>();
                String src = "http://localhost:8010" + fileName;
                map.put("src", src);//图片url
                map.put("title", substring);//图片名称，这个会显示在输入框里
                res.put("code", 0);//0表示成功，1失败
                res.put("msg", "上传成功");//提示消息
                res.put("data", map);
                res.put("src", src);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
