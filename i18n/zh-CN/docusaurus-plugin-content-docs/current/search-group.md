---
sidebar_position: 5
---

# 搜索组

搜索组允许你使用 [Ognl](https://commons.apache.org/dormant/commons-ognl/language-guide.html) 脚本来选中想要的 JVM。

例如你可以使用下面的脚本来搜索所有命令行参数中有 `com.intellij.idea.Main` 的 JVM:

```ognl
#resultStr = hostMachine.execute('jps', '-lvm').ok(),
#result = #resultStr.split('\n').{? #this.contains('com.intellij.idea.Main')},
addAll(#result.{ #this.split(' ') })
```

## 使用内置函数

[Ognl](https://commons.apache.org/dormant/commons-ognl/language-guide.html) 太复杂了！所以我们提供了一些内置函数来帮助你编写脚本，例如上面的脚本可以简化为:

```ognl
addAll(helpers.local().findByCommandLineArgs('com.intellij.idea.Main', 'IDEA'))
```

这个脚本将会获取所有命令行参数中有 `com.intellij.idea.Main` 的 jvm 并将其名称设置为 `IDEA`。

## 创建一个搜索组

TODO

## 下一步

- Ognl Context
- Helper functions