package com.SpectralVulpine.zomslaught.runnables;

import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class FrightTimer extends BukkitRunnable{
	// Responsible for !!FUN!! weekly events.
	private int dayCounter = 0;
	private int triggerCount = 7;
	//private Zomslaught plugin;
	private FrightNight fright;
	
	public FrightTimer(Zomslaught zom, FrightNight f) {
		//plugin = zom;
		fright = f;
	}
	
	public void run() {
		dayCounter++;
	}
	
	public int getDayCounter() {
		return dayCounter;
	}
	
	public void setDayCounter(int value) {
		dayCounter = value;
	}
	
	public void checkFrightNight() {
		// If 7 days have passed and the sun is beginning to set, it is time for FrightNight Night
		// TODO: Find a way to check when the time is 13000 ticks
		if (dayCounter >= triggerCount) {
			fright.activate();
		}
	}
	
	public void userActivate() {
		setDayCounter(triggerCount);
	}
	
	public void userDeactivate() {
		setDayCounter(0);
	}
}