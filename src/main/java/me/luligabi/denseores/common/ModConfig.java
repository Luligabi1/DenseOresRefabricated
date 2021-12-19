package me.luligabi.denseores.common;

import draylar.omegaconfig.api.Comment;
import draylar.omegaconfig.api.Config;

public class ModConfig implements Config {

    // Dense Coal Gen
    @Comment(value = "Whether Dense Coal Ore is generated.")
    public boolean canGenerateDenseCoal = true;

    @Comment(value = "Vein size of generated Dense Coal.")
    public int coalVeinSize = 11;

    @Comment(value = "Min height of generated Dense Coal.")
    public int coalMinHeight = 0;

    @Comment(value = "Max height of generated Dense Coal.")
    public int coalMaxHeight = 192;

    @Comment(value = "Odds of generating more Dense Coal veins on each chunk.")
    public int coalChunkOdds = 6;

    // Dense Copper Gen
    @Comment(value = "Whether Dense Copper Ore is generated.")
    public boolean canGenerateDenseCopper = true;

    @Comment(value = "Vein size of generated Dense Copper.")
    public int copperVeinSize = 6;

    @Comment(value = "Min height of generated Dense Copper.")
    public int copperMinHeight = -16;

    @Comment(value = "Max height of generated Dense Copper.")
    public int copperMaxHeight = 112;

    @Comment(value = "Odds of generating more Dense Copper veins on each chunk.")
    public int copperChunkOdds = 11;

    // Dense Iron Gen
    @Comment(value = "Whether Dense Iron Ore (and its deepslate variant) is generated.")
    public boolean canGenerateDenseIron = true;

    @Comment(value = "Vein size of generated Dense Iron (and its deepslate variant).")
    public int ironVeinSize = 3;

    @Comment(value = "Min height of generated Dense Iron.")
    public int ironMinHeight = -64;

    @Comment(value = "Max height of generated Dense Iron.")
    public int ironMaxHeight = 72;

    @Comment(value = "Odds of generating more Dense Iron (and its deepslate variant) veins on each chunk.")
    public int ironChunkOdds = 6;

    // Dense Gold Gen
    @Comment(value = "Whether Dense Gold Ore (and its deepslate variant) is generated.")
    public boolean canGenerateDenseGold = true;

    @Comment(value = "Vein size of generated Dense Gold (and its deepslate variant).")
    public int goldVeinSize = 6;

    @Comment(value = "Min height of generated Dense Gold.")
    public int goldMinHeight = -64;

    @Comment(value = "Max height of generated Dense Gold.")
    public int goldMaxHeight = 32;

    @Comment(value = "Odds of generating more Dense Gold (and its deepslate variant) veins on each chunk.")
    public int goldChunkOdds = 3;

    // Dense Redstone Gen
    @Comment(value = "Whether Dense Redstone Ore (and its deepslate variant) is generated.")
    public boolean canGenerateDenseRedstone = true;

    @Comment(value = "Vein size of generated Dense Redstone (and its deepslate variant).")
    public int redstoneVeinSize = 5;

    @Comment(value = "Min height of generated Dense Redstone.")
    public int redstoneMinHeight = -64;

    @Comment(value = "Max height of generated Dense Redstone.")
    public int redstoneMaxHeight = 32;

    @Comment(value = "Odds of generating more Dense Redstone (and its deepslate variant) veins on each chunk.")
    public int redstoneChunkOdds = 3;

    // Dense Lapis Lazuli Gen
    @Comment(value = "Whether Dense Lapis Lazuli Ore (and its deepslate variant) is generated.")
    public boolean canGenerateDenseLapis = true;

    @Comment(value = "Vein size of generated Dense Lapis Lazuli (and its deepslate variant).")
    public int lapisVeinSize = 7;

    @Comment(value = "Min height of generated Dense Lapis Lazuli.")
    public int lapisMinHeight = -32;

    @Comment(value = "Max height of generated Dense Lapis Lazuli.")
    public int lapisMaxHeight = 32;

    @Comment(value = "Odds of generating more Dense Lapis Lazuli (and its deepslate variant) veins on each chunk.")
    public int lapisChunkOdds = 5;

    // Dense Diamond Gen
    @Comment(value = "Whether Dense Diamond Ore (and its deepslate variant) is generated.")
    public boolean canGenerateDenseDiamond = true;

    @Comment(value = "Vein size of generated Dense Diamond (and its deepslate variant).")
    public int diamondVeinSize = 3;

    @Comment(value = "Min height of generated Dense Diamond.")
    public int diamondMinHeight = -80;

    @Comment(value = "Max height of generated Dense Diamond.")
    public int diamondMaxHeight = 80;

    @Comment(value = "Odds of generating more Dense Diamond (and its deepslate variant) veins on each chunk.")
    public int diamondChunkOdds = 5;

    // Dense Emerald Gen
    @Comment(value = "Whether Dense Emerald Ore is generated.")
    public boolean canGenerateDenseEmerald = true;

    @Comment(value = "Vein size of generated Dense Emerald.")
    public int emeraldVeinSize = 2;

    @Comment(value = "Min height of generated Dense Emerald.")
    public int emeraldMinHeight = -16;

    @Comment(value = "Max height of generated Dense Emerald.")
    public int emeraldMaxHeight = 480;

    @Comment(value = "Odds of generating more Dense Emerald veins on each chunk.")
    public int emeraldChunkOdds = 67;

    // Deepslate
    @Comment(value = "Common Max Height for all Deepslate ores. Min Height is always world's bottom.")
    public int deepslateMaxHeight = 16;

    @Comment(value = "Whether Dense Deepslate Coal is generated.\nOn vanilla worldgen, this will not happen, so it's disabled by default.")
    public boolean canGenerateDenseDeepslateCoal = false;

    @Comment(value = "Whether Dense Deepslate Copper is generated.\nOn vanilla worldgen, this will not happen, so it's disabled by default.")
    public boolean canGenerateDenseDeepslateCopper = false;

    @Comment(value = "Whether Dense Deepslate Emerald is generated.\nOn vanilla worldgen, this will not happen, so it's disabled by default.")
    public boolean canGenerateDenseDeepslateEmerald = false;

    // Nether Quartz Ore
    @Comment(value = "Whether Dense Nether Quartz is generated.")
    public boolean canGenerateDenseNetherQuartz = true;

    @Comment(value = "Vein size of generated Dense Nether Quartz.")
    public int netherQuartzVeinSize = 9;

    @Comment(value = "Odds of generating more Dense Nether Quartz veins on each chunk.")
    public int netherQuartzChunkOdds = 11;

    // Nether Gold Ore
    @Comment(value = "Whether Dense Nether Gold is generated.")
    public boolean canGenerateDenseNetherGold = true;

    @Comment(value = "Vein size of generated Dense Nether Gold.")
    public int netherGoldVeinSize = 7;

    @Comment(value = "Odds of generating more Dense Nether Gold veins on each chunk.")
    public int netherGoldChunkOdds = 7;

    // Ancient Debris
    @Comment(value = "Whether Dense Ancient Debris is generated.")
    public boolean canGenerateDenseAncientDebris = true;

    @Comment(value = "Vein size of generated Dense Ancient Debris.")
    public int ancientDebrisVeinSize = 1;

    @Comment(value = "Min height of generated Dense Ancient Debris.")
    public int ancientDebrisMinHeight = 8;

    @Comment(value = "Max height of generated Dense Ancient Debris.")
    public int ancientDebrisMaxHeight = 119;

    @Override
    public String getName() {
        return "denseores";
    }

}