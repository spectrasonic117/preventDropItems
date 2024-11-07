package com.spectrasonic.preventDropItems;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.spectrasonic.preventDropItems.Commands.PreventDropCommand;
import com.spectrasonic.preventDropItems.Events.PlayerDropEvent;
import com.spectrasonic.preventDropItems.Utils.MessageUtils;

import java.util.Objects;

public class Main extends JavaPlugin {

    private boolean preventDrop = true;

    @Override
    public void onEnable() {
        MessageUtils.sendStartupMessage(this);
        loadCommands();
        loadEvents();
    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }

    public boolean isPreventDrop() {
        return preventDrop;
    }

    public void setPreventDrop(boolean preventDrop) {
        this.preventDrop = preventDrop;
    }

    public void loadCommands(){
        Objects.requireNonNull(getCommand("pdi")).setExecutor(new PreventDropCommand(this));

    }

    public void loadEvents(){
        getServer().getPluginManager().registerEvents(new PlayerDropEvent(this), this);

    }
}
