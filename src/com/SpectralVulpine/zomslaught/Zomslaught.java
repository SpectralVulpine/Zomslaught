package com.SpectralVulpine.zomslaught;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.SpectralVulpine.zomslaught.listeners.SpawnListener;
import com.SpectralVulpine.zomslaught.time.Fright;
import com.SpectralVulpine.zomslaught.time.FrightTimer;

public class Zomslaught extends JavaPlugin{
	
	public Fright fright;
	
	public void onEnable() {
		Commands exe = new Commands();
		this.getCommand("zomslaught").setExecutor(exe);
		this.getCommand("zombietime").setExecutor(exe);
		Bukkit.getPluginManager().registerEvents(new SpawnListener(fright), this);
//		Bukkit.getPluginManager().registerEvents(new FrightTimer(this, fright), this);
		new FrightTimer(this, fright).runTaskTimer(this, 0, 24000);
	}
	
	public void onDisable() {
		Bukkit.getLogger().log(Level.INFO, "[Zomslaught] Zomslaught unloading...");
	}
}
