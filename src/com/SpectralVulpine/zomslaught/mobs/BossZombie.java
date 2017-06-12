package com.SpectralVulpine.zomslaught.mobs;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntitySpawnEvent;

import com.SpectralVulpine.zomslaught.runnables.BossSpawnEffects;

public interface BossZombie extends Zombie {
	// TODO: Procedurally generated bosses
	// TODO: Various special effects
	
	public default void onSpawn(EntitySpawnEvent e) {
		bossBuff();
		new BossSpawnEffects(this.getLocation()).run();
	}
	
	public default void bossBuff() {
		double buffAmt = 40.0;
		AttributeInstance maxHealth = this.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		maxHealth.setBaseValue(buffAmt);
	}
	
	public default void bossMaxHeal() {
		double currentHealth = this.getHealth();
		currentHealth = this.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
		this.setHealth(currentHealth);
	}
}
