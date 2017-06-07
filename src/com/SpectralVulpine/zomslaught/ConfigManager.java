package com.SpectralVulpine.zomslaught;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
	
	private Zomslaught plugin;
	public FileConfiguration file;
	
	public ConfigManager(Zomslaught zom) {
		plugin = zom;
		plugin.saveDefaultConfig();
		plugin.reloadConfig();
		file = plugin.getConfig();
	}
	/*
	public int getExtraZombieAmt() {
		int eza = file.getInt("extraZombieAmt");
		if (eza < 0) {
			Bukkit.getLogger().log(Level.WARNING, "[Zomslaught] extraZombieAmt in config.yml is an invalid value!\n"
					+ "Defaulting to 1...");
			eza = 1;
			file.set("extraZombieAmt", eza);
		}
		return eza;
	}
	
	public int getExtraZombieChance() {
		int ezc = file.getInt("extraZombieChance");
		if (ezc < 0 || ezc > 100) {
			Bukkit.getLogger().log(Level.WARNING, "[Zomslaught] extraZombieChance in config.yml is an invalid value!\n"
					+ "Defaulting to 50...");
			ezc = 50;
			file.set("extraZombieChance", ezc);
		}
		return ezc;
	}*/
	
	public double getDoubleChance() {
		return file.getDouble("dwChance");
	}
	
	public double getDudChance() {
		return file.getDouble("dudChance");
	}
	
	public long getFrightTimer() {
		return file.getInt("frightTimer");
	}
	
	public int getFrightDuration() {
		return file.getInt("frightDuration");
	}
	
	public boolean getPermanight() {
		return file.getBoolean("permanight");
	}
}
