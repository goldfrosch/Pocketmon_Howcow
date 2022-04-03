package com.goldfrosch.commands;

import com.goldfrosch.PocketEmployer;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Commands extends AbstractCommand {
    public Commands(PocketEmployer plugin, String Command) {
        super(plugin,Command);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        return null;
    }

    public void setLocation(String location, Player player) {
        Location playerLocation = player.getLocation();
        plugin.getConfig().set(location + ".x" , playerLocation.getBlockX());
        plugin.getConfig().set(location + ".y" , playerLocation.getBlockY());
        plugin.getConfig().set(location + ".z" , playerLocation.getBlockZ());

        plugin.saveDefaultConfig();
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        String prefix = plugin.getConfig().getString("message.prefix").replace("&", "§");

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(label.equalsIgnoreCase("pocket")){
                if(args.length == 0){
                    player.sendMessage(prefix + "어쩔 티비");
                } else {
                    if (args[0].equals("set")) {
                        switch (args[1]) {
                            case "employer":
                                setLocation("location.employer", player);
                                player.sendMessage("성공적으로 저장되었습니다. ( 직원 위치 )");
                                break;
                            case "streamer":
                                setLocation("location.streamer", player);
                                player.sendMessage("성공적으로 저장되었습니다. ( 스트리머 위치 )");
                                break;
                            default:
                                player.sendMessage("존재하지 않는 명령어 입니다.");
                                break;
                        }
                    }
                    else {
                        player.sendMessage("존재하지 않는 명령어 입니다");
                    }
                }
            }
        }
        return false;
    }
}
