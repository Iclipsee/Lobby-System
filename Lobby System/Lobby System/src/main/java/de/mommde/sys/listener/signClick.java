package de.mommde.sys.listener;

import de.mommde.sys.main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class signClick implements Listener {




    @EventHandler
    public void signchangeevent(SignChangeEvent e) {
        if(e.getLine(0) != null && e.getLine(0) != "") {
            if(e.getLine(0).equalsIgnoreCase("[SERVER]")) {
                e.setLine(0, "§9Connect");
            }
        }
        if(e.getLine(1) != null && e.getLine(1) != "") {
            if(e.getLine(1).equalsIgnoreCase("lobby")) {
                e.setLine(1, "§b§lLOBBY");
            }
        }
        if(e.getLine(1) != null && e.getLine(1) != "") {
            if(e.getLine(1).startsWith("plugin")) {
                e.setLine(1, "§a§lPLUGINTEST");
            }
        }
        if(e.getLine(1) != null && e.getLine(1) != "") {
            if(e.getLine(1).startsWith("build")) {
                e.setLine(1, "§f§lBUILDING");
            }
        }
    }




    @EventHandler
    public void inInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block build = e.getClickedBlock();
        if (build != null) {
            if (build.getType().name().contains("SIGN")) {
                org.bukkit.block.Sign sign = (org.bukkit.block.Sign) build.getState();

                if (sign.getLine(1) != null && sign.getLine(1) != "") {
                    if (ChatColor.stripColor(sign.getLine(1)).equalsIgnoreCase("BUILDING")) {
                        p.sendMessage(ChatColor.GREEN + "Du " + ChatColor.GRAY + "wirst mit dem " + ChatColor.YELLOW + "BUILDING" + ChatColor.GRAY + " server verbunden. . .");
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);

                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("building");
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        System.out.println("building");

                        p.sendPluginMessage(main.plugin, "BungeeCord", b.toByteArray());

                    }


                }

                if (sign.getLine(1) != null && sign.getLine(1) != "") {
                    if (ChatColor.stripColor(sign.getLine(1)).equalsIgnoreCase("PLUGINTEST")) {

                        p.sendMessage(ChatColor.GREEN + "Du " + ChatColor.GRAY + "wirst mit dem " + ChatColor.YELLOW + "PLUGINTEST" + ChatColor.GRAY + " server verbunden. . .");
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);


                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("plugintest");
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        System.out.println("plugintest");

                        p.sendPluginMessage(main.plugin, "BungeeCord", b.toByteArray());

                    }
                }
                if (sign.getLine(1) != null && sign.getLine(1) != "") {
                    if (ChatColor.stripColor(sign.getLine(1)).equalsIgnoreCase("LOBBY")) {
                        p.sendMessage(ChatColor.GREEN + "Du " + ChatColor.GRAY + "wirst mit dem " + ChatColor.YELLOW + "LOBBY" + ChatColor.GRAY + " server verbunden. . .");
                        ByteArrayOutputStream b = new ByteArrayOutputStream();

                        DataOutputStream out = new DataOutputStream(b);


                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("lobby");
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }


                        p.sendPluginMessage(main.plugin, "BungeeCord", b.toByteArray());
                        System.out.println("lobby");

                    }
                }

            }
        }

    }
}
                        /*
                    //TODO 4. SIGN SYSTEM
                     */

