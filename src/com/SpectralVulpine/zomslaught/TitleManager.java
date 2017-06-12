package com.SpectralVulpine.zomslaught;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TitleManager {
	
	Zomslaught plugin;
	private HashMap<String, String> possibleSubs;
	
	public TitleManager(Zomslaught zom) {
		plugin = zom;
		possibleSubs = new HashMap<String, String>();
		possibleSubs.put("baby", "§3Baby Zombies");
		possibleSubs.put("double", "§9Double Spawns");
		possibleSubs.put("invisible", "§7Invisiblilty");
		possibleSubs.put("strength2", "§2Strength");
		possibleSubs.put("swift2", "§bSpeed");
	}
	
	public void warning(String warningType) {
		new Warning(warningType).runTaskTimer(plugin, 0, 31);
	}
	
	public String getSubtitle(String key) {
		return possibleSubs.get(key);
	}
}

class Warning extends BukkitRunnable{

	private int counter;
	private String subtitle;
	private HashMap<String, String> possibleSubs;
	
	public Warning(String warningType) {
		counter = 0;
		possibleSubs = new HashMap<String, String>();
		possibleSubs.put("baby", "§3The Younglings Strike");
		possibleSubs.put("double", "§9Duplicate! Duplicate!");
		possibleSubs.put("doubleWhammy", "§4§l§nDOUBLE WHAMMY!");
		possibleSubs.put("invisible", "§7Now you see me...");
		possibleSubs.put("strength1", "§2Bodybuilding Zombies");
		possibleSubs.put("strength2", "§2§lHULKING Zombies");
		possibleSubs.put("swift1", "§bSpeed Boost");
		possibleSubs.put("swift2", "§bSpeed §oDEMONS!");
		possibleSubs.put("dud", "§a...Just kidding!");
		subtitle = possibleSubs.get(warningType);
	}
	
	@Override
	public void run() {
		while (counter < 3) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendTitle("§4§lWARNING", "", 10, 10, 10);
			}
			counter++;
		}
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.sendTitle("§7§oFRIGHT NIGHT!", subtitle, 10, 70, 20);
		}
		this.cancel();
	}
}