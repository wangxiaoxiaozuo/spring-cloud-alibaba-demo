# Java技术栈学习

## SpringAlibaba 基础学习

+ **Nacos 服务注册与发现**
+ **Nacos 分布式配置**
+ **openFeign 服务调用**
+ **Sentianl 服务熔断**
+ **SkyWalking 链路追踪**
+ **SpringCloudGateWay 服务网关**

## SpringBoot 如何自定义Starter 
 <kbd>Tips: common-log-starter 为自定义starter</kbd>
 切面日志
 
## 爬虫框架webMagic学习

## 整合ElasticSearch

## spring cloud gateway 聚合swagger

## 重构目录结构，偏向商城结构发展
```html
── mall
   ├── common-log-starter      自定义starter 日志切面
   ├── mall-admin              商城管理后台
   ├── mall-code-generator     mybatis-plus 代码生成器
   ├── mall-data-collect       集成webMagic爬虫技术做数据采集使用
   ├── mall-gateway            路由网关
   ├── mall-pay-center         支付中心
   ├── mall-search             集成ElasticSearch搜索功能
   ├── mall-user-center        用户认证中心
   ├── provider                后续~~~~
   └── skywalking-agent        skyWalking 探针
```

开发日志记录 

---
于 2019年12月26日
---
**商城后台管理系统**

1. 整合Mybatis-plus 分页，打印SQL，逻辑删除等
2. 基于RestControllerAdvice 实现的验证已经提取到公共组件包下，但自定义验证注解以及逻辑并未添加
3. 没有涉及Swagger 各个模块均需要，需提到公共组件包中
4. 后台用户增删改查已经实现，暂时没有用户登录

**TODO**
1. 权限管理模块增删改查
2. 用户绑定权限
3. 基于SpringSecurity 实现用户权限管理
4. 基于SpringSocial实现第三方登录（微信 QQ）


---
于 2020年1月03日
---
完成用户管理，角色管理，菜单管理，用户授权角色，角色授权菜单，包含前后端联调


 




