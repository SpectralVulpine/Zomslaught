package com.SpectralVulpine.zomslaught;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor{
	
	Zomslaught plugin;
	
	public Commands(Zomslaught zom) {
		plugin = zom;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("zomslaught")) {
			if (sender.hasPermission("zomslaught.admin")){
				/*if (args.length == 0) {
					sender.sendMessage(cmd.getUsage());  // TODO: Make a message that outlines all commands
				}*/
				if (args[0] == "fright") {
					if (args[1] == "activate") {
						sender.sendMessage("What have you done?!");
						sender.sendMessage("Tonight will now be §4very dangerous!");
						plugin.fright.activate();
					}
				}
				sender.sendMessage("Commands will go here");  // TODO: Add fright night activate/deactivate commands
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("zombietime")) {
//			sender.sendMessage(Long.toString(Bukkit.getWorld("world").getTime()));
			plugin.titles.warning();
			return true;
		}
		return false;
	}
	
}
