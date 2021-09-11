package me.luligabi.denseores;

import me.luligabi.denseores.worldgen.ConfiguredFeatureRegistry;
import net.fabricmc.api.ModInitializer;

public class DenseOres implements ModInitializer {

    @Override
    public void onInitialize() {
        ConfiguredFeatureRegistry.init();
    }

    public static final String MOD_ID = "denseores";

}