package me.luligabi.denseores.common.worldgen;

import me.luligabi.denseores.DenseOres;
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
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class ConfiguredFeatureRegistry {

    public static void init() {
        registerOverworldFeature(DENSE_COAL_KEY, DENSE_COAL_ORE, DenseOres.CONFIG.canGenerateDenseCoal);
        registerOverworldFeature(DENSE_COPPER_KEY, DENSE_COPPER_ORE, DenseOres.CONFIG.canGenerateDenseCopper);
        registerOverworldFeature(DENSE_IRON_KEY, DENSE_IRON_ORE, DenseOres.CONFIG.canGenerateDenseIron);
        registerOverworldFeature(DENSE_GOLD_KEY, DENSE_GOLD_ORE, DenseOres.CONFIG.canGenerateDenseGold);
        registerOverworldFeature(DENSE_REDSTONE_KEY, DENSE_REDSTONE_ORE, DenseOres.CONFIG.canGenerateDenseRedstone);
        registerOverworldFeature(DENSE_LAPIS_KEY, DENSE_LAPIS_ORE, DenseOres.CONFIG.canGenerateDenseLapis);
        registerOverworldFeature(DENSE_DIAMOND_KEY, DENSE_DIAMOND_ORE,DenseOres.CONFIG.canGenerateDenseDiamond);
        registerOverworldFeature(DENSE_EMERALD_KEY, DENSE_EMERALD_ORE, DenseOres.CONFIG.canGenerateDenseEmerald);

        // Deepslate variants; Coal, Copper and Emerald deepslate ores don't generate at normal circumstances.
        registerOverworldFeature(DENSE_DEEPSLATE_IRON_KEY, DENSE_DEEPSLATE_IRON_ORE, DenseOres.CONFIG.canGenerateDenseIron);
        registerOverworldFeature(DENSE_DEEPSLATE_GOLD_KEY, DENSE_DEEPSLATE_GOLD_ORE, DenseOres.CONFIG.canGenerateDenseGold);
        registerOverworldFeature(DENSE_DEEPSLATE_REDSTONE_KEY, DENSE_DEEPSLATE_REDSTONE_ORE, DenseOres.CONFIG.canGenerateDenseRedstone);
        registerOverworldFeature(DENSE_DEEPSLATE_LAPIS_KEY, DENSE_DEEPSLATE_LAPIS_ORE, DenseOres.CONFIG.canGenerateDenseLapis);
        registerOverworldFeature(DENSE_DEEPSLATE_DIAMOND_KEY, DENSE_DEEPSLATE_DIAMOND_ORE, DenseOres.CONFIG.canGenerateDenseDiamond);

        // Nether Ores
        registerNetherFeature(DENSE_NETHER_QUARTZ_KEY, DENSE_NETHER_QUARTZ_ORE, DenseOres.CONFIG.canGenerateDenseNetherQuartz);
        registerNetherFeature(DENSE_NETHER_GOLD_KEY, DENSE_NETHER_GOLD_ORE, DenseOres.CONFIG.canGenerateDenseNetherGold);
        registerNetherFeature(DENSE_ANCIENT_DEBRIS_KEY, DENSE_ANCIENT_DEBRIS, DenseOres.CONFIG.canGenerateDenseAncientDebris);
    }

    // Dense Coal
    private static final ConfiguredFeature<?, ?> DENSE_COAL_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.COAL_ORE),
                    BlockRegistry.DENSE_COAL_ORE.getDefaultState(),
                    DenseOres.CONFIG.coalVeinSize))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.fixed(DenseOres.CONFIG.coalMinHeight), YOffset.fixed(DenseOres.CONFIG.coalMaxHeight))))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.coalChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_COAL_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_coal_ore"));

    // Dense Copper
    private static final ConfiguredFeature<?, ?> DENSE_COPPER_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.COPPER_ORE),
                    BlockRegistry.DENSE_COPPER_ORE.getDefaultState(),
                    DenseOres.CONFIG.copperVeinSize))
            .triangleRange(YOffset.fixed(DenseOres.CONFIG.copperMinHeight), YOffset.fixed(DenseOres.CONFIG.copperMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.copperChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_COPPER_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_copper_ore"));

    // Dense Iron
    private static final ConfiguredFeature<?, ?> DENSE_IRON_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.IRON_ORE),
                    BlockRegistry.DENSE_IRON_ORE.getDefaultState(),
                    DenseOres.CONFIG.ironVeinSize))
            .uniformRange(YOffset.fixed(DenseOres.CONFIG.ironMinHeight), YOffset.fixed(DenseOres.CONFIG.ironMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.ironChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_IRON_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_iron_ore"));

    // Dense Gold
    private static final ConfiguredFeature<?, ?> DENSE_GOLD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.GOLD_ORE),
                    BlockRegistry.DENSE_GOLD_ORE.getDefaultState(),
                    DenseOres.CONFIG.goldVeinSize))
            .uniformRange(YOffset.fixed(DenseOres.CONFIG.goldMinHeight), YOffset.fixed(DenseOres.CONFIG.goldMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.goldChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_GOLD_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_gold_ore"));

    // Dense Redstone
    private static final ConfiguredFeature<?, ?> DENSE_REDSTONE_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.REDSTONE_ORE),
                    BlockRegistry.DENSE_REDSTONE_ORE.getDefaultState(),
                    DenseOres.CONFIG.redstoneVeinSize))
            .uniformRange(YOffset.fixed(DenseOres.CONFIG.redstoneMinHeight), YOffset.fixed(DenseOres.CONFIG.redstoneMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.redstoneChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_REDSTONE_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_redstone_ore"));

    // Dense Lapis
    private static final ConfiguredFeature<?, ?> DENSE_LAPIS_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.LAPIS_ORE),
                    BlockRegistry.DENSE_LAPIS_ORE.getDefaultState(),
                    DenseOres.CONFIG.lapisVeinSize))
            .triangleRange(YOffset.fixed(DenseOres.CONFIG.lapisMinHeight), YOffset.fixed(DenseOres.CONFIG.lapisMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.lapisChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_LAPIS_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_lapis_ore"));

    // Dense Diamond
    private static final ConfiguredFeature<?, ?> DENSE_DIAMOND_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DIAMOND_ORE),
                    BlockRegistry.DENSE_DIAMOND_ORE.getDefaultState(),
                    DenseOres.CONFIG.diamondVeinSize))
            .uniformRange(YOffset.fixed(DenseOres.CONFIG.diamondMinHeight), YOffset.fixed(DenseOres.CONFIG.diamondMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.diamondChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DIAMOND_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_diamond_ore"));

    // Dense Emerald
    private static final ConfiguredFeature<?, ?> DENSE_EMERALD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.EMERALD_ORE),
                    BlockRegistry.DENSE_EMERALD_ORE.getDefaultState(),
                    DenseOres.CONFIG.emeraldVeinSize))
            .uniformRange(YOffset.fixed(DenseOres.CONFIG.emeraldMinHeight), YOffset.fixed(DenseOres.CONFIG.emeraldMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.emeraldChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_EMERALD_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_emerald_ore"));


    // Dense Deepslate Iron
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_IRON_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_IRON_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_IRON_ORE.getDefaultState(),
                    DenseOres.CONFIG.ironVeinSize))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.ironChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_IRON_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_iron_ore"));

    // Dense Deepslate Gold
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_GOLD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_GOLD_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_GOLD_ORE.getDefaultState(),
                    DenseOres.CONFIG.goldVeinSize))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.goldChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_GOLD_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_gold_ore"));

    // Dense Deepslate Redstone
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_REDSTONE_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_REDSTONE_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_REDSTONE_ORE.getDefaultState(),
                    DenseOres.CONFIG.redstoneVeinSize))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.redstoneChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_REDSTONE_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_redstone_ore"));

    // Dense Deepslate Lapis
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_LAPIS_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_LAPIS_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_LAPIS_ORE.getDefaultState(),
                    DenseOres.CONFIG.lapisVeinSize))
            .triangleRange(YOffset.fixed(0), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.lapisChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_LAPIS_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_lapis_ore"));

    // Dense Deepslate Diamond
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_DIAMOND_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_DIAMOND_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_DIAMOND_ORE.getDefaultState(),
                    DenseOres.CONFIG.diamondVeinSize))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(DenseOres.CONFIG.deepslateMaxHeight))
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.diamondChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_DIAMOND_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_diamond_ore"));


    // Dense Nether Quartz
    private static final ConfiguredFeature<?, ?> DENSE_NETHER_QUARTZ_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.NETHER_QUARTZ_ORE),
                    BlockRegistry.DENSE_NETHER_QUARTZ_ORE.getDefaultState(),
                    DenseOres.CONFIG.netherQuartzVeinSize))
            .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP_OFFSET_10)
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.netherQuartzChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_NETHER_QUARTZ_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_nether_quartz_ore"));

    // Dense Nether Gold
    private static final ConfiguredFeature<?, ?> DENSE_NETHER_GOLD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.NETHER_GOLD_ORE),
                    BlockRegistry.DENSE_NETHER_GOLD_ORE.getDefaultState(),
                    DenseOres.CONFIG.netherGoldVeinSize))
            .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP_OFFSET_10)
            .spreadHorizontally()
            .repeat(DenseOres.CONFIG.netherGoldChunkOdds);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_NETHER_GOLD_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_nether_gold_ore"));

    // Dense Ancient Debris
    private static final ConfiguredFeature<?, ?> DENSE_ANCIENT_DEBRIS = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.ANCIENT_DEBRIS),
                    BlockRegistry.DENSE_ANCIENT_DEBRIS.getDefaultState(),
                    DenseOres.CONFIG.ancientDebrisVeinSize, 1.0F))
            .triangleRange(YOffset.fixed(DenseOres.CONFIG.ancientDebrisMinHeight), YOffset.fixed(DenseOres.CONFIG.ancientDebrisMaxHeight))
            .spreadHorizontally();

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_ANCIENT_DEBRIS_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_ancient_debris"));

    private static void registerOverworldFeature(RegistryKey<ConfiguredFeature<?, ?>> registryKey, ConfiguredFeature<?, ?> configuredFeature, boolean enabled) {
        if(!enabled) return;
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, registryKey.getValue(), configuredFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_DECORATION, registryKey);
    }

    private static void registerNetherFeature(RegistryKey<ConfiguredFeature<?, ?>> registryKey, ConfiguredFeature<?, ?> configuredFeature, boolean enabled) {
        if(!enabled) return;
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, registryKey.getValue(), configuredFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_DECORATION, registryKey);
    }

}