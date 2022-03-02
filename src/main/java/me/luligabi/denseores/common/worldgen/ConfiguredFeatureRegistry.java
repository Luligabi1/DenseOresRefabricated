package me.luligabi.denseores.common.worldgen;

import me.luligabi.denseores.common.DenseOres;
import me.luligabi.denseores.common.block.BlockRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

@SuppressWarnings("unused")
public class ConfiguredFeatureRegistry {

    public static void init() {
        registerOverworldFeature(DENSE_COAL_ID, DenseOres.CONFIG.canGenerateDenseCoal);
        registerOverworldFeature(DENSE_COPPER_ID, DenseOres.CONFIG.canGenerateDenseCopper);
        registerOverworldFeature(DENSE_IRON_ID, DenseOres.CONFIG.canGenerateDenseIron);
        registerOverworldFeature(DENSE_GOLD_ID, DenseOres.CONFIG.canGenerateDenseGold);
        registerOverworldFeature(DENSE_REDSTONE_ID, DenseOres.CONFIG.canGenerateDenseRedstone);
        registerOverworldFeature(DENSE_LAPIS_ID, DenseOres.CONFIG.canGenerateDenseLapis);
        registerOverworldFeature(DENSE_DIAMOND_ID, DenseOres.CONFIG.canGenerateDenseDiamond);
        registerOverworldFeature(DENSE_EMERALD_ID, DenseOres.CONFIG.canGenerateDenseEmerald);

        // Deepslate variants; Coal, Copper and Emerald deepslate ores don't generate at normal circumstances.
        registerOverworldFeature(DENSE_DEEPSLATE_COAL_ID, DenseOres.CONFIG.canGenerateDenseDeepslateCoal);
        registerOverworldFeature(DENSE_DEEPSLATE_COPPER_ID, DenseOres.CONFIG.canGenerateDenseDeepslateCopper);
        registerOverworldFeature(DENSE_DEEPSLATE_IRON_ID, DenseOres.CONFIG.canGenerateDenseIron);
        registerOverworldFeature(DENSE_DEEPSLATE_GOLD_ID, DenseOres.CONFIG.canGenerateDenseGold);
        registerOverworldFeature(DENSE_DEEPSLATE_REDSTONE_ID, DenseOres.CONFIG.canGenerateDenseRedstone);
        registerOverworldFeature(DENSE_DEEPSLATE_LAPIS_ID, DenseOres.CONFIG.canGenerateDenseLapis);
        registerOverworldFeature(DENSE_DEEPSLATE_DIAMOND_ID, DenseOres.CONFIG.canGenerateDenseDiamond);
        registerOverworldFeature(DENSE_DEEPSLATE_EMERALD_ID, DenseOres.CONFIG.canGenerateDenseDeepslateEmerald);

        // Nether Ores
        registerNetherFeature(DENSE_NETHER_QUARTZ_ID, DenseOres.CONFIG.canGenerateDenseNetherQuartz);
        registerNetherFeature(DENSE_NETHER_GOLD_ID, DenseOres.CONFIG.canGenerateDenseNetherGold);
        registerNetherFeature(DENSE_ANCIENT_DEBRIS_ID, DenseOres.CONFIG.canGenerateDenseAncientDebris);
    }

