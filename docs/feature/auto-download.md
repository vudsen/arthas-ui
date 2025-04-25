---
sidebar_position: 2
---

# Automatic Download

Our plugin supports automatic download of toolchains. 
And by default downloads `Arthas` and `Jattach` from GitHub and places them in the `Data Directory` specified in the configuration.

In some cases, the automatic downloads will not work due to poor host network conditions or network restrictions, so here are some alternatives.


## Local Upload

Plugin supports uploading local packages to the remote host machine, 
the toolchain will be downloaded on local and then upload them to the corresponding host machine.

To enable the local upload, you need to create a local host machine. After that you can enable local transfer by selecting it among other hosts:

![config the local source](/img/feature/trans-pkg.png)


## Manual Downloads

You can manually download and install the toolchain from GitHub to your host machine:

- [Arthas](https://github.com/alibaba/arthas/releases/latest)
- [Jattach](https://github.com/jattach/jattach/releases/latest)

After that, put the tarball directly into the configured `<Data Directory>`, and the plugin will automatically detect and use it.

### Unzip Manually

Even if you download the toolchain manually, the plugin still accesses the GitHub API to get the latest Release information, just on the client side (the side that uses the IDE).

If you don't have access to GitHub even on your own machine, you can manually extract the toolchain package to ` <Data Directory>/pkg/<Name>` for the full manual installation process.

- The `<Name>` options are `arthas` or `jattach`, you can extract the contents of the package directly into them.
