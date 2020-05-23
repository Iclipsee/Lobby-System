package de.mommde.sys.listener;

import de.mommde.sys.inventory.functions.PlayerHider;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setPlayerListHeader(ChatColor.BOLD + "PRIVATES " + ChatColor.YELLOW + "NETZWERK");
        //==========================
        //PlayerList
        //==========================
        p.setPlayerListFooter("");

        e.setJoinMessage(ChatColor.GREEN + p.getName() + ChatColor.GRAY + " hat den Server " + ChatColor.GREEN + "betreten");



        p.setGameMode(GameMode.ADVENTURE);

        p.getWorld().setGameRule(GameRule.DO_FIRE_TICK, false);
        p.getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE , false);
        p.getWorld().setGameRule(GameRule.DO_MOB_SPAWNING, false);
        p.getWorld().setGameRule(GameRule.DO_WEATHER_CYCLE, false);

        p.sendTitle(ChatColor.YELLOW + "WILLKOMMEN", ChatColor.BOLD + p.getPlayer().getName(), 1, 30, 10);
        p.setHealthScale(6);
        p.setHealth(6);
        p.getInventory().clear();
        p.setLevel(2020);
        p.setHealth(20);
        p.setFoodLevel(20);


        String title = "§aLOBBY-SERVER";


        if(p.hasPermission("lobby.join.effect") || p.isOp()) {
            p.setGlowing(true);
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 5, 2);
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GRAY + "SERVER ߪ " + ChatColor.RED + "LOBBY"));

        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }


}
