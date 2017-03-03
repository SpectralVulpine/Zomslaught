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
				if (args.length == 0) {
					sender.sendMessage("§6---------§eZomslaught§6------------------------------\n"
							+ "§e§oCommands:\n"
							+ "§2/zomslaught fright §7§o- activates Fright Night");
				}
				else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("fright") && plugin.fright.getActive() == false) {
						sender.sendMessage("§e[Zomslaught] §4§oFright Night activated! §4What have you done?!");
						plugin.fright.run();
					} 
					else if (args[0].equalsIgnoreCase("fright") && plugin.fright.getActive() == true) {
						sender.sendMessage("§e[Zomslaught] §cFright Night is already active. Wait a minute before trying again.");
					}
				}
			}
			return true;
		}
		return false;
	}	
}
