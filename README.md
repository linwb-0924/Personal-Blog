
# 项目解析
## 项目知识详解：

- 整体项目基于springboot框架开发
- 数据库采用了mysql 以及 JPA 实现对数据库的链接
- 前端采用thymeleaf模板引擎+semantic框架开发
- 集成了markdown编辑器，markdown内容转化器，中文排版，
- 
## 项目启动运行
- 在application-dev.yaml配置文件中修改相关数据库信息（mysql）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604154249436.png)

> 使用自己的url，username，password，数据库只需建立一个相对应的库名即可，不用使用其他操作。即可运行。



## 项目框架：
### 前端
static ：为js，css，images以及一些集成工具的样式
templates：分别为后台管理html，错误html，前台显示html
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604160434823.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
### 后端
依次是javabean，配置类，contrler层，dao层，实体类，异常定义，异常处理，拦截类，service层，工具类
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604160124781.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)




## 前端展示

- 首页：包括导航条，搜索框（支持模糊搜索），分页查询的显示，分类框，标签框，对当前页博客的总览，及微信二维码，及底部的一个信息框
![在这里插入图片描述](https://img-blog.csdnimg.cn/202006041538191.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604154611741.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
- 分类页：分页查询的展示，显示相应分类的博客（点击相应分类）
![-](https://img-blog.csdnimg.cn/20200604154716255.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
 - 标签页：分页查询的展示，显示相应标签的博客（点击相应标签）
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604154917100.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
 - 归档页及关于我页面
 归档页暂未处理，关于我页面可根据自己情况进行修改设计



## 后台管理

- 登录页：实现登录验证，登录拦截，具体账号密码根据自身在第一次运行项目后数据库中的user表中加入你相应的信息。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604155249445.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
- 登录首页：可对登录账号的显示和注销

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604155415978.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)


- 博客管理页：实现对标题，分类，是否推荐的一个搜索查询，分页查询的显示，新增博客和删除博客的功能
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604155541211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
- 分类管理页：分页查询的显示，新增分类和删除，编译分类的功能
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604155657836.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)
- 分类管理页：分页查询的显示，新增标签和删除，编译标签的功能
-![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604155809452.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTExNTkyOA==,size_16,color_FFFFFF,t_70)

## 总结
该个人博客系统相对来说对于springboot初学者来说较容易上手，后续可能会逐渐新增一些功能，例如评论等一些功能。

