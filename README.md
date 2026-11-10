# 志愿者服务平台（volunteer-platform）

基于 Spring Boot 3 的社区志愿服务管理平台，后端 REST 接口 + 静态页面（Thymeleaf / HTML），
实现志愿者信息、志愿活动、报名记录、数据统计四个模块的增删改查。

## 技术栈

| 层 | 技术 |
|---|---|
| 语言 / 运行时 | Java 21 |
| 框架 | Spring Boot 3.2.5（Web + Thymeleaf） |
| 持久层 | MyBatis-Plus 3.5.5 + MySQL 8 |
| 工具 | Lombok |
| 前端 | 原生 HTML + CSS + JS（静态页放在 `resources/static`） |

## 功能模块

| 模块 | 说明 | 对应代码 |
|---|---|---|
| 志愿者管理 | 志愿者信息的新增、查询、修改、删除 | `VolunteerController` / `VolunteerService` |
| 活动管理 | 志愿活动的发布、编辑、下架、列表查询 | `ActivityController` / `ActivityService` |
| 报名管理 | 报名记录登记、状态更新、按活动/志愿者查询 | `RegistrationController` / `RegistrationService` |
| 数据统计 | 活动数、报名数、参与人数等汇总数据 | `StatisticsController` |
| 用户管理 | 平台用户列表、启用/禁用、删除 | `UserController` / `UserService` |

页面：

```
index.html          入口跳转
login.html          登录
register.html       注册
home.html           首页
activity.html       活动列表（前台）
activityManage.html 活动管理（后台）
userManage.html     用户管理（后台）
statistics.html     数据统计
```

## 项目结构

```
volunteer-platform/
├── pom.xml
└── src/main/
    ├── java/com/volunteer/volunteerplatform/
    │   ├── VolunteerPlatformApplication.java   启动类
    │   ├── controller/    5 个控制器（活动 / 报名 / 统计 / 用户 / 志愿者）
    │   ├── service/       4 组接口 + 实现（业务逻辑）
    │   ├── mapper/        4 个 MyBatis-Plus Mapper
    │   └── entity/        4 个实体（Activity / Registration / User / Volunteer）
    └── resources/
        ├── application.yml    数据源与 MyBatis-Plus 配置
        └── static/            8 个前端页面
```

## 如何运行

1. **建库**：本地 MySQL 建一个库（例如 `volunteer`），执行建表 SQL（表结构见 `entity/` 四个实体类）
2. **改配置**：`src/main/resources/application.yml` 里填你自己的数据库地址、用户名、密码
3. **启动**：

```bash
mvn spring-boot:run
```

4. 浏览器打开 `http://localhost:8080/login.html`

## 说明

- 个人学习项目，用于练习 Spring Boot 三层结构（Controller / Service / Mapper）与 MyBatis-Plus 的基本用法
- `demos/` 目录是 Spring Initializr 生成的示例代码，与业务无关，可以删除
- 项目中暂未接入 Spring Security，登录校验为简化实现
