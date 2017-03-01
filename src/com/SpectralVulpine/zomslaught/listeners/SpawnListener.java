package com.SpectralVulpine.zomslaught.listeners;

import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnListener implements Listener{
	
	@EventHandler
	// Turns all zombie spawns into baby zombies
	public void onMobSpawn(CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Zombie) {
			Zombie z = (Zombie)e.getEntity();
			z.setBaby(true);	
		}
	}
}
