package de.mommde.sys.listener;

import de.mommde.sys.commands.Build;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class block implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if(!Build.allowed.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if(!Build.allowed.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
