# 基于微服务的仿下厨房系统后端

---
[![前端开发](https://img.shields.io/badge/%E9%93%BE%E6%8E%A5-%E5%89%8D%E7%AB%AF%E9%A1%B9%E7%9B%AE-ff69b4)](https://gitee.com/zhang-wenhaoyue/xiachufang)
---
[![Nacos](https://img.shields.io/badge/alibaba-Nacos-critical)](https://github.com/alibaba/nacos)
[![Sentinel](https://img.shields.io/badge/alibaba-Sentinel-blue)](https://github.com/alibaba/Sentinel/)
![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg "license")
![build](https://img.shields.io/badge/build-maven-orange "maven")
---
![schedule](https://img.shields.io/badge/schedule-unfinished-ff0000 "schedule")
![developer](https://img.shields.io/badge/developer-cyan-blueviolet "developer")
---

## 介绍

本系统下辖5个服务，其中一个网关，一个后台管理系统，三个后端服务。
<br>
其中网关动态路由配置文件由nacos管理，其配置文件为**gateway.config.json**
<br>
profiles包括dev和pro，dev为开发环境，pro为生产环境

## 运行环境

 - MySQL主从数据库-5.7
 - Redis或者Redis集群
 - Nacos-2.0.3
 - Sentinel-1.8.1
 - java-1.8
 - maven-3.6

## 关键技术

 - 基于切面编程和注解管理MySQL主从数据库，实现读写分离
 - Nacos服务注册，服务发现，配置管理
 - Sentinel粗粒度控制服务流量
 - JWT token解析，登录管理
 - 响应信息格式统一，方便前后端分离开发
 - 无侵入式接口文档插件smart-doc
 - tkMybatis持久层框架
 

## 部署描述

 - docker-compose管理服务
 - Dockerfile转jar为镜像

## 项目关键信息泄露处理

 - 公网IP已修改为随机值 172.221.234.190
 - 数据库端口修改为非原值
 - 华为云对象存储“Secret Access Key”等敏感信息已修改为随机值

## 项目不足之处

 - 未增加分布式事务
 - 未实现消息通知
 - 功能未完善
 - 数据库未优化索引
 - 未实现缓存

---

## 后续有时间会更新项目，试验自己感兴趣的一些技术