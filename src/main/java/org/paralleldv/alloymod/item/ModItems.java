package org.paralleldv.alloymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
