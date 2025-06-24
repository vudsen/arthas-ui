---
sidebar_position: 2
---

# 离线安装工具链

插件支持自动下载工具链，然后将其放到配置里指定的 `Data Directory` 中，默认的下载地址是:
- `Arthas` 和 `Jattach`: Github Releases
- `Kubectl`: Google CDN

在某些情况下，由于宿主机网络情况较差或者无法访问外网导致自动下载无法使用，在这里将给出其它代替方案。


## 本地上传

插件支持将本地的包上传到宿主机中，工具链会优先在本地下载，之后上传到对应的宿主机中。

想要使用本地上传，你需要创建一个本地的宿主机。之后在其它的宿主机中选中它，就可以开启本地传输了:

![config the local source](/img/feature/trans-pkg.png)

:::note

对于国内用户，如果你不使用梯子，基本不可能下载成功...

:::

## 手动下载需要的工具

即使拥有本地上传功能，部分情况下在本地可能仍然无法下载，但是上传功能是可用的。因此你可以在本地提前准备好需要的包，然后直接上传。

使用到的工具有:

- [arthas](https://github.com/alibaba/arthas/releases): `arthas-bin.zip`
- [jattach](https://github.com/jattach/jattach/releases): `jattach-{arch}.tar.gz`
- [pzip](https://github.com/ybirader/pzip/releases): `punzip_Linux_{arch}.tar.gz`
- [kubectl](https://kubernetes.io/docs/tasks/tools/): 
  - windows: `kubectl.exe`
  - linux: `kubectl-linux`
  - linux(arm): `kubectl-linux-arm`
  - macos: `kubectl-darwin`

关于 `kubectl`，需要在设置中指定版本，否则会调用接口查询最新版本。

之后直接将压缩包放到配置的 `<Data Directory>/downloads` 中，插件会自动检测并使用。

