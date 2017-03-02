package com.SpectralVulpine.zomslaught.runnables;

import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class FrightTimer extends BukkitRunnable{
	// Responsible for !!FUN!! weekly events.
	private FrightNight fright;
	Zomslaught plugin;
	
	public FrightTimer(Zomslaught zom, FrightNight f) {
		fright = f;
		plugin = zom;
	}
	
	public void run() {
		if (!fright.getActive()) {
			fright.runTask(plugin);			
		}
	}
}