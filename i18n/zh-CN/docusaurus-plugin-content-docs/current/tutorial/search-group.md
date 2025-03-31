---
sidebar_position: 1
---

# 搜索组

每次都要从一大堆 JVM 中找到你想要的 JVM 是一件很痛苦的事情。所以我们提供了搜索组来帮助你。

搜索组允许你使用 [Ognl](https://commons.apache.org/dormant/commons-ognl/language-guide.html) 脚本来选中想要的 JVM。

例如你可以使用下面的脚本来搜索所有命令行参数中有 `com.intellij.idea.Main` 的 JVM:

```ognl
#resultStr = hostMachine.execute('jps', '-lvm').ok(),
#result = #resultStr.split('\n').{? #this.contains('com.intellij.idea.Main')},
addLocal(#result.{ #this.split(' ') })
```

## 创建一个搜索组

右键任意宿主机或者其子节点，选择 `Create Custom Search Group`:

![create-search-group](/img/search-group/create-group.png)

进入后，你可以编辑搜索组的名称和脚本:

![edit-script](/img/search-group/edit-script.png)

点击 `Test Script` 来测试脚本并查看结果，在确认无误后，点击 `OK` 来保存搜索组。

保存后，工具栏将会多出我们创建的搜索组，双击即可刷新搜索组:

![idea-main](/img/search-group/idea-main.png)

## 使用内置函数

[Ognl](https://commons.apache.org/dormant/commons-ognl/language-guide.html) 太复杂了！有没有更简单的方法? 

---

有的！我们提供了一些内置函数来帮助你编写脚本，例如上面的脚本可以简化为:

```ognl
addAll(helpers.local().findByCommandLineArgs('com.intellij.idea.Main', 'IDEA'))
```

这个脚本将会获取所有命令行参数中有 `com.intellij.idea.Main` 的 jvm 并将其名称设置为 `IDEA`。

关于 Ognl 所有可用的上下文，可以参考[这里](https://arthas-ui-api.pages.dev/-arthas%20-u-i/io.github.vudsen.arthasui.script/-my-ognl-context/)。

## 下一步

[查阅 API 文档](https://arthas-ui-api.pages.dev/)
