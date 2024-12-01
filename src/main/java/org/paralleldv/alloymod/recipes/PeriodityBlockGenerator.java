package org.paralleldv.alloymod.recipes;

import java.util.function.Consumer;

import org.paralleldv.alloymod.block.ModBlocks;
import org.paralleldv.alloymod.item.ModItems;

import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

public class PeriodityBlockGenerator {

    /**
     * Mapping for four-item and nine-item recipes. Common example: Gold nuggets <->
     * ingots <-> blocks.
     * Last four booleans determine direction of crafting e.g. if
     * {@link itemToSmall} is set to false,
     * you cannot use the item in a crafting grid to get four/nine of the small item
     * equivalent from it.
     * If no directives are provided for crafting recipe directionality, by default
     * only compacting is enabled.
     * 
     * @param isFourItems If true, assume four items for compacting. Else assume
     *                    nine items for compacting.
     */
    private record BidirectionalItemMapping(boolean isFourItems, ItemConvertible small, ItemConvertible item,
            ItemConvertible block, String materialName) {
    }

    public void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        this.generateMaterialRecipes(exporter, new BidirectionalItemMapping(false, ModItems.ROSE_GOLD_NUGGET,
                ModItems.ROSE_GOLD, ModBlocks.ROSE_GOLD_BLOCK, "rose-gold"));
        this.generateMaterialRecipes(exporter,
                new BidirectionalItemMapping(false, ModItems.STEEL_NUGGET, ModItems.STEEL,
                        ModBlocks.STEEL_BLOCK,
                        "steel"));
    }

    private void generateMaterialRecipes(Consumer<RecipeJsonProvider> exporter,
            BidirectionalItemMapping itemMapping) {

        if (itemMapping.isFourItems()) {
            RecipeProvider.offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, itemMapping.small(),
                    itemMapping.item());
            RecipeProvider.offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                    itemMapping.item(),
                    itemMapping.block());
        } else {
            var material = itemMapping.materialName();
            var block = material + "-block";
            var nugget = material + "-nugget";

            RecipeProvider.offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                    itemMapping.small(),
                    RecipeCategory.MISC, itemMapping.item(), material + "-from-" + nugget, material,
                    nugget + "-from-" + material, material);
            RecipeProvider.offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,
                    itemMapping.item(),
                    RecipeCategory.BUILDING_BLOCKS, itemMapping.block(),
                    block + "-from-" + material, material,
                    material + "-from-" + block, material);
        }
    }
}
