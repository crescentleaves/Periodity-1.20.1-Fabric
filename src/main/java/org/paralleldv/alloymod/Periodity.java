package org.paralleldv.alloymod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.paralleldv.alloymod.block.ModBlocks;
import org.paralleldv.alloymod.item.ModItemGroups;
import org.paralleldv.alloymod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Periodity implements ModInitializer {
	public static final String MOD_ID = "periodity";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.CARBON_BRICK,8000);
	}
}