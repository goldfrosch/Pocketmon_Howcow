package com.goldfrosch.events;

import com.goldfrosch.PocketEmployer;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

@RequiredArgsConstructor
public class NewEvent implements Listener {
    private final PocketEmployer plugin;

    @EventHandler
    public void onPlayerThrowBallEvent(ProjectileLaunchEvent e) {
        for(Player player: plugin.getServer().getOnlinePlayers()) {
            player.sendMessage(e.getEntity().getShooter().toString());
        }
    }
}
