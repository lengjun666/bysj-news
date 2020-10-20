package com.leng.news.dao;

import com.leng.news.domain.UserInfo;
import org.apache.ibatis.annotations.Update;

public interface IImgDao {

    // 根据id 更新用户头像
    @Update("update user set img = #{img} where id = #{id}")
    void updateUserImg(UserInfo userInfo);
}
