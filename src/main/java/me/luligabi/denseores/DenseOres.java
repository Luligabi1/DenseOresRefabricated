package me.luligabi.denseores;

import me.luligabi.denseores.block.BlockRegistry;
import me.luligabi.denseores.worldgen.ConfiguredFeatureRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class DenseOres implements ModInitializer {

    @Override
    public void onInitialize() {
        BlockRegistry.init();
        ConfiguredFeatureRegistry.init();
    }

    public static final String MOD_ID = "denseores";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(BlockRegistry.DENSE_DIAMOND_ORE))
            .build();

}