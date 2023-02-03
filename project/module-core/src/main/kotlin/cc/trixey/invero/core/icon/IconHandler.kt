package cc.trixey.invero.core.icon

import cc.trixey.invero.common.util.letCatching
import cc.trixey.invero.core.Context
import cc.trixey.invero.core.action.Action
import cc.trixey.invero.ui.common.event.ClickType
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import taboolib.common.platform.function.submitAsync

/**
 * Invero
 * cc.trixey.invero.core.icon.IconHandler
 *
 * @author Arasple
 * @since 2023/1/18 11:14
 */
@OptIn(ExperimentalSerializationApi::class)
@Serializable
class IconHandler(@JsonNames("def") val default: Action?, val typed: Map<ClickType, Action> = mapOf()) {

    fun run(context: Context, clickType: ClickType) = submitAsync {
        letCatching {
            typed[clickType]?.run(context)?.get()
            default?.run(context)?.get()
        }
    }

}