---
sidebar_position: 2
---

# 自动下载

插件支持自动下载工具链，默认会从 Github 中下载 `Arthas` 和 `Jattach`，然后将其放到配置里指定的 `Data Directory` 中。

在某些情况下，由于宿主机网络情况较差或者无法访问外网导致自动下载无法使用，在这里将给出其它代替方案。


## 本地上传

插件支持将本地的包上传到宿主机中，工具链会优先在本地下载，之后上传到对应的宿主机中。

想要使用本地上传，你需要创建一个本地的宿主机。之后在其它的宿主机中选中它，就可以开启本地传输了:

![config the local source](/img/feature/trans-pkg.png)


## 手动下载

你可以手动从 GitHub 中下载并安装工具链到宿主机中:

- [Arthas](https://github.com/alibaba/arthas/releases/latest)
- [Jattach](https://github.com/jattach/jattach/releases/latest)

之后直接将压缩包放到配置的 `<Data Directory>` 中，插件会自动检测并使用。

### 手动解压

即使你手动下载了工具链，插件也仍然会访问 Github API 来获取最新的 Release 信息，只不过是在客户端(使用 IDE 的这一侧)中进行的。

如果你在自己的本机也无法访问 Github，你可以手动解压缩工具链包到 `<Data Directory>/pkg/<Name>` 中，来进行全部的手动安装流程。

- 此处 `<Name>` 可选值有 `arthas` 和 `jattach`，直接将压缩包的内容解压到其中即可。
