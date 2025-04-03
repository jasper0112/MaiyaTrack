# 🎮 PSN Game Tracker 

- Third-Party Game Information Management Platform

一个基于 PSN（PlayStation Network）账号的第三方游戏信息展示平台，支持用户登录后查看其游戏记录、奖杯统计、游玩时长等数据，致力于打造游戏成就的可视化中心。

## 📌 项目特点

- ✅ 支持 PSN OAuth 登录（非官方）
- 🏆 实时同步奖杯数据（白金、金、银、铜）
- 🎮 展示游戏游玩时长、完成度、奖杯进度
- 📊 用户主页和数据可视化界面
- ⏰ 后端定时任务同步 PSN 数据
- 🌐 支持后续扩展 Steam/Xbox/GamePass 等平台

---

## 🛠️ 技术栈

| 层级   | 技术               |
|--------|--------------------|
| 前端   | React + Next.js + Mantine UI |
| 后端   | Node.js + Express / Spring Boot |
| 鉴权   | Sony OAuth 模拟登录（psn-api） |
| 数据库 | MongoDB / PostgreSQL |
| 部署   | Vercel（前端）+ Render（后端）+ Mongo Atlas（DB） |



