package org.paralleldv.alloymod;

import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import org.paralleldv.alloymod.recipes.*;

public class PeriodityDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();

		pack.addProvider(PeriodityRecipeProvider::new);
	}

	private static class PeriodityRecipeProvider extends FabricRecipeProvider {

		private PeriodityRecipeProvider(FabricDataOutput generator) {
			super(generator);
		}

		@Override
		public void generate(Consumer<RecipeJsonProvider> exporter) {
			new PeriodityBlockGenerator().generateRecipes(exporter);
			new PeriodityToolGenerator().generateRecipes(exporter);
		}
	}
}
