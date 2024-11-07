package com.spectrasonic.preventDropItems.Events;

import com.spectrasonic.preventDropItems.Main;
import com.spectrasonic.preventDropItems.Utils.MessageUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.entity.Player;

public class PlayerDropEvent implements Listener {

    private final Main plugin;

    public PlayerDropEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (plugin.isPreventDrop() && !player.hasPermission("preventitemdrop.drop.bypass")) {
            event.setCancelled(true);
            MessageUtils.sendMessage(player, "&cDropping items is currently disabled.");
        }
    }
}
