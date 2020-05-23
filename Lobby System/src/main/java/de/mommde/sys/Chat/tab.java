package de.mommde.sys.Chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class tab implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(PermissionsEx.getUser(p).inGroup("default")) {
            p.setAllowFlight(false);
            p.setPlayerListName(ChatColor.GRAY + "GAST §8 ˟ §5 " + p.getName());
        }
        if(PermissionsEx.getUser(p).inGroup("trusted")) {
            p.setAllowFlight(true);
            p.setPlayerListName(ChatColor.BLUE + "TRUSTED §8 ˟ §b§l " + p.getName());
        }
        if(PermissionsEx.getUser(p).inGroup("owner")) {
            e.setJoinMessage(ChatColor.DARK_RED + p.getName() + ChatColor.GRAY + " hat den Server " + ChatColor.GREEN + "betreten");
            p.setAllowFlight(true);
            p.setPlayerListName(ChatColor.RED + "OWNER §8 ˟ §4§l " + p.getName());
        }
    }
}
