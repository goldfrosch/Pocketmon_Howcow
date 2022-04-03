package com.goldfrosch.events;

import com.goldfrosch.LocationUtils;
import com.goldfrosch.PocketEmployer;
import lombok.RequiredArgsConstructor;
import net.md_5.bungee.api.chat.TextComponent;
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
            String targetName = snowball.getItem().getItemMeta().getDisplayName();

            if(e.getHitEntity() instanceof Player) {
                Player player = (Player) e.getHitEntity();
                LocationUtils locationUtils = new LocationUtils(plugin);

                switch (targetName) {
                    case "하우카우 볼":
                        locationUtils.movePlayerToLocation(player, "streamer");
                        break;
                    case "직원 볼":
                        locationUtils.movePlayerToLocation(player, "employer");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
