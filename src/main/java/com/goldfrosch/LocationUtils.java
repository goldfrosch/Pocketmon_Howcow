package com.goldfrosch;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
public class LocationUtils {
  private final PocketEmployer plugin;

  public Map<UUID, Boolean> isInPocket = new HashMap<>();
  public Map<UUID, Location> playerBackLocation = new HashMap<>();

  public void backRandomChance(Player player) {
    Random chance = new Random();

    if(chance.nextInt(100) > plugin.getConfig().getInt("chance")) {
      player.teleport(playerBackLocation.get(player.getUniqueId()));
    }

    isInPocket.put(player.getUniqueId(), isInPocket.getOrDefault(player.getUniqueId(), true));
  }

  public void movePlayerToLocation(Player player, String location) {
    String loc = "location." + location;
    World world = plugin.getServer().getWorld("world");

    Location backLoc = new Location(
        world,
        player.getLocation().getX(),
        player.getLocation().getY(),
        player.getLocation().getZ()
    );
    
    playerBackLocation.put(player.getUniqueId(), backLoc);

    double x = plugin.getConfig().getDouble(loc + ".x");
    double y = plugin.getConfig().getDouble(loc + ".y");
    double z = plugin.getConfig().getDouble(loc + ".z");

    Location moveLoc = new Location(plugin.getServer().getWorld("world"), x, y, z);
    isInPocket.put(player.getUniqueId(), isInPocket.getOrDefault(player.getUniqueId(), true));

    player.teleport(moveLoc);

    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> backRandomChance(player), 40L);
  }
}
