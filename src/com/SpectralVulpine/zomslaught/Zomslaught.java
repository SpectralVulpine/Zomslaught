/*
 * Zomslaught: a zombie survival plugin for Minecraft
 * Written by SpectralVulpine (http://www.spectralvulpine.com)
 */

package com.SpectralVulpine.zomslaught;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import com.SpectralVulpine.zomslaught.listeners.SpawnListener;
import com.SpectralVulpine.zomslaught.runnables.FrightNight;

public class Zomslaught extends JavaPlugin{
	
	public FrightNight fright;
	public TitleManager titles;
	public ConfigManager config;
	
	public void onEnable() {
		config = new ConfigManager(this);
		Commands exe = new Commands(this);
		fright = new FrightNight(this);
		titles = new TitleManager(this);
		this.getCommand("zomslaught").setExecutor(exe);
		Bukkit.getPluginManager().registerEvents(new SpawnListener(this, fright), this);
		fright.runTaskTimer(this, config.getFrightTimer()*20, config.getFrightTimer()*20);
		if (config.getPermanight()) {
			Bukkit.getWorld(getActiveWorldName()).setGameRuleValue("doDaylightCycle", "false");
			Bukkit.getWorld(getActiveWorldName()).setTime(18000);
		}
	}
	
	public String getActiveWorldName() {
		// Find the overworld (not Nether or End) and return it
		List<World> worldList = Bukkit.getWorlds();
		
		for (World world : worldList) {
			String worldName = world.getName();
			if (!worldName.endsWith("nether") && !worldName.endsWith("end")) {
				return worldName;
			}
		}
		return "world";
	}
}
