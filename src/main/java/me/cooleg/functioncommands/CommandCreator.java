package me.cooleg.functioncommands;

import me.cooleg.easycommands.Command;
import me.cooleg.easycommands.CommandRegistry;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import javax.annotation.Nonnull;

public class CommandCreator {

    private final CommandRegistry registry = new CommandRegistry();

    public void createCommand(String commandName, String functionName) {
        Command command = new Command() {
            @Override
            public boolean rootCommand(CommandSender commandSender, String s) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "function " + functionName);
                return true;
            }

            @Override
            public boolean noMatch(CommandSender commandSender, String s, String[] strings) {
                return rootCommand(commandSender, s);
            }

            @Nonnull
            @Override
            public String name() {
                return commandName;
            }

            @Override
            public String permission() {
                return "functionscommands.commands";
            }
        };

        registry.registerCommand(command);
    }

}
