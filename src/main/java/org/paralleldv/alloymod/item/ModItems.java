package org.paralleldv.alloymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.paralleldv.alloymod.Periodity;

public class ModItems {
    public static final Item STEEL = registerItem("steel", new Item(new FabricItemSettings()));
    public static final Item CARBON = registerItem("carbon", new Item(new FabricItemSettings()));
    public static final Item MOLTEN_IRON = registerItem("molten-iron", new Item(new FabricItemSettings()));
    public static final Item MOLTEN_COPPER = registerItem("molten-copper", new Item(new FabricItemSettings()));
    public static final Item MOLTEN_GOLD = registerItem("molten-gold", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD = registerItem("rose-gold", new Item(new FabricItemSettings()));

    public static final Item STEEL_NUGGET = registerItem("steel-nugget", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_NUGGET = registerItem("rose-gold-nugget", new Item(new FabricItemSettings()));


    public static final Item STEEL_PICKAXE = registerItem("steel-pickaxe",
            new PickaxeItem(ModToolMaterial.STEEL,4,1.2f, new FabricItemSettings()));
    public static final Item STEEL_AXE = registerItem("steel-axe",
            new AxeItem(ModToolMaterial.STEEL,9,0.9f, new FabricItemSettings()));
    public static final Item STEEL_SWORD = registerItem("steel-sword",
            new SwordItem(ModToolMaterial.STEEL,7,1.6f, new FabricItemSettings()));
    public static final Item STEEL_SHOVEL = registerItem("steel-shovel",
            new ShovelItem(ModToolMaterial.STEEL,5,1f, new FabricItemSettings()));
    public static final Item STEEL_HOE = registerItem("steel-hoe",
            new HoeItem(ModToolMaterial.STEEL,1,3.5f, new FabricItemSettings()));

    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose-gold-pickaxe",
            new PickaxeItem(ModToolMaterial.ROSE_GOLD,3,1.2f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_AXE = registerItem("rose-gold-axe",
            new AxeItem(ModToolMaterial.ROSE_GOLD,8,0.9f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_SWORD = registerItem("rose-gold-sword",
            new SwordItem(ModToolMaterial.ROSE_GOLD,5,1.6f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose-gold-shovel",
            new ShovelItem(ModToolMaterial.ROSE_GOLD,3,1f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_HOE = registerItem("rose-gold-hoe",
            new HoeItem(ModToolMaterial.ROSE_GOLD,1,2f, new FabricItemSettings()));

    private static void addItemstoIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(STEEL);
        entries.add(CARBON);
        entries.add(MOLTEN_IRON);
        entries.add(MOLTEN_COPPER);
        entries.add(MOLTEN_GOLD);
        entries.add(ROSE_GOLD);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Periodity.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Periodity.LOGGER.info("Registering mod items for" + Periodity.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemstoIngredientItemGroup);
    }
}
