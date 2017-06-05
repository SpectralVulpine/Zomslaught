package com.SpectralVulpine.zomslaught.runnables;

//import java.util.List;
import java.util.Random;

/*import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;*/
import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class FrightNight extends BukkitRunnable{
	private Random rng;
	public String frightMode;
	public Zomslaught plugin;
	public boolean frightActive = false;
	public String[] frights = {"baby", "double", "invisible", "strength1", "strength2", "swift1", "swift2"};
	
	public FrightNight(Zomslaught zom) {
		plugin = zom;
		rng = new Random();
		rng.setSeed(System.currentTimeMillis() + 1);
	}
	
	public void run() {
		// If not already activate, pick a scenario and activate Fright Night
		// TODO: Add double whammies!
		// Double whammies already have configuration options set for them
		if (!isActive()) {
			if (rng.nextDouble() <= plugin.config.getDudChance()) {
				setMode("dud");
			} else {
				setMode(frights[rng.nextInt(frights.length)]);
				setActive();
			}
			plugin.titles.warning(getMode());
			// TODO: Make existing zombies get the Fright Night effects too
			/*List<LivingEntity> entityList = Bukkit.getWorld(plugin.getActiveWorldName()).getLivingEntities();
			switch (getMode()) {
			case "baby":
				for (Entity ent : entityList) {
					if (ent instanceof Zombie) {
//						ent.setBaby(true);
					}
				}
			}*/
			new Deactivate(this).runTaskLater(plugin, plugin.config.getFrightDuration()*20);
		}
	}
	
	// TODO: Make custom parameters for command work
	
	public void setMode(String newMode) {
		frightMode = newMode;
	}
	
	public String getMode() {
		return frightMode;
	}
	
	public void setActive() {
		frightActive = true;
	}
	
	public boolean isActive() {
		return frightActive;
	}
	
	public void deactivate() {
		frightActive = false;	
	}
}

class Deactivate extends BukkitRunnable {
	
	FrightNight fright;
	public Deactivate(FrightNight f) {
		fright = f;
	}
	public void run() {
		fright.deactivate();
	}
}