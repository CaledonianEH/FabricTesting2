package dev.caledonian.fabrictesting2.managers.command

import com.mojang.brigadier.CommandDispatcher
import dev.caledonian.fabrictesting2.commands.ManagerCmd
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource

class CommandManager {

    // Command HashMap
    private val commands = HashMap<String, ICommand>()

    init {
        initCommands()
    }

    private fun initCommands() {
        commands["manager"] = ManagerCmd()

        handleCommands()
    }


    private fun handleCommands() {
        for ((key, value) in commands) {
            CommandRegistrationCallback.EVENT.register { cmdDispatcher, _, _ ->
                cmdDispatcher.register(CommandManager.literal(key).executes { context ->
                    value.execute(context)
                })
            }
        }
    }

}