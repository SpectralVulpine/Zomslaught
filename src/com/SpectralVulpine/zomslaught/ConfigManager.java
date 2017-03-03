package com.SpectralVulpine.zomslaught;

public class ConfigManager {
	
	private Zomslaught plugin;
	
	public ConfigManager(Zomslaught zom) {
		plugin = zom;
		plugin.saveDefaultConfig();
		plugin.reloadConfig();
	}
	
	public long getFrightTimer() {
		return plugin.getConfig().getInt("frightTimer");
	}
	
	public int getFrightDuration() {
		return plugin.getConfig().getInt("frightDuration");
	}
	
	public boolean getPermanight() {
		return plugin.getConfig().getBoolean("permanight");
	}
}
