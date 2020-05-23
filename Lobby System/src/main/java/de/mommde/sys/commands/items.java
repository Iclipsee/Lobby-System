package de.mommde.sys.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class items implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p instanceof Player) {
            if (p.hasPermission("lobby.join.items") || p.isOp()) {
                p.getInventory().clear();
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
        return false;
    }
}
