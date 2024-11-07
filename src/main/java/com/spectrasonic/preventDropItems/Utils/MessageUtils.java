package com.spectrasonic.preventDropItems.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MessageUtils {

    public static final String DIVIDER = "----------------------------------------";
    public static final String PREFIX = "&b[&ePreventDropItems&b]&r ";

    private MessageUtils() {
        // Private constructor to prevent instantiation
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(colorize(PREFIX + message));
    }

    public static void sendStartupMessage(JavaPlugin plugin) {
        String[] messages = {
                DIVIDER,
                PREFIX + "&f" + plugin.getDescription().getName() + "&a Plugin Enabled!",
                PREFIX + "&d" + "Version: &b" + plugin.getDescription().getVersion(),
                PREFIX + "&6" + "Developed by: &c" + plugin.getDescription().getAuthors(),
                DIVIDER
        };

        for (String message : messages) {
            Bukkit.getConsoleSender().sendMessage(colorize(message));
        }
    }

    public static void broadcastMessage(String message) {
        Bukkit.broadcastMessage(colorize(message));
    }

    public static void sendShutdownMessage(JavaPlugin plugin) {
        String[] messages = {
                DIVIDER,
                PREFIX + "&c" + plugin.getDescription().getName() + " plugin Disabled!",
                DIVIDER
        };

        for (String message : messages) {
            Bukkit.getConsoleSender().sendMessage(colorize(message));
        }
    }

    private static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}