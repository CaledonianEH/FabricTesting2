package dev.caledonian.fabrictesting2.managers.command.v2

import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.exceptions.CommandSyntaxException
import net.minecraft.server.command.ServerCommandSource

interface ICommandV2 {

    @Throws(CommandSyntaxException::class)
    fun execute(context: CommandContext<ServerCommandSource>): Int

    // Add subcommand
    fun addSubCommand(arg: String, subCommandsMap: MutableMap<String, () -> Int>, subCommand: () -> Int): Int {
        subCommandsMap[arg] = subCommand
        return 1
    }
}