package de.mommde.sys.inventory.functions;

import de.mommde.sys.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class SERVERSELECTOR implements Listener {



    public final String SELECTOR = ChatColor.YELLOW + "        SERVER SELECTOR";

    public void gui(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9 * 3, SELECTOR);
        inv.setItem(0, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(1, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(2, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(3, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(4, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(5, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(6, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(7, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(8, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(9, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(10, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

        ItemStack build = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta buildmeta = build.getItemMeta();
        buildmeta.setDisplayName("§a§lBUILD-SERVER");
        build.setItemMeta(buildmeta);
        inv.setItem(11, build);

        inv.setItem(12, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(13, new ItemStack(Material.BARRIER));
        inv.setItem(14, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

        ItemStack plugin = new ItemStack(Material.REDSTONE);
        ItemMeta pluginmeta = plugin.getItemMeta();
        pluginmeta.setDisplayName("§c§lPLUGIN-TEST-SERVER");
        plugin.setItemMeta(pluginmeta);
        inv.setItem(15, plugin);

        inv.setItem(16, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(17, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(18, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(19, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(20, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(21, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(22, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(23, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(24, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(25, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inv.setItem(26, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        p.openInventory(inv);
    }


    @EventHandler
    public void guiOpen(PlayerInteractEvent e) {
        if (e.getItem() != null) {
            if(e.getClickedBlock() != null) {
            if (e.getItem().getType() != Material.SLIME_BALL) return;
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                gui(e.getPlayer());
            }
            }
        }
    }


    @EventHandler
    public void guiFunction(InventoryClickEvent e) {
        if(!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equals(SELECTOR)) {
            e.setCancelled(true);
            switch (Objects.requireNonNull(e.getCurrentItem()).getType()) {
                case REDSTONE:
                    p.sendMessage(ChatColor.GREEN + "Du " + ChatColor.GRAY + "wirst mit dem " + ChatColor.YELLOW + "PLUGINTEST" + ChatColor.GRAY + " server verbunden. . .");
                    ByteArrayOutputStream pl = new ByteArrayOutputStream();
                    DataOutputStream outplugin = new DataOutputStream(pl);


                    try {
                        outplugin.writeUTF("Connect");
                        outplugin.writeUTF("plugintest");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }


                    p.sendPluginMessage(main.plugin, "BungeeCord", pl.toByteArray());
                    break;
                case IRON_PICKAXE:
                    p.sendMessage(ChatColor.GREEN + "Du " + ChatColor.GRAY + "wirst mit dem " + ChatColor.YELLOW + "BUILDING" + ChatColor.GRAY + " server verbunden. . .");
                    ByteArrayOutputStream b = new ByteArrayOutputStream();
                    DataOutputStream outbuilding = new DataOutputStream(b);


                    try {
                        outbuilding.writeUTF("Connect");
                        outbuilding.writeUTF("building");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }


                    p.sendPluginMessage(main.plugin, "BungeeCord", b.toByteArray());

                    break;
                case BARRIER:
                    p.closeInventory();
                    break;
                default:
                    break;
            }
        }
    }

}
