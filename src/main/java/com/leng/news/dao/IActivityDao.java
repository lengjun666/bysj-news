package com.leng.news.dao;

import com.leng.news.domain.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IActivityDao {

    // 根据标题 模糊查询
    @Select("select * from activity where title like #{title} order by endtime desc")
    List<Activity> selectByName(Activity activity);

    // 添加 活动
    @Insert("insert into activity (userid,title,activity,addtime,endtime) values (#{userId},#{title},#{activity},#{addTime},#{endTime})")
    int insert(Activity activity);

    // 删除 活动
    @Delete("delete from activity where id = #{id}")
    int delete(Activity activity);

    // 根据id 更新活动状态
    @Update("update activity set status = #{status} where id = #{id}")
    int updateStatus(Activity activity);

    // 根据id 查询活动
    @Select("select * from activity where id = #{id}")
    Activity selectById(Activity activity);

    // 查询所有 状态为开启的活动
    @Select("select * from activity where status = 1")
    List<Activity> selectByStatus();
}
