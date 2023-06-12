package me.cooleg.functioncommands;

import org.bukkit.plugin.java.JavaPlugin;

public final class FunctionCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        CommandCreator commands = new CommandCreator();

        for (String s : getConfig().getKeys(false)) {
            commands.createCommand(s, getConfig().getString(s));
        }

    }

}
