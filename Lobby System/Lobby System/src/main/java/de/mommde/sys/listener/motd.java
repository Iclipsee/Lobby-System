package de.mommde.sys.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.Random;

public class motd implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        Random rnd = new Random();
        int random = rnd.nextInt(5);
        if(random == 0) {
            e.setMotd("§c§l LOBBY-SERVER");
        }
        if(random == 1) {
            e.setMotd("§a§l LOBBY-SERVER");
        }
        if(random == 2) {
            e.setMotd("§b§l LOBBY-SERVER");
        }
        if(random == 3) {
            e.setMotd("§2§l LOBBY-SERVER");
        }
        if(random == 4) {
            e.setMotd("§d§l LOBBY-SERVER");
        }
    }
}
