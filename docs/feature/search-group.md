---
sidebar_position: 1
---

# Search Groups

Finding the JVM you want from a large list of JVMs can be a pain every time. So we provide search groups to help you.

---

The search group allows you to use the [Ognl](https://commons.apache.org/dormant/commons-ognl/language-guide.html) script to select the JVM you want.

For example, you can use the following script to search for all JVMs that have `com.intellij.idea.Main` in their command line arguments.

```ognl
#result = helpers.local().findByCommandLineArgs('com.intellij.idea.Main', 'IDEA Main'),
addAll(#result)
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

In addition to the functions mentioned at the beginning, we have many other built-in methods, check out the [API documentation](https://arthas-ui-api.pages.dev/).

You can start with [MyOgnlContext](https://arthas-ui-api.pages.dev/-arthas%20-u-i/io.github.vudsen.arthasui.script/-my-ognl-context/)
which is the entire OGNL context, and you can use the methods and fields in it directly.

[Here](https://arthas-ui-api.pages.dev/-arthas%20-u-i/io.github.vudsen.arthasui.script.helper/-local-jvm-search-helper/) you can see
all the methods available in `helper.local()`, e.g. you can use the `findByPort` method to search by port: 

```ognl
#result = helpers.local().findByPort(8080, 'My App'),
addAll(#result)
```

## Next.

[Check API documentation](https://arthas-ui-api.pages.dev/)