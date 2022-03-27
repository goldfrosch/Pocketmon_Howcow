package com.goldfrosch.events;

import com.goldfrosch.PocketEmployer;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.Objects;

@RequiredArgsConstructor
public class NewEvent implements Listener {
    private final PocketEmployer plugin;

    @EventHandler
    public void onPlayerThrowBallEvent(ProjectileLaunchEvent e) {
        if(e.getEntity().getShooter() instanceof Player) {
            Player player = (Player) e.getEntity().getShooter();

            player.getInventory().getItemInMainHand().setAmount(1);
        }
    }

    @EventHandler
    public void onProjectileHurtEvent(ProjectileHitEvent e) {
        if(e.getEntity().getShooter() instanceof Player) {
            ((Player) e.getEntity().getShooter()).sendMessage(Objects.requireNonNull(e.getEntity().getCustomName()));
            Objects.requireNonNull(e.getHitEntity()).setRotation(0.5f,0.5f);
        }
    }
}
