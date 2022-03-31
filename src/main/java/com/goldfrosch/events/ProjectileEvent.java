package com.goldfrosch.events;

import com.goldfrosch.PocketEmployer;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

@RequiredArgsConstructor
public class ProjectileEvent implements Listener {
    private final PocketEmployer plugin;

    @EventHandler
    public void onProjectileHurtEvent(ProjectileHitEvent e) {
        Projectile projectile = e.getEntity();

        if(projectile.getType() == EntityType.SNOWBALL) {
            Snowball snowball = (Snowball) projectile;
            String targetName = String.valueOf(snowball.getItem().getItemMeta().displayName());

            Player player = (Player) e.getHitEntity();

            switch (targetName) {
                case "하우카우 볼":
                    player.sendMessage("으아아아앍");
                    player.getLocation().setY(100);
                    break;
                case "직원 볼":
                    player.sendMessage("으아아아앍2");
                    player.getLocation().setY(50);
                    break;
                default:
                    break;
            }
        }
    }
}
