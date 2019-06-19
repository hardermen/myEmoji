# 发表情后台

## 注意(非常重要)
由于避免隐私泄露，因此将application.yml重命名为了application.example.yml，因此运行时需要将此文件重新改为application.yml,并修改一下信息
```yaml
spring:
  datasource:
    url: 你的数据库url
    username: 你的数据库用户名
    password: 你的数据库密码
```

## 环境与框架
         * Jdk8
         * Mysql5.7
         * Redis
         * Maven
         * Springboot
         
         ## 打包及运行
         
         1. 打包
         `mvn clean package`
         2. 运行
         `java -jar xxxx.jar`或者后台运行`nohup java -jar xxx.jar &`
         
         ## TODOList
         1. Redis与MySQL的数据一致性
         2. "我的"模块
         3. "制图"模块
         4. "标签"模块