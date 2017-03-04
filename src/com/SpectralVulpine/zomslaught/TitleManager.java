package com.SpectralVulpine.zomslaught;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TitleManager {
	
	Zomslaught plugin;
	
	public TitleManager(Zomslaught zom) {
		plugin = zom;
	}
	
	public void warning(String warningType) {
		new Warning(warningType).runTaskTimer(plugin, 0, 31);
	}
}

class Warning extends BukkitRunnable{

	private int counter = 0;
	private String subtitle;
	
	public Warning(String warningType) {
		if (warningType.equals("baby")) {
			subtitle = "§3The Younglings Strike";
		}
		else if (warningType.equals("double")) {
			subtitle = "§9Duplicate! Duplicate!";
		}
		else if (warningType.equals("invisible")) {
			subtitle = "§7Now you see me...";
		}
		else if (warningType.equals("strength1")) {
			subtitle = "§2Bodybuilding Zombies";
		}
		else if (warningType.equals("strength2")) {
			subtitle = "§2§lHULKING Zombies";
		}
		else if (warningType.equals("swift1")) {
			subtitle = "§bSpeed Boost";
		}
		else if (warningType.equals("swift2")) {
			subtitle = "§bSpeed §oDEMONS!";
		}
	}
	
	@Override
	public void run() {
		if (counter < 3) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendTitle("§4§lWARNING", "", 10, 10, 10);
			}
			counter++;
		} else {
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendTitle("§7§oFRIGHT NIGHT!", subtitle, 10, 70, 20);
			}
			this.cancel();
		}
	}
}