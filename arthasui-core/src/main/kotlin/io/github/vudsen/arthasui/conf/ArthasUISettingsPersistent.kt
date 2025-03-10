package io.github.vudsen.arthasui.conf

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import java.util.concurrent.CopyOnWriteArrayList

@State(
    name = "io.github.vudsen.arthasui.conf.ArthasUISettingsPersistent",
    storages = [ Storage("ArthasUISettings.xml") ]
)
@Service(Service.Level.PROJECT)
class ArthasUISettingsPersistent : PersistentStateComponent<ArthasUISettings> {

    private val listeners = CopyOnWriteArrayList<() -> Unit>()

    private var myState = ArthasUISettings()

    override fun getState(): ArthasUISettings {
        return myState
    }

    override fun loadState(state: ArthasUISettings) {
        this.myState = state
    }

    fun addUpdatedListener(listener: () -> Unit) {
        listeners.add(listener)
    }

    fun notifyStateUpdated() {
        listeners.forEach { it() }
    }

}