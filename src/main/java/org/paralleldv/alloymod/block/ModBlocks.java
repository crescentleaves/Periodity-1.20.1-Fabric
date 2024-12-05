package org.paralleldv.alloymod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.paralleldv.alloymod.Periodity;

public class ModBlocks {
    public static final Block STEEL_BLOCK = registerBlock("steel-block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(7.0F, 8.0F)));
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose-gold-block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).strength(5.0F, 7.0F)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Periodity.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Periodity.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Periodity.LOGGER.info("Registering mod blocks for " + Periodity.MOD_ID);
    }
}
