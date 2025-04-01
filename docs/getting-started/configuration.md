---
sidebar_position: 2
---

## Configure

## Adding a host

After the installation is complete, you will need to create a host: `Settings` -> `Tools` -> `Arthas UI`.

- Open `Settings` -> `Tools` -> `Arthas UI` and click on the `+` sign in the `Host Machines` list to create a host:

![create-hostmachine](/img/intro/create-hostmachine.png)

Clicking on this will bring up another configuration dialog:

![hostmachine-config](/img/intro/hostmachine-config.png)

- `Connect Config`: determines how you connect to the corresponding host.
- `Provider Config`: determines where on the host you search for the JVM.

These two configs have a `1:n` relationship, i.e. one `Connect Config` can correspond to multiple `Provider Config`:!


![hostmachine-relation](/img/intro/hostmachine-relation.png)


:::tip

You can theoretically use any version of Arthas and Jdk, just make sure they are compatible!

:::
