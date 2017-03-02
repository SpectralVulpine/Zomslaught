package com.SpectralVulpine.zomslaught;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TitleManager {
	
	Zomslaught plugin;
	
	public TitleManager(Zomslaught zom) {
		plugin = zom;
	}
	
	public void warning() {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a times 10 10 10");
		new Warning().runTaskTimer(plugin, 0, 31);
	}
}

class Warning extends BukkitRunnable{

	private int counter = 0;
	@Override
	public void run() {
		if (counter < 3) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a title {\"text\":\"WARNING\",\"color\":\"dark_red\",\"bold\":\"true\"}");
			counter++;
		} else {
			counter = 0;
			this.cancel();
		}
	}
}