package dev.caledonian.fabrictesting2.commands

import com.mojang.brigadier.context.CommandContext
import dev.caledonian.fabrictesting2.managers.command.ICommand
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text
import net.minecraft.text.TextColor
import net.minecraft.util.Formatting

class ManagerCmd: ICommand {

    override fun execute(context: CommandContext<ServerCommandSource>): Int {
        // do shit
        context.source.player!!.sendMessage(Text.of("&ayo it worksssssssssssssssssss"))

        return SUCCESS()
    }
}