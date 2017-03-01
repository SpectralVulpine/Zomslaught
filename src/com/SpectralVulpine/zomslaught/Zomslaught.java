package com.SpectralVulpine.zomslaught;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.SpectralVulpine.zomslaught.Commands;
import com.SpectralVulpine.zomslaught.listeners.SpawnListener;
import com.SpectralVulpine.zomslaught.time.FrightNight;

public class Zomslaught extends JavaPlugin{
	
	public void onEnable() {
		this.getCommand("zomslaught").setExecutor(new Commands());
		Bukkit.getPluginManager().registerEvents(new SpawnListener(), this);
		Bukkit.getPluginManager().registerEvents(new FrightNight(), this);
		Bukkit.getLogger().log(Level.INFO, "[ZOMSLAUGHT] Zomslaught loaded");
	}
	
	public void onDisable() {
		Bukkit.getLogger().log(Level.INFO, "[ZOMSLAUGHT] Zomslaught unloading...");
	}
}
