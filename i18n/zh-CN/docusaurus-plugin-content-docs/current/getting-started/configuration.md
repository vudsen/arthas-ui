---
sidebar_position: 2
---

# 配置

## 添加宿主机

在安装完成后，你需要创建一个宿主机:

- 打开 `Settings` -> `Tools` -> `Arthas UI`，点击 `Host Machines` 列表的 `+` 号来创建一个宿主机:

![create-hostmachine](/img/intro/create-hostmachine.png)

点击后会弹出另外一个配置对话框:

![hostmachine-config](/img/intro/hostmachine-config.png)

- `Connect Config`: 决定你如何连接到对应的宿主机。
- `Provider Config`: 决定你在宿主机的哪些地方搜索 JVM。

这两个配置们是 `1:n` 的关系，也就是一个 `Connect Config` 可以对应多个 `Provider Config`:


![hostmachine-relation](/img/intro/hostmachine-relation.png)


:::tip

理论上可以使用任意版本的 Arthas 和 Jdk，只需要保证它们之间是兼容的即可！

:::