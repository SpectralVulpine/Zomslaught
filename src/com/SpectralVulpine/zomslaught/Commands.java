package com.SpectralVulpine.zomslaught;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor{
	
	Zomslaught plugin;
	private String helpOutput = "§6---------§eZomslaught§6------------------------------\n"
			+ "§e§oCommands:\n"
			+ "§2/zomslaught fright §7§o- activates Fright Night";
	private String frightActivated = "§e[Zomslaught] §4§oFright Night activated! §4What have you done?!";
	
	public Commands(Zomslaught zom) {
		plugin = zom;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("zomslaught")) {
			if (sender.hasPermission("zomslaught.admin")) {
				if (args.length >= 1 && args[0].equalsIgnoreCase("fright")) {
					if (plugin.fright.isActive() == false) {
						if (args.length == 1) {
							plugin.fright.runTask(plugin);
							sender.sendMessage(frightActivated);
						}
						// TODO: Make custom parameters for command work
						/*else if (args.length == 2) {
							if (args[1].equalsIgnoreCase("baby") ||
									args[1].equalsIgnoreCase("invisible") ||
									args[1].equalsIgnoreCase("strength")) {
								plugin.fright.runCustomMode(args[1]);
								sender.sendMessage(frightActivated);
							}
							else {
								sender.sendMessage("§e[Zomslaught] §cInvalid parameter specified: §2<mode>");
							}
						}*/
						else {
							sender.sendMessage(helpOutput);
						}
					} 
					else if (plugin.fright.isActive() == true) {
						sender.sendMessage("§e[Zomslaught] §cFright Night is already active. Wait a minute before trying again.");
					}
				} else {
					sender.sendMessage(helpOutput);
				}
			} else {
				sender.sendMessage("§e[Zomslaught] §cYou do not have the necessary permissions to use this command.");
			}
			return true;
		} else { return false; }
	}	
}
