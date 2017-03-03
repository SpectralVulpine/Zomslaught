package com.SpectralVulpine.zomslaught.runnables;

import java.util.Random;

import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class FrightNight extends BukkitRunnable{
	private Random rng;
	public String frightMode;
	public Zomslaught plugin;
	public boolean frightActive = false;
	public String[] frights = {"baby", "invisible", "strength"};
	
	public FrightNight(Zomslaught zom) {
		plugin = zom;
		rng = new Random();
		rng.setSeed(System.currentTimeMillis() + 1);
	}
	
	public void run() {
		// If not already activate, pick a scenario and activate Fright Night
		// TODO: Add double whammies!
		if (!getActive()) {
			setMode(frights[rng.nextInt(frights.length)]);
			frightActive = true;
			plugin.titles.warning(getMode());
			new Deactivate(this).runTaskLater(plugin, plugin.config.getFrightDuration()*20);
		}
	}
	
	public void setMode(String newMode) {
		frightMode = newMode;
	}
	
	public String getMode() {
		return frightMode;
	}
	
	public void setActive() {
		frightActive = !frightActive;
	}
	
	public boolean getActive() {
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