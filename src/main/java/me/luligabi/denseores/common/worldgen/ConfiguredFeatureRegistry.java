package me.luligabi.denseores.common.worldgen;

import me.luligabi.denseores.common.DenseOres;
import me.luligabi.denseores.common.block.BlockRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

public class ConfiguredFeatureRegistry {

    public static void init() {
        registerOverworldFeature(DENSE_COAL_ORE_CONFIGURED_FEATURE, DENSE_COAL_ORE_PLACED_FEATURE, "dense_coal_ore", DenseOres.CONFIG.canGenerateDenseCoal);
        registerOverworldFeature(DENSE_COPPER_ORE_CONFIGURED_FEATURE, DENSE_COPPER_ORE_PLACED_FEATURE, "dense_copper_ore", DenseOres.CONFIG.canGenerateDenseCopper);
        registerOverworldFeature(DENSE_IRON_ORE_CONFIGURED_FEATURE, DENSE_IRON_ORE_PLACED_FEATURE, "dense_iron_ore", DenseOres.CONFIG.canGenerateDenseIron);
        registerOverworldFeature(DENSE_GOLD_ORE_CONFIGURED_FEATURE, DENSE_GOLD_ORE_PLACED_FEATURE, "dense_gold_ore", DenseOres.CONFIG.canGenerateDenseGold);
        registerOverworldFeature(DENSE_REDSTONE_ORE_CONFIGURED_FEATURE, DENSE_REDSTONE_ORE_PLACED_FEATURE, "dense_redstone_ore", DenseOres.CONFIG.canGenerateDenseRedstone);
        registerOverworldFeature(DENSE_LAPIS_ORE_CONFIGURED_FEATURE, DENSE_LAPIS_ORE_PLACED_FEATURE, "dense_lapis_ore", DenseOres.CONFIG.canGenerateDenseLapis);
        registerOverworldFeature(DENSE_DIAMOND_ORE_CONFIGURED_FEATURE, DENSE_DIAMOND_ORE_PLACED_FEATURE, "dense_diamond_ore", DenseOres.CONFIG.canGenerateDenseDiamond);
        registerOverworldFeature(DENSE_EMERALD_ORE_CONFIGURED_FEATURE, DENSE_EMERALD_ORE_PLACED_FEATURE, "dense_emerald_ore", DenseOres.CONFIG.canGenerateDenseEmerald);

        // Deepslate variants; Coal, Copper and Emerald deepslate ores don't generate at normal circumstances.
        registerOverworldFeature(DENSE_DEEPSLATE_IRON_ORE_CONFIGURED_FEATURE, DENSE_DEEPSLATE_IRON_ORE_PLACED_FEATURE, "dense_deepslate_iron_ore", DenseOres.CONFIG.canGenerateDenseIron);
        registerOverworldFeature(DENSE_DEEPSLATE_GOLD_ORE_CONFIGURED_FEATURE, DENSE_DEEPSLATE_GOLD_ORE_PLACED_FEATURE, "dense_deepslate_gold_ore", DenseOres.CONFIG.canGenerateDenseGold);
        registerOverworldFeature(DENSE_DEEPSLATE_REDSTONE_ORE_CONFIGURED_FEATURE, DENSE_DEEPSLATE_REDSTONE_ORE_PLACED_FEATURE, "dense_deepslate_redstone_ore", DenseOres.CONFIG.canGenerateDenseRedstone);
        registerOverworldFeature(DENSE_DEEPSLATE_LAPIS_ORE_CONFIGURED_FEATURE, DENSE_DEEPSLATE_LAPIS_ORE_PLACED_FEATURE, "dense_deepslate_lapis_ore", DenseOres.CONFIG.canGenerateDenseLapis);
        registerOverworldFeature(DENSE_DEEPSLATE_DIAMOND_ORE_CONFIGURED_FEATURE, DENSE_DEEPSLATE_DIAMOND_ORE_PLACED_FEATURE, "dense_deepslate_diamond_ore", DenseOres.CONFIG.canGenerateDenseDiamond);

        // Nether Ores
        registerNetherFeature(DENSE_NETHER_QUARTZ_ORE_CONFIGURED_FEATURE, DENSE_NETHER_QUARTZ_ORE_PLACED_FEATURE, "dense_nether_quartz_ore", DenseOres.CONFIG.canGenerateDenseNetherQuartz);
        registerNetherFeature(DENSE_NETHER_GOLD_ORE_CONFIGURED_FEATURE, DENSE_NETHER_GOLD_ORE_PLACED_FEATURE, "dense_nether_gold_ore", DenseOres.CONFIG.canGenerateDenseNetherGold);
        registerNetherFeature(DENSE_ANCIENT_DEBRIS_CONFIGURED_FEATURE, DENSE_ANCIENT_DEBRIS_PLACED_FEATURE, "dense_ancient_debris", DenseOres.CONFIG.canGenerateDenseAncientDebris);
    }

