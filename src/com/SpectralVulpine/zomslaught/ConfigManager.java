package com.SpectralVulpine.zomslaught;

public class ConfigManager {
	
	private Zomslaught plugin;
	public long frightTimer;
	public int frightDuration;
	
	public ConfigManager(Zomslaught zom) {
		plugin = zom;
		plugin.saveDefaultConfig();
		plugin.reloadConfig();
		frightTimer = plugin.getConfig().getInt("frightTimer");
		frightDuration = plugin.getConfig().getInt("frightDuration");
	}
	
	public long getFrightTimer() {
		return frightTimer;
	}
	
	public int getFrightDuration() {
		return frightDuration;
	}
}
