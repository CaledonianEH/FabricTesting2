package dev.caledonian.fabrictesting2

import com.mojang.brigadier.CommandDispatcher
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.fabricmc.fabric.api.event.player.UseBlockCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.command.TestCommand
import net.minecraft.text.Text
import net.minecraft.util.ActionResult


class FabricTesting2: ModInitializer {


    override fun onInitialize() {
        println("Hello Fabric world!")

        // First event testing
        UseBlockCallback.EVENT.register(UseBlockCallback { p, world, hand, hitResult ->
            p.sendMessage(Text.translatable("You just placed a block"), false)
            ActionResult.PASS
        })

        registerCommands()
        dev.caledonian.fabrictesting2.managers.command.CommandManager()
    }

    fun registerCommands() {
        // .then(CommandManager.literal("return").executes { context -> TestCommand().run(context) })

//        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher, _, _ ->
//            dispatcher.register(CommandManager.literal("home")
//                .then(CommandManager.literal("set").executes(TestCommand().register(dispatcher, true))))
//        })

        //CommandRegistrationCallback.EVENT.register(TestCommand::register)



        CommandRegistrationCallback.EVENT.register { commandDispatcher: CommandDispatcher<ServerCommandSource>, commandRegistryAccess: CommandRegistryAccess, registrationEnvironment: CommandManager.RegistrationEnvironment -> dev.caledonian.fabrictesting2.commands.TestCommand().register(commandDispatcher, true) }
    }
}