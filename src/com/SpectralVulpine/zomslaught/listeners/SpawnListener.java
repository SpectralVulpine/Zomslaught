package com.SpectralVulpine.zomslaught.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.SpectralVulpine.zomslaught.Zomslaught;
import com.SpectralVulpine.zomslaught.runnables.FrightNight;

public class SpawnListener implements Listener{
	
	public FrightNight fright;
	public Zomslaught plugin;
	private Random rng;
	
	public SpawnListener(Zomslaught zom, FrightNight f) {
		plugin = zom;
		fright = f;
		rng = new Random();
		rng.setSeed(System.currentTimeMillis());
	}
	
	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent e) {
		if ((e.getEntity() instanceof Creeper ||
				e.getEntity() instanceof Skeleton ||
				e.getEntity() instanceof Spider ||
				e.getEntity() instanceof Enderman) && 
				(e.getSpawnReason().equals(SpawnReason.NATURAL))) {
			// For any of the above mobs, give them a 50/50 shot of spawning as a zombie instead.
			int chance = rng.nextInt(2);
			if (chance == 1) {
				Location spawnLoc = e.getLocation();
				e.setCancelled(true);
				Bukkit.getWorld(plugin.getActiveWorldName()).spawnEntity(spawnLoc, EntityType.ZOMBIE);
			}
		}
		if (fright.isActive()) {
			// These are if's and not else if's so we can implement Double Whammy later
			if (e.getEntity() instanceof Zombie && fright.getMode() == "baby") {
				Zombie z = (Zombie)e.getEntity();
				z.setBaby(true);	
			}
			if (e.getEntity() instanceof Zombie && fright.getMode() == "strength") {
				Zombie z = (Zombie)e.getEntity();
				z.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0, false));
			}
			if (e.getEntity() instanceof Zombie && fright.getMode() == "invisible") {
				Zombie z = (Zombie)e.getEntity();
				z.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 600, 0, false));
			}
		}
	}
}
