package me.luligabi.denseores.block;

import me.luligabi.denseores.DenseOres;
import me.luligabi.denseores.mixin.BlocksInvoker;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

    public static void init() {
        initBlock("dense_coal_ore", DENSE_COAL_ORE);
        initBlock("dense_copper_ore", DENSE_COPPER_ORE);
        initBlock("dense_iron_ore", DENSE_IRON_ORE);
        initBlock("dense_gold_ore", DENSE_GOLD_ORE);
        initBlock("dense_redstone_ore", DENSE_REDSTONE_ORE);
        initBlock("dense_lapis_ore", DENSE_LAPIS_ORE);
        initBlock("dense_diamond_ore", DENSE_DIAMOND_ORE);
        initBlock("dense_emerald_ore", DENSE_EMERALD_ORE);

        initBlock("dense_deepslate_coal_ore", DENSE_DEEPSLATE_COAL_ORE);
        initBlock("dense_deepslate_copper_ore", DENSE_DEEPSLATE_COPPER_ORE);
        initBlock("dense_deepslate_iron_ore", DENSE_DEEPSLATE_IRON_ORE);
        initBlock("dense_deepslate_gold_ore", DENSE_DEEPSLATE_GOLD_ORE);
        initBlock("dense_deepslate_redstone_ore", DENSE_DEEPSLATE_REDSTONE_ORE);
        initBlock("dense_deepslate_lapis_ore", DENSE_DEEPSLATE_LAPIS_ORE);
        initBlock("dense_deepslate_diamond_ore", DENSE_DEEPSLATE_DIAMOND_ORE);
        initBlock("dense_deepslate_emerald_ore", DENSE_DEEPSLATE_EMERALD_ORE);

    }

    // TODO: Add loot tables
    public static final Block DENSE_COAL_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).strength(3.0F, 3.0F), UniformIntProvider.create(1, 4));

    public static final Block DENSE_COPPER_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1).strength(3.0F, 3.0F));

    public static final Block DENSE_IRON_ORE = new OreBlock(FabricBlockSettings.copy(DENSE_COPPER_ORE));

    public static final Block DENSE_GOLD_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).strength(3.0F, 3.0F));

    public static final Block DENSE_REDSTONE_ORE = new RedstoneOreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).ticksRandomly().luminance(BlocksInvoker.invokeCreateLightLevelFromLitBlockState(9)).strength(3.0F, 3.0F));

    public static final Block DENSE_LAPIS_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1).strength(3.0F, 3.0F), UniformIntProvider.create(4, 7));

    public static final Block DENSE_DIAMOND_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).strength(3.0F, 3.0F), UniformIntProvider.create(5, 9));

    public static final Block DENSE_EMERALD_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F), UniformIntProvider.create(5, 9));

    // Deepslate variants
    public static final Block DENSE_DEEPSLATE_COAL_ORE = new OreBlock(AbstractBlock.Settings.copy(DENSE_COAL_ORE).sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block DENSE_DEEPSLATE_COPPER_ORE = new OreBlock(AbstractBlock.Settings.copy(DENSE_COPPER_ORE).sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block DENSE_DEEPSLATE_IRON_ORE = new OreBlock(AbstractBlock.Settings.copy(DENSE_IRON_ORE).sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block DENSE_DEEPSLATE_GOLD_ORE = new OreBlock(AbstractBlock.Settings.copy(DENSE_GOLD_ORE).sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block DENSE_DEEPSLATE_REDSTONE_ORE = new RedstoneOreBlock(AbstractBlock.Settings.copy(DENSE_REDSTONE_ORE).sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block DENSE_DEEPSLATE_LAPIS_ORE = new OreBlock(AbstractBlock.Settings.copy(DENSE_LAPIS_ORE).sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block DENSE_DEEPSLATE_DIAMOND_ORE = new OreBlock(AbstractBlock.Settings.copy(DENSE_DIAMOND_ORE).sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block DENSE_DEEPSLATE_EMERALD_ORE = new OreBlock(AbstractBlock.Settings.copy(DENSE_EMERALD_ORE).sounds(BlockSoundGroup.DEEPSLATE));

    // TODO: Fix deepslate variant strength
    // TODO: Add nether dense ores
    private static void initBlock(String identifier, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(DenseOres.MOD_ID, identifier), block);
        Registry.register(Registry.ITEM, new Identifier(DenseOres.MOD_ID, identifier), new BlockItem(block, new FabricItemSettings().group(DenseOres.ITEM_GROUP)));
    }
}