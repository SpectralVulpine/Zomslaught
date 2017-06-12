package com.SpectralVulpine.zomslaught.runnables;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class LightningStrike extends BukkitRunnable {
	
	int counter = 1;
	boolean damage = false;
	Location target;
	World world;
	
	public LightningStrike(Location l) {
		target = l;
		world = l.getWorld();
	}
	
	public LightningStrike(Location l, int strikeCount) {
		counter = strikeCount;
		target = l;
		world = l.getWorld();
	}
	
	public LightningStrike(Location l, int strikeCount, boolean doesDamage) {
		counter = strikeCount;
		damage = doesDamage;
		target = l;
		world = l.getWorld();
	}

	@Override
	public void run() {
		while (counter > 0) {
			if (damage) {
				world.strikeLightning(target);
			} else {
				world.strikeLightningEffect(target);
			}
			counter--;
		}
		this.cancel();
	}
}
