package com.SpectralVulpine.zomslaught.runnables;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
/*import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;*/
import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class FrightNight extends BukkitRunnable{
	private Random rng;
	public Zomslaught plugin;
	public boolean frightActive;
	public boolean doubleWhammyActive;
	public String title;
	public String[] frights = {"baby", "double", "invisible", "strength1", "strength2", "swift1", "swift2"};
	public String[] doubleFrights = {"baby", "double", "invisible", "strength2", "swift2"};
	private String[] effects = new String[2];
	
	public FrightNight(Zomslaught zom) {
		frightActive = false;
		doubleWhammyActive = false;
		plugin = zom;
		rng = new Random();
		rng.setSeed(System.currentTimeMillis() + 1);
	}
	
	public void run() {
		// If not already activate, pick a scenario and activate Fright Night
		if (!isActive()) {
			if (rng.nextDouble() <= plugin.config.getDudChance()) {
				setMode("dud");
			} else {
				if (rng.nextDouble() <= plugin.config.getDoubleChance()) {
					doubleWhammy();
				} else {
					setMode(frights[rng.nextInt(frights.length)]);
					setActive(false);
				}
				new Deactivate(this).runTaskLater(plugin, plugin.config.getFrightDuration()*20);
			}
			plugin.titles.warning(getTitle());
			// TODO: Make existing zombies get the Fright Night effects too
			/*List<LivingEntity> entityList = Bukkit.getWorld(plugin.getActiveWorldName()).getLivingEntities();
			switch (getMode()) {
			case "baby":
				for (Entity ent : entityList) {
					if (ent instanceof Zombie) {
						ent.setBaby(true);
					}
				}
			}*/
		}
	}
	
	// TODO: Make custom parameters for command work
	
	public void doubleWhammy() {
		String mode1 = doubleFrights[rng.nextInt(doubleFrights.length)];
		String mode2;
		String msg = "§e[Zomslaught] §4§l§oDOUBLE WHAMMY! §r§6The effects you will be facing are: §r";
		do {
			mode2 = doubleFrights[rng.nextInt(doubleFrights.length)];
		} while (mode1 == mode2);
		effects[0] = mode1;
		effects[1] = mode2;
		setTitle("doubleWhammy");
		msg += plugin.titles.getSubtitle(mode1) + "§r §6and §r" + plugin.titles.getSubtitle(mode2);
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(msg);
		}
		setActive(true);
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setMode(String newMode) {
		effects[0] = newMode;
		setTitle(newMode);
	}
	
	public String getMode() {
		return effects[0];
	}

	public String[] getEffects() {
		return effects;
	}
	
	public void setActive(boolean isDoubleWhammy) {
		frightActive = true;
		doubleWhammyActive = isDoubleWhammy;
	}
	
	public boolean isActive() {
		return frightActive;
	}
	
	public boolean isDoubleWhammy() {
		return doubleWhammyActive;
	}
	
	public void deactivate() {
		frightActive = false;	
		doubleWhammyActive = false;
	}
}

class Deactivate extends BukkitRunnable {
	
	FrightNight fright;
	public Deactivate(FrightNight f) {
		fright = f;
	}
	public void run() {
		fright.deactivate();
	}
}