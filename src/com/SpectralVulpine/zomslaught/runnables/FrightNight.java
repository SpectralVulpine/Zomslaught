package com.SpectralVulpine.zomslaught.runnables;

//import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class FrightNight extends BukkitRunnable{
	public String frightMode;
	public boolean frightTonight = false;
	public boolean frightNow = false;
	
	public void run() {
//		long currentTime = Bukkit.getWorld("world").getTime();
		/*if (currentTime >= 19000 && frightNow == false) {
			frightNow = true;
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a times 10 10 10");
			for (int i=0; i<3; i++){				
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a {text:\"WARNING\",color:dark_red,bold:true}");
			}
		}*/
	}
	
	public void setMode(String newMode) {
		frightMode = newMode;
	}
	
	public String getMode() {
		return frightMode;
	}
	
	public void setActive(String mode) {
		setMode(mode);
		frightTonight = true;
	}
	
	public boolean getActive() {
		return frightTonight;
	}
	
	public void activate() {
		// TODO: Add more frights
		// TODO: Randomly pick which fright to use
		setActive("baby");
	}
	
	public void deactivate() {
		frightTonight = false;		
	}
}
