package com.SpectralVulpine.zomslaught.runnables;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class BossSpawnEffects extends BukkitRunnable {
	
	Zomslaught plugin;
	Location target;

	public BossSpawnEffects(Location l) {
		target = l;
	}
	
	@Override
	public void run() {
		// TODO: Add particle effects for extra coolness
		// TODO: Make effects different depending on type of boss spawned
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage("§e[Zomslaught] §2A boss zombie has spawned!");
		}
		new LightningStrike(target, 3).runTaskTimer(plugin, 0, 20);
	}
}
