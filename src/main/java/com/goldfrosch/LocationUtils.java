package com.goldfrosch;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class LocationUtils {
  private final PocketEmployer plugin;

  public void movePlayerToLocation(Player player, String location) {
    String loc = "location." + location;

    player.getLocation().set(
        plugin.getConfig().getInt(loc + ".x"),
        plugin.getConfig().getInt(loc + ".y"),
        plugin.getConfig().getInt(loc + ".z")
    );
  }
}
