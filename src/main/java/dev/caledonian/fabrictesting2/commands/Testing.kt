package dev.caledonian.fabrictesting2.commands

import com.mojang.brigadier.context.CommandContext
import dev.caledonian.fabrictesting2.managers.command.v2.ICommandV2
import net.minecraft.server.command.ServerCommandSource

class Testing: ICommandV2 {
    override fun execute(context: CommandContext<ServerCommandSource>): Int {
        val subCommandsMap = mutableMapOf<String, () -> Int>()

        addSubCommand("arg", subCommandsMap) {
            argumentStuff(context)
            addSubCommand("billy", subCommandsMap) {
                argumentStuff(context)
            }
        }

        return 1
    }

    fun argumentStuff(context: CommandContext<ServerCommandSource>): Int {
        return 1
    }
}