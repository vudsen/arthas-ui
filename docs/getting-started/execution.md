---
sidebar_position: 3
---

# Command Execution

## Find the JVM

Once the host has been added, click on the `Arhtas` icon on the right side of the toolbar to expand our core components:

![toolwindow](/img/intro/toolwindow.png)

**Double-click** on the `Local JVM` or **click on any node and then click on the Refresh button in the upper toolbar** to list all the current local JVMs.

Let's use the official Arthas `math-game.jar` as an example. In Arthas Home, run `math-game` with `java -jar math-game.jar`.
After that, click the Refresh button to refresh all the JVMs and then find `math-game.jar` (`6608 in the above image . \math-game.jar`), double click on it.

## Execute the command

After double-clicking, a file will open where you can directly type in Arthas's command:

![queryconsole](/img/intro/query_console.png)

A couple of things are worth noting.

- Every command needs to end in `;`.
- We provide syntax checking, so if there is a problem with a command, the IDE will give you an error.
- Even if the IDE gives you an error, you can still execute the command. We don't have any restrictions on the actual execution, even if the command is indeed wrong!

:::note

Why semicolon endings?

1. to make the separation between commands more obvious
2. it's simple to implement and doesn't require complex syntax parsing
3. to avoid ambiguity: for example, the `sm` command can optionally provide a method name, so for the command `sm MyClass echo -d`, what is it?
   Is it a `sm` command or a `sm` command plus a `echo` command?

:::

**Select the command you want to execute and click the green button Run button in the upper left corner to execute it**. After clicking on it, it will start to create a connection and Attach to the JVM to execute your command.

When you select a command and want to execute it, we will get the string you selected and then.

1. remove the spaces to the left and right of the command
2. replace all newlines with spaces
3. remove the semicolon at the end of the command (if any)
4. execute the command

**That means you can split a command into multiple lines and then execute it. **



After the command is run, a terminal will be opened, showing the result of the run:

![run](/img/intro/run.png)

### Executing Listener Commands

Listening commands, i.e. commands that do not exit immediately after execution, such as `watch`, `stack`, etc., which never exit voluntarily without specifying `-n`.

:::tip

You cannot execute the next command until the previous command has finished executing.

:::

To exit such commands, you need to manually stop them by clicking on the progress bar in the bottom-right corner :

![stop](/img/intro/stop.png)

### Exit

The Arthas process can be closed by clicking the stop button on the toolbar or in the terminal.
