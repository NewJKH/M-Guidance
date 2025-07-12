package org.nano.guidance.infra

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.nano.guidance.util.player.PlayerUtil

class GuidanceCommand : CommandExecutor {
    /**
     * USER
     * - /길라잡이
     =
     * Command
     * - /길라잡이 확인 <닉네임> [ 자신 또는 상대방의 길라잡이 상태 확인 ]
     *
     * - /길라잡이 설정 <닉네임> <완료/실패> <단계>
     *
     * - /길라잡이 완료 <닉네임>    현재 단계 길라잡이 완료
     *
     *
     * TODO: 엔티티 설정
     */
    override fun onCommand(sender: CommandSender, command: Command, arg: String, args: Array<out String>?): Boolean {
        if( args == null || args.isEmpty() ){
            printCommand(sender)
            return true
        }

        when(args[0]){
            "확인","commit" ->{
                commit(sender,args)
            }
            "설정","set" ->{
                set(sender,args)
            }
            "완료","ok","succeed" ->{
                succeed(sender,args)
            }
            else -> {
                printCommand(sender)
            }
        }

        return true
    }
    private fun printCommand(sender: CommandSender) {
        if ( sender is Player ){

        }
    }

    private fun commit(sender: CommandSender, args:Array<out String>? ){
        PlayerUtil.findByPlayer(sender, args?.get(1) ?: "Null")

    }
    private fun set(sender: CommandSender, args:Array<out String>? ){
        PlayerUtil.findByPlayer(sender, args?.get(1) ?: "Null")

    }
    private fun succeed(sender: CommandSender, args:Array<out String>? ){
        PlayerUtil.findByPlayer(sender, args?.get(1) ?: "Null")

    }
}