package org.paralleldv.alloymod.recipes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import org.paralleldv.alloymod.item.ModItems;
import org.paralleldv.alloymod.model.ToolPatternTypes;
import org.paralleldv.alloymod.model.ToolPatterns;

public class PeriodityToolGenerator {

    private final Map<ItemConvertible, String[]> ROSE_GOLD_TOOLS = new HashMap<>() {
        {
            put(ModItems.ROSE_GOLD_SWORD, ToolPatterns.SWORD);
            put(ModItems.ROSE_GOLD_AXE, ToolPatterns.AXE);
            put(ModItems.ROSE_GOLD_PICKAXE, ToolPatterns.PICKAXE);
            put(ModItems.ROSE_GOLD_SHOVEL, ToolPatterns.SHOVEL);
            put(ModItems.ROSE_GOLD_HOE, ToolPatterns.HOE);
        }
    };

    private final Map<ItemConvertible, String[]> STEEL_TOOLS = new HashMap<>() {
        {
            put(ModItems.STEEL_SWORD, ToolPatterns.SWORD);
            put(ModItems.STEEL_AXE, ToolPatterns.AXE);
            put(ModItems.STEEL_PICKAXE, ToolPatterns.PICKAXE);
            put(ModItems.STEEL_SHOVEL, ToolPatterns.SHOVEL);
            put(ModItems.STEEL_HOE, ToolPatterns.HOE);
        }
    };

    public void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        this.generateToolRecipesForMaterial(exporter, ModItems.STEEL, STEEL_TOOLS);
        this.generateToolRecipesForMaterial(exporter, ModItems.ROSE_GOLD, ROSE_GOLD_TOOLS);
    }

    private void generateToolRecipesForMaterial(Consumer<RecipeJsonProvider> exporter, ItemConvertible material,
            Map<ItemConvertible, String[]> tools) {
        tools.forEach((tool, pattern) -> {
            this.generateToolRecipeForTool(exporter, material, tool, pattern);
        });
    }

    private void generateToolRecipeForTool(Consumer<RecipeJsonProvider> exporter, ItemConvertible material,
            ItemConvertible tool, String[] pattern) {
        ShapedRecipeJsonBuilder
                .create(RecipeCategory.TOOLS, tool)
                .input(ToolPatternTypes.MATERIAL, material)
                .input(ToolPatternTypes.HANDLE, Items.STICK)
                .pattern(pattern[0])
                .pattern(pattern[1])
                .pattern(pattern[2])
                .criterion(FabricRecipeProvider.hasItem(material), FabricRecipeProvider.conditionsFromItem((material)))
                .offerTo(exporter);
    }
}
