package de.mommde.sys.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Build implements CommandExecutor {

    public static ArrayList<Player> allowed = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("lobby.build") || p.isOp()) {
            if(allowed.contains(p)) {
                allowed.remove(p);
                        p.sendMessage(ChatColor.GREEN + "Du" + ChatColor.GRAY + " kannst jetzt " + ChatColor.RED + "NICHTMEHR " + ChatColor.GRAY + "bauen");
            }
            else {
                allowed.add(p);
                p.sendMessage(ChatColor.GREEN + "Du" + ChatColor.GRAY + " kannst " + ChatColor.GREEN + "BAUEN");

            }
        }
        return false;
    }
}
