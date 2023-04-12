package dev.caledonian.fabrictesting2.managers.command

import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.exceptions.CommandSyntaxException
import net.minecraft.server.command.ServerCommandSource

interface ICommand {

    @Throws(CommandSyntaxException::class)
    fun execute(context: CommandContext<ServerCommandSource>): Int

    fun SUCCESS(): Int {
        return 1
    }

    fun FAILURE(): Int {
        return -1
    }
}
