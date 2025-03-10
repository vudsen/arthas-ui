package io.github.vudsen.arthasui.core.ui

import com.intellij.openapi.project.Project
import io.github.vudsen.arthasui.api.HostMachine
import io.github.vudsen.arthasui.api.ui.RecursiveTreeNode
import io.github.vudsen.arthasui.bridge.JvmSearcher

class TreeNodeContext(
    val hostMachine: HostMachine,
    val root: RecursiveTreeNode,
    val project: Project,
    val searcher: JvmSearcher
)
