package de.mommde.sys;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import static de.mommde.sys.inventory.functions.SERVERSELECTOR.*;
import static de.mommde.sys.listener.signClick.plugin;

public final class main extends JavaPlugin {

    public static Plugin plugin;


    @Override
    public void onEnable() {
        listenerRegistration();
        commandRegistration();
        System.out.println(ChatColor.YELLOW + "LOBBY SYSTEM");
        System.out.println(ChatColor.YELLOW + "-------------");
        
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        plugin = this;
    }

    @Override
    public void onDisable() {
    }


    public void listenerRegistration() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new de.mommde.sys.listener.JoinListener(), this);
        pm.registerEvents(new de.mommde.sys.inventory.items.JoinListener(), this);
        pm.registerEvents(new de.mommde.sys.inventory.functions.SERVERSELECTOR(), this);
        pm.registerEvents(new de.mommde.sys.Chat.PermissionExChat(), this);
        pm.registerEvents(new de.mommde.sys.listener.food(), this);
        pm.registerEvents(new de.mommde.sys.inventory.functions.dropanddelete(), this);
        pm.registerEvents(new de.mommde.sys.listener.signClick(), this);
        pm.registerEvents(new de.mommde.sys.inventory.functions.PlayerHider(), this);
        pm.registerEvents(new de.mommde.sys.listener.motd(),this);
        pm.registerEvents(new de.mommde.sys.listener.spawn(), this);
        pm.registerEvents(new de.mommde.sys.listener.block(), this);
        pm.registerEvents(new de.mommde.sys.Chat.tab(),this);
        pm.registerEvents(new de.mommde.sys.Chat.Tablist(), this);
    }
    public void commandRegistration() {
        getCommand("gm").setExecutor(new de.mommde.sys.commands.gamemode());
        getCommand("items").setExecutor(new de.mommde.sys.commands.items());
        getCommand("build").setExecutor(new de.mommde.sys.commands.Build());
    }
}

