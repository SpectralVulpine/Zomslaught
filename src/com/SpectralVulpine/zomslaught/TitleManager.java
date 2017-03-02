package com.SpectralVulpine.zomslaught;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TitleManager {
	
	Zomslaught plugin;
	
	public TitleManager(Zomslaught zom) {
		plugin = zom;
	}
	
	public void warning() {
		new Warning().runTaskTimer(plugin, 0, 31);
	}
}

class Warning extends BukkitRunnable{

	private int counter = 0;
	
	@Override
	public void run() {
		if (counter < 3) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.sendTitle("§4§lWARNING", "", 10, 10, 10);
			}
			counter++;
		} else {
			this.cancel();
		}
	}
}