    // Dense Coal
    private static final ConfiguredFeature<?, ?> DENSE_COAL_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.COAL_ORE),
                    BlockRegistry.DENSE_COAL_ORE.getDefaultState(),
                    DenseOres.CONFIG.coalVeinSize));

    private static final PlacedFeature DENSE_COAL_ORE_PLACED_FEATURE = DENSE_COAL_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.coalChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.coalMinHeight), YOffset.fixed(DenseOres.CONFIG.coalMaxHeight)));

    // Dense Copper
    private static final ConfiguredFeature<?, ?> DENSE_COPPER_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.COPPER_ORE),
                    BlockRegistry.DENSE_COPPER_ORE.getDefaultState(),
                    DenseOres.CONFIG.copperVeinSize));

    private static final PlacedFeature DENSE_COPPER_ORE_PLACED_FEATURE = DENSE_COPPER_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.copperChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.copperMinHeight), YOffset.fixed(DenseOres.CONFIG.copperMaxHeight)));

    // Dense Iron
    private static final ConfiguredFeature<?, ?> DENSE_IRON_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.IRON_ORE),
                    BlockRegistry.DENSE_IRON_ORE.getDefaultState(),
                    DenseOres.CONFIG.ironVeinSize));

    private static final PlacedFeature DENSE_IRON_ORE_PLACED_FEATURE = DENSE_IRON_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.ironChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.fixed(DenseOres.CONFIG.ironMinHeight), YOffset.fixed(DenseOres.CONFIG.ironMaxHeight)));

    // Dense Gold
    private static final ConfiguredFeature<?, ?> DENSE_GOLD_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.GOLD_ORE),
                    BlockRegistry.DENSE_GOLD_ORE.getDefaultState(),
                    DenseOres.CONFIG.goldVeinSize));

    private static final PlacedFeature DENSE_GOLD_ORE_PLACED_FEATURE = DENSE_GOLD_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.goldChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.goldMinHeight), YOffset.fixed(DenseOres.CONFIG.goldMaxHeight)));

    // Dense Redstone
    private static final ConfiguredFeature<?, ?> DENSE_REDSTONE_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.REDSTONE_ORE),
                    BlockRegistry.DENSE_REDSTONE_ORE.getDefaultState(),
                    DenseOres.CONFIG.redstoneVeinSize));

    private static final PlacedFeature DENSE_REDSTONE_ORE_PLACED_FEATURE = DENSE_REDSTONE_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.redstoneChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.redstoneMinHeight), YOffset.fixed(DenseOres.CONFIG.redstoneMaxHeight)));

    // Dense Lapis
    private static final ConfiguredFeature<?, ?> DENSE_LAPIS_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.LAPIS_ORE),
                    BlockRegistry.DENSE_LAPIS_ORE.getDefaultState(),
                    DenseOres.CONFIG.lapisVeinSize));

    private static final PlacedFeature DENSE_LAPIS_ORE_PLACED_FEATURE = DENSE_LAPIS_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.lapisChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.lapisMinHeight), YOffset.fixed(DenseOres.CONFIG.lapisMaxHeight)));

    // Dense Diamond
    private static final ConfiguredFeature<?, ?> DENSE_DIAMOND_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DIAMOND_ORE),
                    BlockRegistry.DENSE_DIAMOND_ORE.getDefaultState(),
                    DenseOres.CONFIG.diamondVeinSize));

    private static final PlacedFeature DENSE_DIAMOND_ORE_PLACED_FEATURE = DENSE_DIAMOND_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.diamondChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(DenseOres.CONFIG.diamondMinHeight), YOffset.aboveBottom(DenseOres.CONFIG.diamondMaxHeight)));

    // Dense Emerald
    private static final ConfiguredFeature<?, ?> DENSE_EMERALD_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.EMERALD_ORE),
                    BlockRegistry.DENSE_EMERALD_ORE.getDefaultState(),
                    DenseOres.CONFIG.emeraldVeinSize));

    private static final PlacedFeature DENSE_EMERALD_ORE_PLACED_FEATURE = DENSE_EMERALD_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.emeraldChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.emeraldMinHeight), YOffset.fixed(DenseOres.CONFIG.emeraldMaxHeight)));

    // Dense Deepslate Iron
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_IRON_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_IRON_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_IRON_ORE.getDefaultState(),
                    DenseOres.CONFIG.ironVeinSize));

    private static final PlacedFeature DENSE_DEEPSLATE_IRON_ORE_PLACED_FEATURE = DENSE_DEEPSLATE_IRON_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.ironChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight)));

    // Dense Deepslate Gold
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_GOLD_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_GOLD_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_GOLD_ORE.getDefaultState(),
                    DenseOres.CONFIG.goldVeinSize));

    private static final PlacedFeature DENSE_DEEPSLATE_GOLD_ORE_PLACED_FEATURE = DENSE_DEEPSLATE_GOLD_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.goldChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight)));

    // Dense Deepslate Redstone
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_REDSTONE_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_REDSTONE_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_REDSTONE_ORE.getDefaultState(),
                    DenseOres.CONFIG.redstoneVeinSize));

    private static final PlacedFeature DENSE_DEEPSLATE_REDSTONE_ORE_PLACED_FEATURE = DENSE_DEEPSLATE_REDSTONE_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.redstoneChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight)));

    // Dense Deepslate Lapis
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_LAPIS_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_LAPIS_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_LAPIS_ORE.getDefaultState(),
                    DenseOres.CONFIG.lapisVeinSize));

    private static final PlacedFeature DENSE_DEEPSLATE_LAPIS_ORE_PLACED_FEATURE = DENSE_DEEPSLATE_LAPIS_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.lapisChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight)));

    // Dense Deepslate Diamond
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_DIAMOND_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_DIAMOND_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_DIAMOND_ORE.getDefaultState(),
                    DenseOres.CONFIG.diamondVeinSize));

    private static final PlacedFeature DENSE_DEEPSLATE_DIAMOND_ORE_PLACED_FEATURE = DENSE_DEEPSLATE_DIAMOND_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.diamondChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight)));

    // Dense Nether Quartz
    private static final ConfiguredFeature<?, ?> DENSE_NETHER_QUARTZ_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.NETHER_QUARTZ_ORE),
                    BlockRegistry.DENSE_NETHER_QUARTZ_ORE.getDefaultState(),
                    DenseOres.CONFIG.netherQuartzVeinSize));

    private static final PlacedFeature DENSE_NETHER_QUARTZ_ORE_PLACED_FEATURE = DENSE_NETHER_QUARTZ_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.netherQuartzChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(10), YOffset.belowTop(10)));

    // Dense Nether Gold
    private static final ConfiguredFeature<?, ?> DENSE_NETHER_GOLD_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.NETHER_GOLD_ORE),
                    BlockRegistry.DENSE_NETHER_GOLD_ORE.getDefaultState(),
                    DenseOres.CONFIG.netherGoldVeinSize));

    private static final PlacedFeature DENSE_NETHER_GOLD_ORE_PLACED_FEATURE = DENSE_NETHER_GOLD_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(DenseOres.CONFIG.netherGoldChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(10), YOffset.belowTop(10)));

    // Dense Ancient Debris
    private static final ConfiguredFeature<?, ?> DENSE_ANCIENT_DEBRIS_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.ANCIENT_DEBRIS),
                    BlockRegistry.DENSE_ANCIENT_DEBRIS.getDefaultState(),
                    DenseOres.CONFIG.ancientDebrisVeinSize, 1.0F));

    private static final PlacedFeature DENSE_ANCIENT_DEBRIS_PLACED_FEATURE = DENSE_ANCIENT_DEBRIS_CONFIGURED_FEATURE.withPlacement(
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.fixed(DenseOres.CONFIG.ancientDebrisMinHeight), YOffset.fixed(DenseOres.CONFIG.ancientDebrisMaxHeight)));


    private static void registerOverworldFeature(ConfiguredFeature<?, ?> configuredFeature, PlacedFeature placedFeature, String identifier, boolean enabled) {
        if(!enabled) return;
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(DenseOres.MOD_ID, identifier), configuredFeature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(DenseOres.MOD_ID, identifier),
                placedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_DECORATION,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(DenseOres.MOD_ID, identifier)));
    }

    private static void registerNetherFeature(ConfiguredFeature<?, ?> configuredFeature, PlacedFeature placedFeature, String identifier, boolean enabled) {
        if(!enabled) return;
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(DenseOres.MOD_ID, identifier), configuredFeature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(DenseOres.MOD_ID, identifier),
                placedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_DECORATION,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(DenseOres.MOD_ID, identifier)));
    }

}