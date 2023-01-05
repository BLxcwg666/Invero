package cc.trixey.invero.bukkit.api.dsl

import cc.trixey.invero.bukkit.panel.StandardPanel
import cc.trixey.invero.common.PanelContainer
import cc.trixey.invero.common.PanelWeight
import cc.trixey.invero.common.Pos
import cc.trixey.invero.common.Scale

/**
 * @author Arasple
 * @since 2022/12/22 20:28
 */
inline fun PanelContainer.standardPanel(
    scale: Pair<Int, Int>,
    locate: Pair<Int, Int> = firstAvailablePositionForPanel(),
    weight: PanelWeight = PanelWeight.NORMAL,
    block: StandardPanel.() -> Unit
) {
    this += StandardPanel(this, weight, Scale(scale), Pos(locate)).also(block)
}