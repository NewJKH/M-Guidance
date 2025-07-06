package org.nano.guidance.util.player

import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.nano.guidance.global.exception.player.PlayerNotFoundException

object PlayerUtil{
    fun findByPlayer(sender: CommandSender, playername: String): Player {
        return Bukkit.getOnlinePlayers().stream()
            .filter { it.name.equals(playername, ignoreCase = true) }
            .findFirst()
            .orElseThrow { PlayerNotFoundException(sender, " &c$playername &7닉네임을 가진 플레이어가 서버에 없습니다.") }
    }
}
