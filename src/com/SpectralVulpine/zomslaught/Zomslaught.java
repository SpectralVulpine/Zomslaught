package com.SpectralVulpine.zomslaught;

import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import com.SpectralVulpine.zomslaught.listeners.SpawnListener;
import com.SpectralVulpine.zomslaught.runnables.FrightNight;
import com.SpectralVulpine.zomslaught.runnables.FrightTimer;

public class Zomslaught extends JavaPlugin{
	
	public FrightNight fright;
	public TitleManager titles;
	
	public void onEnable() {
		Commands exe = new Commands(this);
		fright = new FrightNight(this);
		titles = new TitleManager(this);
		this.getCommand("zomslaught").setExecutor(exe);
		this.getCommand("zombietime").setExecutor(exe);
		Bukkit.getPluginManager().registerEvents(new SpawnListener(fright), this);
		new FrightTimer(this, fright).runTaskTimer(this, 0, 24000);
		Bukkit.getWorld(getActiveWorldName()).setGameRuleValue("doDaylightCycle", "false");
		Bukkit.getWorld(getActiveWorldName()).setTime(18000);
	}
	
	public void onDisable() {
		Bukkit.getLogger().log(Level.INFO, "[Zomslaught] Zomslaught unloading...");
	}
	
	public String getActiveWorldName() {
		// Find the world not named "world" and return it
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
