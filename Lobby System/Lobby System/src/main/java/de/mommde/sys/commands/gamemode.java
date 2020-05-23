package de.mommde.sys.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemode implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("lobby.changegamemode") || p.isOp()) {
            if(args.length != -1);
            if(args[0].equals("c")) {
                if(p.getGameMode().equals(GameMode.CREATIVE)) {
                    p.sendMessage(ChatColor.GRAY + "Du bist bereits im " + ChatColor.GREEN + p.getGameMode() + ChatColor.GRAY + " modus.");
                } else {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatColor.GRAY + "Dein Spielmodus wurde auf " + ChatColor.GREEN + p.getGameMode() + ChatColor.GRAY + " gesetzt");
                }
            }
            if(args[0].equals("s")) {
                if(p.getGameMode().equals(GameMode.SURVIVAL)) {
                    p.sendMessage(ChatColor.GRAY + "Du bist bereits im " + ChatColor.GREEN + p.getGameMode() + ChatColor.GRAY + " modus.");
                } else {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GRAY + "Dein Spielmodus wurde auf " + ChatColor.GREEN + p.getGameMode() + ChatColor.GRAY + " gesetzt");
                }
            }
            if(args[0].equals("sp")) {
                if(p.getGameMode().equals(GameMode.SPECTATOR)) {
                    p.sendMessage(ChatColor.GRAY + "Du bist bereits im " + ChatColor.GREEN + p.getGameMode() + ChatColor.GRAY + " modus.");
                } else {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(ChatColor.GRAY + "Dein Spielmodus wurde auf " + ChatColor.GREEN + p.getGameMode() + ChatColor.GRAY + " gesetzt");
                }
            }
            if(args[0].equals("a")) {
                if(p.getGameMode().equals(GameMode.ADVENTURE)) {
                    p.sendMessage(ChatColor.GRAY + "Du bist bereits im " + ChatColor.GREEN + p.getGameMode() + ChatColor.GRAY + " modus.");
                } else {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(ChatColor.GRAY + "Dein Spielmodus wurde auf " + ChatColor.GREEN + p.getGameMode() + ChatColor.GRAY + " gesetzt");
                }
            }
        }
        return false;
    }
}
