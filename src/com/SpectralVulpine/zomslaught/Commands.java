package com.SpectralVulpine.zomslaught;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("zomslaught")) {
			if (sender.hasPermission("zomslaught.admin")){
				/*if (args.length == 0) {
					sender.sendMessage(cmd.getUsage());  // TODO: Make a message that outlines all commands
				}*/
				sender.sendMessage("Commands will go here");  // TODO: Add fright night activate/deactivate commands
			}
			return true;
		}
		/*if (cmd.getName().equalsIgnoreCase("zombietime")) {
			sender.sendMessage(Long.toString(Bukkit.getWorld("world").getTime()));
			return true;
		}*/
		return false;
	}
	
}
