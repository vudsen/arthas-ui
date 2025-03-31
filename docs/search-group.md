---
sidebar_position: 5
---

# About Search Group

The Search Group allow you to customize the jvm search script by [OGNL](https://commons.apache.org/dormant/commons-ognl/language-guide.html)

For example, you can use the following script to search the jvm by the command line args:

```ognl
#resultStr = hostMachine.execute(localHelper.jps(), '-lm').ok(),
#result = #resultStr.split('\n').{? #this.contains('com.intellij.idea.Main')},
addLocal(#result.{ #this.split(' ') })
```

This script will find all JVMs whose command line args contain `com.intellij.idea.Main` and add them to the search result.

## Use helper functions

Ognl is too complex to use, so we provide some helper functions to help you write the script.

## Create A Search Group

TODO

## Next Steps

- Ognl Context
- Helper functions