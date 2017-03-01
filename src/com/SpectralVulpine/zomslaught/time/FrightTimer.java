package com.SpectralVulpine.zomslaught.time;

import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class FrightTimer extends BukkitRunnable{
	// Responsible for !!FUN!! weekly events.
	private int dayCounter = 0;
	//private Zomslaught plugin;
	private Fright fright;
	
	public FrightTimer(Zomslaught zom, Fright f) {
		//plugin = zom;
		fright = f;
	}
	
	public void run() {
		addDayToCounter();
	}
	
	public int getDayCounter() {
		return dayCounter;
	}
	
	public void addDayToCounter() {
		dayCounter++;
	}
	
	public void setDayCounter(int value) {
		dayCounter = value;
	}
	
	public void checkFrightNight() {
		// If 7 days have passed and the sun is beginning to set, it is time for Fright Night
		// TODO: Find a way to check when the time is 13000 ticks
		if (dayCounter >= 7) {
			fright.activate();
		}
	}
	
	public void userActivate() {
		setDayCounter(7);
	}
	
	public void userDeactivate() {
		setDayCounter(0);
	}
}