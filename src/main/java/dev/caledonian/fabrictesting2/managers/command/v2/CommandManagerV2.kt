package dev.caledonian.fabrictesting2.managers.command.v2

import dev.caledonian.fabrictesting2.commands.Testing
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.server.command.CommandManager


class CommandManagerV2 {

    private val commands: MutableMap<String, ICommandV2> = mutableMapOf()

    init {

    }

    private fun initCommands() {
        commands["testing"] = Testing()
    }

//    private fun registerCommands() {
//        // Iterate through all command elements
//        for ((key, value) in commands) {
//            // Define & register command with the Fabric API
//            CommandRegistrationCallback.EVENT.register { cmdDispatcher, _, _ ->
//                cmdDispatcher.register(CommandManager.literal(key).executes { context ->
//                    value.execute(context)
//                })
//            }
//        }
//    }

    private fun registerCommands() {
        // Iterate through all command elements
        for ((key, value) in commands) {
            // register main commands & all subcommands
            
        }
    }

    // addSubCommand

}