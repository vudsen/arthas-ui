---
sidebar_position: 2
---

# Offline Installation Toolchain

The plugin supports automatic download of the toolchain, which is then placed in the `Data Directory` specified in the configuration. The default download source is:
- `Arthas` and `Jattach`: GitHub Releases
- `Kubectl`: Google CDN

In some cases, automatic downloads may not be available due to poor host machine network conditions or inability to access the internet. Alternative solutions are provided below.


## Local Upload

The plugin supports uploading local packages to the host machine. The toolchain will prioritize local downloads and then upload them to the corresponding host machine.

To use local upload, you need to create a local host machine. Then select it on other host machines to enable local transmission:

![config the local source](/img/feature/trans-pkg.png)

## Tools required for manual download

Even with the local upload feature, downloads may still fail locally in some cases, but the upload feature remains available.
Therefore, you can prepare the required packages locally in advance and upload them directly.

The tools used are:

- [arthas](https://github.com/alibaba/arthas/releases): `arthas-bin.zip`
- [jattach](https://github.com/jattach/jattach/releases): `jattach-{arch}.tar.gz`
- [pzip](https://github.com/ybirader/pzip/releases): `punzip_Linux_{arch}.tar.gz`
- [kubectl](https://kubernetes.io/docs/tasks/tools/):
    - Windows: `kubectl.exe`
    - Linux: `kubectl-linux`
    - Linux (ARM): `kubectl-linux-arm`
    - macOS: `kubectl-darwin`

Regarding `kubectl`, you need to specify the version in the settings; otherwise, it will call the interface to query the latest version.

Then, simply place the compressed package in the configured `<Data Directory>/downloads` directory, and the plugin will automatically detect and use it.
