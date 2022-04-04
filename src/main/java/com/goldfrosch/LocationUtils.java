package com.goldfrosch;

import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class LocationUtils {
  private final PocketEmployer plugin;

  public void movePlayerToLocation(Player player, String location) {
    String loc = "location." + location;

    double x = plugin.getConfig().getDouble(loc + ".x");
    double y = plugin.getConfig().getDouble(loc + ".y");
    double z = plugin.getConfig().getDouble(loc + ".z");

    Location moveLoc = new Location(plugin.getServer().getWorld("world"), x, y, z);

    player.teleport(moveLoc);
  }
}
