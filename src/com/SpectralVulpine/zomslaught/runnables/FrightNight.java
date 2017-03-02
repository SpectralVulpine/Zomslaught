package com.SpectralVulpine.zomslaught.runnables;

//import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class FrightNight extends BukkitRunnable{
	public String frightMode;
	public Zomslaught plugin;
	public boolean frightActive = false;
	
	public FrightNight(Zomslaught zom) {
		plugin = zom;
	}
	
	public void run() {
		new Deactivate(this).runTaskLater(plugin, 1200);
	}
	
	public void setMode(String newMode) {
		frightMode = newMode;
	}
	
	public String getMode() {
		return frightMode;
	}
	
	public void setActive(String mode) {
		setMode(mode);
		frightActive = true;
	}
	
	public boolean getActive() {
		return frightActive;
	}
	
	public void activate() {
		// TODO: Add more frights
		// TODO: Randomly pick which fright to use
		setActive("baby");
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