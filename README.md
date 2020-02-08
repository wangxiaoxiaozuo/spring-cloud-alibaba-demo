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

---
于 2020年1月12日
---
完成动态菜单，动态路由，用户授权权限，权限绑定菜单等，以及SpringSecurity使用 
页面进一步优化以及美化

---
于 2020年1月14日
---
后台管理系统拆分为多个子系统共存的形式，页面通过网关路由到对应的微服务
后台管理要改为 JWT token 的形式颁发token 
新增产品管理微服务 

---
于 2020年1月15日
---
1. 使用docker-compose 创建当前服务需要的容器编排 mall_docker_compose.yml 
2. 创建 mall-product-manager 商品服务管理
3. 启用 mall-gateway 路由，所有前端页面均通过路由网关




 




