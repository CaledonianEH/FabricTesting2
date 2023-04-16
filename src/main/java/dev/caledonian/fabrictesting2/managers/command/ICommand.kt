package dev.caledonian.fabrictesting2.managers.command

import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.exceptions.CommandSyntaxException
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.network.ServerPlayerEntity

interface ICommand {

    @Throws(CommandSyntaxException::class)
    fun execute(context: CommandContext<ServerCommandSource>): Int {
        noArgs(context)

        return 1
    }

    fun noArgs(context: CommandContext<ServerCommandSource>) {

    }
}
