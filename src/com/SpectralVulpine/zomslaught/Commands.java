package com.SpectralVulpine.zomslaught;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("zomslaught")) {
			if (sender.hasPermission("zomslaught.admin")){
				sender.sendMessage("Commands will go here");  // TODO: Add fright night command
			}
		}
		return false;
	}
	
}
