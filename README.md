# Tian-API 项目

这是一个用于对接 [天行数据 (TianAPI)](https://www.tianapi.com/) 的 Java 项目。天行数据是一个提供各类 API 接口的数据服务平台，涵盖了新闻资讯、生活服务、趣味娱乐、功能应用、知识问答、数据智能和企业商务等多个领域的接口。

## 项目简介

本项目基于 Spring Boot 构建，旨在简化对天行数据 API 的调用和集成。通过该项目，开发者可以更方便地在自己的应用中使用天行数据提供的各种服务，例如：

- 新闻资讯类接口
- 生活服务类接口（天气预报、垃圾分类等）
- 趣味娱乐类接口（藏头诗、脑筋急转弯等）
- 功能应用类接口（图像识别、二维码等）
- 知识问答类接口
- 数据智能类接口
- 企业商务类接口

## 技术栈

- Java 17
- Spring Boot 3.3.4
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database (开发环境)
- Apache HttpClient 5
- Jackson (JSON处理)
- Maven

## 项目架构

本项目采用现代化的分层架构设计：

```
src/main/java/
├── org.example.ryan.tianapi
│   ├── TianApiApplication.java          # 启动类
│   ├── config/                          # 配置类
│   ├── controller/                      # 控制器层 (REST API)
│   ├── service/                         # 服务层
│   ├── repository/                      # 数据访问层
│   ├── dto/                             # 数据传输对象
│   ├── model/                           # 实体模型
│   ├── exception/                       # 异常处理
│   └── util/                            # 工具类
```

## API 接口

### 基础接口 (v1)
- `GET /api/health` - 健康检查
- `GET /api/news` - 获取热点新闻
- `GET /api/weather` - 获取天气信息

### 增强接口 (v2)
- `GET /api/v2/health` - 健康检查
- `GET /api/v2/news` - 获取热点新闻 (结构化响应)

## 使用说明

1. 获取天行数据 API Key:
   - 访问 [天行数据官网](https://www.tianapi.com/) 注册账号
   - 在个人中心获取 API Key

2. 配置 API Key:
   - 编辑 `src/main/resources/application.properties` 文件
   - 修改 `tian.api.key=your_api_key_here` 为你的实际 API Key

3. 构建项目:
   ```bash
   ./mvnw clean compile
   ```

4. 运行项目:
   ```bash
   ./mvnw spring-boot:run
   ```

5. 访问 API:
   - 健康检查: http://localhost:8080/api/health
   - 获取新闻: http://localhost:8080/api/news?num=5
   - 获取天气: http://localhost:8080/api/weather?city=北京

## 数据库配置

本项目使用 H2 内存数据库进行开发，可通过以下地址访问 H2 控制台：
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- 用户名: sa
- 密码: (留空)

## 配置信息

项目配置位于 `src/main/resources/application.properties` 文件中，包括：

- 服务器端口配置
- 数据库连接配置
- 天行API密钥配置
- 日志配置等