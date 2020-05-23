package de.mommde.sys.listener;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class spawn implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        int x = -18;
        int y =  27;
        int z = -173;
        p.teleport(new Location(p.getWorld(), x, y, z));

    }
}
