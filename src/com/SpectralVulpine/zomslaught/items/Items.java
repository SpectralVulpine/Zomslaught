package com.SpectralVulpine.zomslaught.items;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.SpectralVulpine.zomslaught.Zomslaught;

public class Items {
	
	Zomslaught plugin;
	
	public Items(Zomslaught zom) {
		plugin = zom;
	}
	
	public ItemStack fleshySoul() {
		ItemStack item = new ItemStack(Material.ROTTEN_FLESH);
		String name = "Fleshy Soul";
		ArrayList<String> lore = new ArrayList<String>();
		ItemMeta imeta = item.getItemMeta();
		lore.add("&2FLESHY, YESSS");
		imeta.setDisplayName(name);
		imeta.setLore(lore);
		item.setItemMeta(imeta);
		
		return item;
	}
}
