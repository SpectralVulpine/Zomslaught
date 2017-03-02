package com.SpectralVulpine.zomslaught.listeners;

import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.SpectralVulpine.zomslaught.runnables.FrightNight;

public class SpawnListener implements Listener{
	
	public FrightNight fright;
	
	public SpawnListener(FrightNight f) {
		fright = f;
	}
	
	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent e) {
		if (fright.getActive()) {
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
