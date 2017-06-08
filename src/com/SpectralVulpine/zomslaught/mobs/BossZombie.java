package com.SpectralVulpine.zomslaught.mobs;

import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;

import net.minecraft.server.v1_12_R1.EntityZombie;

public class BossZombie extends EntityZombie {

	public BossZombie(org.bukkit.World world) {
		super(((CraftWorld)world).getHandle());
	}
}
