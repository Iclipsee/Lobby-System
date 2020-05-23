package de.mommde.sys.inventory.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class JoinListener implements Listener {

    boolean show = true;


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p instanceof Player) {
            if (p.hasPermission("lobby.join.items") || p.isOp()) {
                ItemStack kompass = new ItemStack(Material.SLIME_BALL);
                ItemMeta kompassmeta = kompass.getItemMeta();
                kompassmeta.setDisplayName(ChatColor.YELLOW + "SERVER SELECTOR");
                kompass.setItemMeta(kompassmeta);

                ItemStack playershow = new ItemStack(Material.LIME_DYE);
                ItemMeta showmeta = playershow.getItemMeta();
                showmeta.setDisplayName(ChatColor.GREEN + "SPIELER | ZEIGEN");
                playershow.setItemMeta(showmeta);

                p.getInventory().setItem(4, kompass);

                p.getInventory().setItem(8, playershow);
            }
        }
    }
}


