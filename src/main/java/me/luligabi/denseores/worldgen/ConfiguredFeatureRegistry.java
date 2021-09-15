package me.luligabi.denseores.worldgen;

import me.luligabi.denseores.DenseOres;
import me.luligabi.denseores.block.BlockRegistry;
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
        registerOverworldFeature(DENSE_COAL_KEY, DENSE_COAL_ORE);
        registerOverworldFeature(DENSE_COPPER_KEY, DENSE_COPPER_ORE);
        registerOverworldFeature(DENSE_IRON_KEY, DENSE_IRON_ORE);
        registerOverworldFeature(DENSE_GOLD_KEY, DENSE_GOLD_ORE);
        registerOverworldFeature(DENSE_REDSTONE_KEY, DENSE_REDSTONE_ORE);
        registerOverworldFeature(DENSE_LAPIS_KEY, DENSE_LAPIS_ORE);
        registerOverworldFeature(DENSE_DIAMOND_KEY, DENSE_DIAMOND_ORE);
        registerOverworldFeature(DENSE_EMERALD_KEY, DENSE_EMERALD_ORE);

        // Deepslate variants; Coal, Copper and Emerald deepslate ores don't generate at normal circumstances.
        registerOverworldFeature(DENSE_DEEPSLATE_IRON_KEY, DENSE_DEEPSLATE_IRON_ORE);
        registerOverworldFeature(DENSE_DEEPSLATE_GOLD_KEY, DENSE_DEEPSLATE_GOLD_ORE);
        registerOverworldFeature(DENSE_DEEPSLATE_REDSTONE_KEY, DENSE_DEEPSLATE_REDSTONE_ORE);
        registerOverworldFeature(DENSE_DEEPSLATE_LAPIS_KEY, DENSE_DEEPSLATE_LAPIS_ORE);
        registerOverworldFeature(DENSE_DEEPSLATE_DIAMOND_KEY, DENSE_DEEPSLATE_DIAMOND_ORE);

        // Nether Ores
        registerNetherFeature(DENSE_NETHER_QUARTZ_KEY, DENSE_NETHER_QUARTZ_ORE);
        registerNetherFeature(DENSE_NETHER_GOLD_KEY, DENSE_NETHER_GOLD_ORE);
        registerNetherFeature(DENSE_ANCIENT_DEBRIS_KEY, DENSE_ANCIENT_DEBRIS);
    }

    // Dense Coal
    private static final ConfiguredFeature<?, ?> DENSE_COAL_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.COAL_ORE),
                    BlockRegistry.DENSE_COAL_ORE.getDefaultState(),
                    6))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.getBottom(), YOffset.fixed(127))))
            .spreadHorizontally()
            .repeat(10);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_COAL_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_coal_ore"));

    // Dense Copper
    private static final ConfiguredFeature<?, ?> DENSE_COPPER_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.COPPER_ORE),
                    BlockRegistry.DENSE_COPPER_ORE.getDefaultState(),
                    6))
            .triangleRange(YOffset.fixed(0), YOffset.fixed(96))
            .spreadHorizontally()
            .repeat(10);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_COPPER_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_copper_ore"));

    // Dense Iron
    private static final ConfiguredFeature<?, ?> DENSE_IRON_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.IRON_ORE),
                    BlockRegistry.DENSE_IRON_ORE.getDefaultState(),
                    4))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(63))
            .spreadHorizontally()
            .repeat(8);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_IRON_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_iron_ore"));

    // Dense Gold
    private static final ConfiguredFeature<?, ?> DENSE_GOLD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.GOLD_ORE),
                    BlockRegistry.DENSE_GOLD_ORE.getDefaultState(),
                    3))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(31))
            .spreadHorizontally()
            .repeat(5);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_GOLD_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_gold_ore"));

    // Dense Redstone
    private static final ConfiguredFeature<?, ?> DENSE_REDSTONE_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.REDSTONE_ORE),
                    BlockRegistry.DENSE_REDSTONE_ORE.getDefaultState(),
                    6))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(15))
            .spreadHorizontally()
            .repeat(6);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_REDSTONE_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_redstone_ore"));

    // Dense Lapis
    private static final ConfiguredFeature<?, ?> DENSE_LAPIS_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.LAPIS_ORE),
                    BlockRegistry.DENSE_LAPIS_ORE.getDefaultState(),
                    6))
            .triangleRange(YOffset.fixed(0), YOffset.fixed(30))
            .spreadHorizontally()
            .repeat(6);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_LAPIS_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_lapis_ore"));

    // Dense Diamond
    private static final ConfiguredFeature<?, ?> DENSE_DIAMOND_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DIAMOND_ORE),
                    BlockRegistry.DENSE_DIAMOND_ORE.getDefaultState(),
                    1))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(15))
            .spreadHorizontally()
            .repeat(4);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DIAMOND_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_diamond_ore"));

    // Dense Emerald
    private static final ConfiguredFeature<?, ?> DENSE_EMERALD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.EMERALD_ORE),
                    BlockRegistry.DENSE_EMERALD_ORE.getDefaultState(),
                    3))
            .uniformRange(YOffset.fixed(4), YOffset.fixed(31))
            .spreadHorizontally()
            .repeat(4);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_EMERALD_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_emerald_ore"));


    // Dense Deepslate Iron
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_IRON_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_IRON_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_IRON_ORE.getDefaultState(),
                    4))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(16))
            .spreadHorizontally()
            .repeat(8);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_IRON_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_iron_ore"));

    // Dense Deepslate Gold
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_GOLD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_GOLD_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_GOLD_ORE.getDefaultState(),
                    5))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(16))
            .spreadHorizontally()
            .repeat(2);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_GOLD_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_gold_ore"));

    // Dense Deepslate Redstone
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_REDSTONE_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_REDSTONE_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_REDSTONE_ORE.getDefaultState(),
                    6))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(16))
            .spreadHorizontally()
            .repeat(6);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_REDSTONE_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_redstone_ore"));

    // Dense Deepslate Lapis
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_LAPIS_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_LAPIS_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_LAPIS_ORE.getDefaultState(),
                    6))
            .triangleRange(YOffset.fixed(0), YOffset.fixed(16))
            .spreadHorizontally()
            .repeat(6);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_LAPIS_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_lapis_ore"));

    // Dense Deepslate Diamond
    private static final ConfiguredFeature<?, ?> DENSE_DEEPSLATE_DIAMOND_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.DEEPSLATE_DIAMOND_ORE),
                    BlockRegistry.DENSE_DEEPSLATE_DIAMOND_ORE.getDefaultState(),
                    1))
            .uniformRange(YOffset.getBottom(), YOffset.fixed(16))
            .spreadHorizontally()
            .repeat(4);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_DIAMOND_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_deepslate_diamond_ore"));


    // Dense Nether Quartz
    private static final ConfiguredFeature<?, ?> DENSE_NETHER_QUARTZ_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.NETHER_QUARTZ_ORE),
                    BlockRegistry.DENSE_NETHER_QUARTZ_ORE.getDefaultState(),
                    7))
            .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP_OFFSET_10)
            .spreadHorizontally()
            .repeat(12);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_NETHER_QUARTZ_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_nether_quartz_ore"));

    // Dense Nether Gold
    private static final ConfiguredFeature<?, ?> DENSE_NETHER_GOLD_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.NETHER_GOLD_ORE),
                    BlockRegistry.DENSE_NETHER_GOLD_ORE.getDefaultState(),
                    5))
            .range(ConfiguredFeatures.Decorators.BOTTOM_TO_TOP_OFFSET_10)
            .spreadHorizontally()
            .repeat(5);

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_NETHER_GOLD_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_nether_gold_ore"));

    // Dense Ancient Debris
    private static final ConfiguredFeature<?, ?> DENSE_ANCIENT_DEBRIS = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.ANCIENT_DEBRIS),
                    BlockRegistry.DENSE_ANCIENT_DEBRIS.getDefaultState(),
                    1, 1.0F))
            .triangleRange(YOffset.fixed(8), YOffset.fixed(24))
            .spreadHorizontally();

    private static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_ANCIENT_DEBRIS_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier(DenseOres.MOD_ID, "dense_ancient_debris"));

    @SuppressWarnings("deprecation")
    private static void registerOverworldFeature(RegistryKey<ConfiguredFeature<?, ?>> registryKey, ConfiguredFeature<?, ?> configuredFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, registryKey.getValue(), configuredFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_DECORATION, registryKey);
    }

    @SuppressWarnings("deprecation")
    private static void registerNetherFeature(RegistryKey<ConfiguredFeature<?, ?>> registryKey, ConfiguredFeature<?, ?> configuredFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, registryKey.getValue(), configuredFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_DECORATION, registryKey);
    }

}