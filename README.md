## JavaWeb 新闻系统

基于SSM的新闻系统

### 介绍

毕业设计项目，使用ssm，bootstrap，layui，vue.js，spring security实现。

#### 实现功能

- [x] 登录/注册
- [x] 搜索
- [x] 公告
- [x] 活动
- [x] 评论

##### 管理后台

- [x] 个人信息

- [x] 用户管理
- [x] 文章管理
- [x] 文章类型管理
- [x] 公告/活动管理
- [x] 添加文章

### 项目部署

#### 版本

**IED** Intellij IDEA

**tomcat** 7   （IDEA 内置tomcat 7 插件）

**jdk** 1.8

**mysql**  mysql 5.7.26

**nginx**  1.16.1

**spring**  5.0.2.RELEASE

**mybatis** 3.4.5

**spring secutity** 5.0.1.RELEASE

#### 说明

1. MySQL数据库，见项目根目录 bysj03.sql,需手动导入，仅结构，数据需手动添加，密码使用bCryptPasswordEncoder加密，
2. IDEA tomcat插件端口为 8888
3. nginx  的端口为 8010  ，图片相关功能，使用nginx映射本地文件，可自行修改，如修改，需同步修改 ImgServiceImpl 类中的src 路径
4. 数据库配置文件，见db.properties ，user表的img字段为头像，有默认值
5. 后台页面 系统管理员 用户名 root 密码 root
#### 部分预览图

首页（新闻页）

![](https://raw.githubusercontent.com/lengjun666/Img/master/imgimage-20201022103242775.png)

详情页

![](https://raw.githubusercontent.com/lengjun666/Img/master/imgimage-20201022103417667.png)

管理后台，个人信息页

![](https://raw.githubusercontent.com/lengjun666/Img/master/imgimage-20201022104048956.png)

管理后台，用户管理

![](https://raw.githubusercontent.com/lengjun666/Img/master/imgimage-20201022104309187.png)

管理后台，添加文章

![](https://raw.githubusercontent.com/lengjun666/Img/master/imgimage-20201022104348168.png)

