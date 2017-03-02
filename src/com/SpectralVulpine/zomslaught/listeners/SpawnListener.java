package com.SpectralVulpine.zomslaught.listeners;

import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.SpectralVulpine.zomslaught.runnables.FrightNight;

public class SpawnListener implements Listener{
	
	public FrightNight fright;
	
	public SpawnListener(FrightNight f) {
		fright = f;
	}
	
	@EventHandler
	// Turns all zombie spawns into baby zombies
	public void onMobSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Zombie && fright.getMode() == "baby") {
			Zombie z = (Zombie)e.getEntity();
			z.setBaby(true);	
		}
	}
}
