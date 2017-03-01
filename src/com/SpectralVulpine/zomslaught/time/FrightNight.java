package com.SpectralVulpine.zomslaught.time;

import org.bukkit.event.Listener;

public class FrightNight implements Listener{
	// Responsible for !!FUN!! weekly events.
	private int dayCounter = 0;
	
	public int getDayCounter() {
		return dayCounter;
	}
	
	public void addDayToCounter() {
		dayCounter++;
	}
	
	public void setDayCounter(int value) {
		dayCounter = value;
	}
	
	public boolean checkFrightNight() {
		// If 7 days have passed and the sun is beginning to set, it is time for Fright Night
		// TODO: Find a way to check when the time is 13000 ticks
		if (dayCounter >= 7)
			return true;
		else {return false;}
	}
	
	public void doFrightNight() {
		// TODO: When the day counter has hit 7, FRIGHT NIGHT!
		if (checkFrightNight()) {
			// TODO: Stuff will go here
		}
	}

	public void onNewDay() {
		// TODO: Find some way to detect if a new day has started (midnight?)
	}
	
	public void onTimeSkip() {
		// TODO: When the user skips time forward with the /time set command, update the day counter accordingly
	}
	
	public void onActivated() {
		// TODO: When the user uses the /zomslaught fright command, Fright Night is activated
		setDayCounter(7);
	}
}
