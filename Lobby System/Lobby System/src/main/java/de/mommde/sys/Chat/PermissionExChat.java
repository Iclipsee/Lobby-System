package de.mommde.sys.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PermissionExChat implements Listener {

    @EventHandler
    public  void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();


        String Message = e.getMessage();
        Message.replace("%", "Prozent");

        if(PermissionsEx.getUser(p).inGroup("default")) {
            e.setFormat("§8[§7Gast§8] §5" + p.getName() + " §8 ˟ §7" + Message);
            p.setAllowFlight(false);
        }
        if(PermissionsEx.getUser(p).inGroup("trusted")) {
            e.setFormat("§8[§6Trusted§8] §b§l" + p.getName() + " §8 ˟ §l§b" + Message);
            p.setAllowFlight(true);
        }
        if(PermissionsEx.getUser(p).inGroup("owner") || p.isOp()) {
            p.setAllowFlight(true);
            e.setFormat("§8[§cOWNER§8] §c§l" + p.getName() + " §8 ˟ §4§l" + Message);
            for(Player player : Bukkit.getOnlinePlayers()){
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 2, 5);
            }
        }

    }
}
