# spring-boot-blog
## 一个博客网站

* 未登录主页（首页）
* 登录后主页（我的文章）
* 登录页面
* 注册页面 ( 注册页面，get方法返回注册页面，填写信息后，post方法注册，注册成功后前端控制跳转到登录页面)
* 文章显示页面（redis缓存）
  
 ( blog类要添加可序列化关键字Serializable，然后再serviceimpl层实现接口的地方进行缓存，进行业务逻辑开发)
* 写文章发布页面(也是get和post方法完成这个成功，同用户注册)
* mongodb实现日志收集
