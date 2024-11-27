package org.paralleldv.alloymod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.paralleldv.alloymod.Periodity;
import org.paralleldv.alloymod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup PERIODITY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Periodity.MOD_ID, "periodity"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.periodity"))
                    .icon(() -> new ItemStack(ModItems.STEEL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MOLTEN_IRON);
                        entries.add(ModItems.MOLTEN_COPPER);
                        entries.add(ModItems.MOLTEN_GOLD);
                        entries.add(ModItems.CARBON);
                        entries.add(ModItems.STEEL);
                        entries.add(ModItems.ROSE_GOLD);

                        entries.add(ModItems.STEEL_NUGGET);
                        entries.add(ModItems.ROSE_GOLD_NUGGET);

                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.ROSE_GOLD_BLOCK);

                        entries.add(ModItems.STEEL_AXE);
                        entries.add(ModItems.STEEL_PICKAXE);
                        entries.add(ModItems.STEEL_SHOVEL);
                        entries.add(ModItems.STEEL_SWORD);
                        entries.add(ModItems.STEEL_HOE);

                        entries.add(ModItems.ROSE_GOLD_AXE);
                        entries.add(ModItems.ROSE_GOLD_PICKAXE);
                        entries.add(ModItems.ROSE_GOLD_SHOVEL);
                        entries.add(ModItems.ROSE_GOLD_SWORD);
                        entries.add(ModItems.ROSE_GOLD_HOE);


                    }).build());

    public static void registerItemGroups() {
        Periodity.LOGGER.info("Registering item groups for" + Periodity.MOD_ID);
    }
}
