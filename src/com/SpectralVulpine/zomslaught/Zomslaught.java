package com.SpectralVulpine.zomslaught;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.SpectralVulpine.zomslaught.listeners.SpawnListener;

public class Zomslaught extends JavaPlugin{
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new SpawnListener(this), this);  // enables the spawnlistener
		Bukkit.getLogger().log(Level.INFO, "[ZOMSLAUGHT] Zomslaught loaded");
	}
	
	public void onDisable() {
		Bukkit.getLogger().log(Level.INFO, "[ZOMSLAUGHT] Zomslaught unloading...");
	}
}
