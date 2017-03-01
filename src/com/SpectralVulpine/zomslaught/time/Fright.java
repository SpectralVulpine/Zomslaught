package com.SpectralVulpine.zomslaught.time;

public class Fright {
	public String frightMode;
	public boolean frightIsOn = false;
	public Fright(String startingMode) {
		frightMode = startingMode;
	}
	
	public void setMode(String newMode) {
		frightMode = newMode;
	}
	
	public void setActive(String mode) {
		setMode(mode);
		frightIsOn = true;
	}
	
	public String getMode() {
		return frightMode;
	}
	
	public boolean getActive() {
		return frightIsOn;
	}
	
	public void activate() {
		// TODO: Add more frights
		// TODO: Randomly pick which fright to use
		setActive("baby");
	}
	
	public void deactivate() {
		frightIsOn = false;		
	}
}
