package de.mommde.sys.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Tablist implements Listener {

    @EventHandler
    public  void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();


        String Message = e.getMessage();

        if(PermissionsEx.getUser(p).inGroup("default")) {
            p.setDisplayName(ChatColor.GRAY + p.getName());
        }
        if(PermissionsEx.getUser(p).inGroup("trusted")) {
            p.setDisplayName(ChatColor.BLUE + p.getName());
        }
        if(PermissionsEx.getUser(p).inGroup("owner") || p.isOp()) {
            p.setDisplayName(ChatColor.RED + p.getName());
            }
        }

    }

