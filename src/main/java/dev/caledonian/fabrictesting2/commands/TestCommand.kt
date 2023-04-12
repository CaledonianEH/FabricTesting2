package dev.caledonian.fabrictesting2.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text

class TestCommand {
    fun register(dispatcher: CommandDispatcher<ServerCommandSource>, dedicated: Boolean) {
        dispatcher.register(
            CommandManager.literal("home")
                .then(CommandManager.literal("return").executes { context -> TestCommand().run(context) })
        )
    }

    private fun run(context: CommandContext<ServerCommandSource>): Int {
        val p = context.source.player!!

        p.sendMessage(Text.translatable("&aYo it worked boi"))

        return 1
    }
}