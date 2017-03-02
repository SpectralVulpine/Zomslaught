package com.SpectralVulpine.zomslaught;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.SpectralVulpine.zomslaught.listeners.SpawnListener;
import com.SpectralVulpine.zomslaught.runnables.FrightNight;
import com.SpectralVulpine.zomslaught.runnables.FrightTimer;

public class Zomslaught extends JavaPlugin{
	
	public FrightNight fright;
	public TitleManager titles;
	
	public void onEnable() {
		Commands exe = new Commands(this);
		fright = new FrightNight();
		titles = new TitleManager(this);
		this.getCommand("zomslaught").setExecutor(exe);
		this.getCommand("zombietime").setExecutor(exe);
		Bukkit.getPluginManager().registerEvents(new SpawnListener(fright), this);
		new FrightTimer(this, fright).runTaskTimer(this, 0, 24000);
	}
	
	public void onDisable() {
		Bukkit.getLogger().log(Level.INFO, "[Zomslaught] Zomslaught unloading...");
	}
}
