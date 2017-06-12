package com.SpectralVulpine.zomslaught.runnables;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class BossSpawner extends BukkitRunnable {
	
	Random rng = new Random();
	int minx = 5000;
	int maxx = 5000;
	int minz = 5000;
	int maxz = 5000;

	Zomslaught plugin;
	 
	int x = rng.nextInt(maxx - (minx) + 1) + (minx);
	int z = rng.nextInt(maxz - (minz) + 1) + (minz);
	int y = Bukkit.getWorld(plugin.getActiveWorldName()).getHighestBlockAt(x, z).getY();
	Location loc = new Location(Bukkit.getWorld(plugin.getActiveWorldName()), x,y,z);

	@Override
	public void run() {
		// TODO Put code here
		
	}
}