    // Dense Coal
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_COAL_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_COAL_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.COAL_ORE),
                    BlockRegistry.DENSE_COAL_ORE.getDefaultState(),
                    DenseOres.CONFIG.coalVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_COAL_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_COAL_ID, DENSE_COAL_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.coalChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.coalMinHeight), YOffset.fixed(DenseOres.CONFIG.coalMaxHeight))
    );

    private static final String DENSE_COAL_ID = "dense_coal_ore";

    // Dense Copper
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_COPPER_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_COPPER_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.COPPER_ORE),
                    BlockRegistry.DENSE_COPPER_ORE.getDefaultState(),
                    DenseOres.CONFIG.copperVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_COPPER_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_COPPER_ID, DENSE_COPPER_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.copperChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.copperMinHeight), YOffset.fixed(DenseOres.CONFIG.copperMaxHeight))
    );

    private static final String DENSE_COPPER_ID = "dense_copper_ore";

    // Dense Iron
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_IRON_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_IRON_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.IRON_ORE),
                    BlockRegistry.DENSE_IRON_ORE.getDefaultState(),
                    DenseOres.CONFIG.ironVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_IRON_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_IRON_ID, DENSE_IRON_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.ironChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.fixed(DenseOres.CONFIG.ironMinHeight), YOffset.fixed(DenseOres.CONFIG.ironMaxHeight))
    );

    private static final String DENSE_IRON_ID = "dense_iron_ore";

    // Dense Gold
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_GOLD_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_GOLD_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.GOLD_ORE),
                    BlockRegistry.DENSE_GOLD_ORE.getDefaultState(),
                    DenseOres.CONFIG.goldVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_GOLD_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_GOLD_ID, DENSE_GOLD_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.goldChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.goldMinHeight), YOffset.fixed(DenseOres.CONFIG.goldMaxHeight))
    );

    private static final String DENSE_GOLD_ID = "dense_gold_ore";

    // Dense Redstone
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_REDSTONE_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_REDSTONE_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.REDSTONE_ORE),
                    BlockRegistry.DENSE_REDSTONE_ORE.getDefaultState(),
                    DenseOres.CONFIG.redstoneVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_REDSTONE_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_REDSTONE_ID, DENSE_REDSTONE_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.redstoneChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.redstoneMinHeight), YOffset.fixed(DenseOres.CONFIG.redstoneMaxHeight))
    );

    private static final String DENSE_REDSTONE_ID = "dense_redstone_ore";

    // Dense Lapis
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_LAPIS_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_LAPIS_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.LAPIS_ORE),
                    BlockRegistry.DENSE_LAPIS_ORE.getDefaultState(),
                    DenseOres.CONFIG.lapisVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_LAPIS_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_LAPIS_ID, DENSE_LAPIS_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.lapisChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.lapisMinHeight), YOffset.fixed(DenseOres.CONFIG.lapisMaxHeight))
    );

    private static final String DENSE_LAPIS_ID = "dense_lapis_ore";

    // Dense Diamond
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_DIAMOND_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_DIAMOND_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DIAMOND_ORE),
                    BlockRegistry.DENSE_DIAMOND_ORE.getDefaultState(),
                    DenseOres.CONFIG.diamondVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_DIAMOND_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_DIAMOND_ID, DENSE_DIAMOND_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.diamondChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(DenseOres.CONFIG.diamondMinHeight), YOffset.aboveBottom(DenseOres.CONFIG.diamondMaxHeight))
    );

    private static final String DENSE_DIAMOND_ID = "dense_diamond_ore";

    // Dense Emerald
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_EMERALD_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_EMERALD_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.EMERALD_ORE),
                    BlockRegistry.DENSE_EMERALD_ORE.getDefaultState(),
                    DenseOres.CONFIG.emeraldVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_EMERALD_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_EMERALD_ID, DENSE_EMERALD_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.emeraldChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(DenseOres.CONFIG.emeraldMinHeight), YOffset.fixed(DenseOres.CONFIG.emeraldMaxHeight))
    );

    private static final String DENSE_EMERALD_ID = "dense_emerald_ore";

    // Dense Deepslate Coal
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_DEEPSLATE_COAL_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_COAL_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_COAL_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_COAL_ORE.getDefaultState(),
                    DenseOres.CONFIG.coalVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_DEEPSLATE_COAL_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_COAL_ID, DENSE_DEEPSLATE_COAL_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.coalChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
    );

    private static final String DENSE_DEEPSLATE_COAL_ID = "dense_deepslate_coal_ore";

    // Dense Deepslate Copper
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_DEEPSLATE_COPPER_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_COPPER_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_COPPER_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_COPPER_ORE.getDefaultState(),
                    DenseOres.CONFIG.copperVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_DEEPSLATE_COPPER_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_COPPER_ID, DENSE_DEEPSLATE_COPPER_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.copperChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
    );

    private static final String DENSE_DEEPSLATE_COPPER_ID = "dense_deepslate_copper_ore";

    // Dense Deepslate Iron
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_DEEPSLATE_IRON_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_IRON_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_IRON_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_IRON_ORE.getDefaultState(),
                    DenseOres.CONFIG.ironVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_DEEPSLATE_IRON_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_IRON_ID, DENSE_DEEPSLATE_IRON_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.ironChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
    );

    private static final String DENSE_DEEPSLATE_IRON_ID = "dense_deepslate_iron_ore";

    // Dense Deepslate Gold
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_DEEPSLATE_GOLD_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_GOLD_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_GOLD_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_GOLD_ORE.getDefaultState(),
                    DenseOres.CONFIG.goldVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_DEEPSLATE_GOLD_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_GOLD_ID, DENSE_DEEPSLATE_GOLD_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.goldChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
    );

    private static final String DENSE_DEEPSLATE_GOLD_ID = "dense_deepslate_gold_ore";

    // Dense Deepslate Redstone
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_DEEPSLATE_REDSTONE_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_REDSTONE_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_REDSTONE_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_REDSTONE_ORE.getDefaultState(),
                    DenseOres.CONFIG.redstoneVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_DEEPSLATE_REDSTONE_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_REDSTONE_ID, DENSE_DEEPSLATE_REDSTONE_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.redstoneChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
    );

    private static final String DENSE_DEEPSLATE_REDSTONE_ID = "dense_deepslate_redstone_ore";

    // Dense Deepslate Lapis
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_DEEPSLATE_LAPIS_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_LAPIS_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_LAPIS_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_LAPIS_ORE.getDefaultState(),
                    DenseOres.CONFIG.lapisVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_DEEPSLATE_LAPIS_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_LAPIS_ID, DENSE_DEEPSLATE_LAPIS_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.lapisChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
    );

    private static final String DENSE_DEEPSLATE_LAPIS_ID = "dense_deepslate_lapis_ore";

    // Dense Deepslate Diamond
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_DEEPSLATE_DIAMOND_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_DIAMOND_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_DIAMOND_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_DIAMOND_ORE.getDefaultState(),
                    DenseOres.CONFIG.diamondVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_DEEPSLATE_DIAMOND_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_DIAMOND_ID, DENSE_DEEPSLATE_DIAMOND_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.diamondChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
    );

    private static final String DENSE_DEEPSLATE_DIAMOND_ID = "dense_deepslate_diamond_ore";

    // Dense Deepslate Emerald
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_DEEPSLATE_EMERALD_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_EMERALD_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_EMERALD_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_EMERALD_ORE.getDefaultState(),
                    DenseOres.CONFIG.emeraldVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_DEEPSLATE_EMERALD_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_DEEPSLATE_EMERALD_ID, DENSE_DEEPSLATE_EMERALD_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.emeraldChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
    );

    private static final String DENSE_DEEPSLATE_EMERALD_ID = "dense_deepslate_emerald_ore";

    // Dense Nether Quartz
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_NETHER_QUARTZ_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_NETHER_QUARTZ_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.NETHER_QUARTZ_ORE),
                    BlockRegistry.DENSE_NETHER_QUARTZ_ORE.getDefaultState(),
                    DenseOres.CONFIG.netherQuartzVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_NETHER_QUARTZ_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_NETHER_QUARTZ_ID, DENSE_NETHER_QUARTZ_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.netherQuartzChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(10), YOffset.belowTop(10))
    );

    private static final String DENSE_NETHER_QUARTZ_ID = "dense_nether_quartz_ore";

    // Dense Nether Gold
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_NETHER_GOLD_ORE_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_NETHER_GOLD_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.NETHER_GOLD_ORE),
                    BlockRegistry.DENSE_NETHER_GOLD_ORE.getDefaultState(),
                    DenseOres.CONFIG.netherGoldVeinSize)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_NETHER_GOLD_ORE_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_NETHER_GOLD_ID, DENSE_NETHER_GOLD_ORE_CONFIGURED_FEATURE,
            CountPlacementModifier.of(DenseOres.CONFIG.netherGoldChunkOdds),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(10), YOffset.belowTop(10))
    );

    private static final String DENSE_NETHER_GOLD_ID = "dense_nether_gold_ore";

    // Dense Ancient Debris
    private static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DENSE_ANCIENT_DEBRIS_CONFIGURED_FEATURE = ConfiguredFeatures.register(ConfiguredFeatureRegistry.DENSE_ANCIENT_DEBRIS_ID, Feature.ORE,
            new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.ANCIENT_DEBRIS),
                    BlockRegistry.DENSE_ANCIENT_DEBRIS.getDefaultState(),
                    DenseOres.CONFIG.ancientDebrisVeinSize, 1.0F)
    );

    private static final RegistryEntry<PlacedFeature> DENSE_ANCIENT_DEBRIS_PLACED_FEATURE = PlacedFeatures.register(ConfiguredFeatureRegistry.DENSE_ANCIENT_DEBRIS_ID, DENSE_ANCIENT_DEBRIS_CONFIGURED_FEATURE,
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.fixed(DenseOres.CONFIG.ancientDebrisMinHeight), YOffset.fixed(DenseOres.CONFIG.ancientDebrisMaxHeight))
    );

    private static final String DENSE_ANCIENT_DEBRIS_ID = "dense_ancient_debris";


    private static void registerOverworldFeature(String identifier, boolean enabled) {
        if(!enabled) return;
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_DECORATION,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(identifier))); // At the moment, feature register is done on the 'minecraft' namespace; if this changes on future versions, make sure to include the appropriate namespace here!
    }

    private static void registerNetherFeature(String identifier, boolean enabled) {
        if(!enabled) return;
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_DECORATION,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(identifier)));
    }

}