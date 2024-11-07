package com.spectrasonic.preventDropItems.Commands;

import com.spectrasonic.preventDropItems.Main;
import com.spectrasonic.preventDropItems.Utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class PreventDropCommand implements CommandExecutor, TabCompleter {

    private final Main plugin;

    public PreventDropCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            MessageUtils.sendMessage(sender, "&cThis command can only be used by players.");
            return true;
        }

        if (args.length != 1) {
            return false;
        }

        if (args[0].equalsIgnoreCase("true")) {
            plugin.setPreventDrop(true);
            MessageUtils.sendMessage(sender, "&aItem drop prevention enabled");
        } else if (args[0].equalsIgnoreCase("false")) {
            plugin.setPreventDrop(false);
            MessageUtils.sendMessage(sender, "&cItem drop prevention disabled");
        } else {
            return false;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            completions.add("true");
            completions.add("false");
            return completions;
        }
        return null;
    }
}
