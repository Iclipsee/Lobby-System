package de.mommde.sys.inventory.functions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PlayerHider implements Listener {

    boolean show = true;



    @EventHandler
    public void onClick(PlayerInteractEvent e) {


        ItemStack playerhide = new ItemStack(Material.GRAY_DYE);
        ItemMeta hidemeta = playerhide.getItemMeta();
        hidemeta.setDisplayName(ChatColor.RED + "SPIELER | VERSTECKEN");
        playerhide.setItemMeta(hidemeta);

        ItemStack playershow = new ItemStack(Material.LIME_DYE);
        ItemMeta showmeta = playershow.getItemMeta();
        showmeta.setDisplayName(ChatColor.GREEN + "SPIELER | ZEIGEN");
        playershow.setItemMeta(showmeta);
        if (e.getClickedBlock() != null || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (e.getItem() != null) {

                Player p = e.getPlayer();
                if (e.getItem().getItemMeta().getDisplayName().contains(ChatColor.RED + "SPIELER | VERSTECKEN")) {
                    p.getInventory().setItem(8, playershow);
                    p.sendMessage(ChatColor.GRAY + "Spieler werden nun " + ChatColor.GREEN + "GEZEIGT");
                    show = false;
                }

                if (e.getItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "SPIELER | ZEIGEN")) {
                    p.getInventory().setItem(8, playerhide);
                    p.sendMessage(ChatColor.GRAY + "Spieler werden nun " + ChatColor.RED + "VERSTECKT");
                    show = true;
                }

                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    if (show == true) {
                        p.hidePlayer(all);
                    }
                    if (show == false) {
                        p.showPlayer(all);
                    }
                }
            }
        }
    }

}


