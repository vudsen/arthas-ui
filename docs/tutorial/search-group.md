---
sidebar_position: 1
---

# Search Groups

Finding the JVM you want from a large list of JVMs can be a pain every time. So we provide search groups to help you.

---

The search group allows you to use the [Ognl](https://commons.apache.org/dormant/commons-ognl/language-guide.html) script to select the JVM you want.

For example, you can use the following script to search for all JVMs that have `com.intellij.idea.Main` in their command line arguments.

```ognl
#resultStr = hostMachine.execute('jps', '-lvm').ok(),
#result = #resultStr.split('\n'). {? #this.contains('com.intellij.idea.Main')}, #result = #resultStr.split('\n'). {?
addLocal(#result.{ #this.split(' ') })
```

## Create a search group

Right-click on any host or its children and select `Create Custom Search Group`:

![create-search-group](/img/search-group/create-group.png)

Once inside, you can edit the search group name and script: !

![edit-script](/img/search-group/edit-script.png)

Click `Test Script` to test the script and see the result, after confirming that it is correct, click `OK` to save the search group.

After saving, the toolbar will show the search group we created, double click on it to refresh the search group:

![idea-main](/img/search-group/idea-main.png)

## Use the built-in functions

[Ognl](https://commons.apache.org/dormant/commons-ognl/language-guide.html) Too complicated! Is there a simpler way? 

---

There is! We provide some built-in functions to help you write scripts, for example the above script can be simplified to.

```ognl
addAll(helpers.local().findByCommandLineArgs('com.intellij.idea.Main', 'IDEA'))
```

This script will get all jvm's that have `com.intellij.idea.Main` in their command line arguments and set their name to `IDEA`.

For all available contexts for Ognl, see [here](https://arthas-ui-api.pages.dev/-arthas%20-u-i/io.github.vudsen.arthasui.script/-my-ognl-context/).

## Next.

[Check API documentation](https://arthas-ui-api.pages.dev/)