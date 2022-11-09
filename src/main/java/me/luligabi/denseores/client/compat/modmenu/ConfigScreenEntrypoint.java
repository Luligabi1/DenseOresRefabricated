package me.luligabi.denseores.client.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl.api.*;
import dev.isxander.yacl.gui.controllers.BooleanController;
import dev.isxander.yacl.gui.controllers.slider.IntegerSliderController;
import me.luligabi.denseores.common.DenseOres;
import me.luligabi.denseores.common.ModConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ConfigScreenEntrypoint implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return this::createConfigScreen;
    }

    public Screen createConfigScreen(Screen parent) {
        ModConfig config = DenseOres.CONFIG;

        /*
         * Dense Coal
         */
        Option<Integer> coalVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.coalVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        11,
                        () -> config.coalVeinSize,
                        newValue -> config.coalVeinSize = newValue
                )
                .available(config.canGenerateDenseCoal)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> coalMinHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.coalMinHeight"))
                .tooltip(Text.translatable("configOption.denseores.minHeight.tooltip"))
                .binding(
                        0,
                        () -> config.coalMinHeight,
                        newValue -> config.coalMinHeight = newValue
                )
                .available(config.canGenerateDenseCoal)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> coalMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.coalMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.maxHeight.tooltip"))
                .binding(
                        192,
                        () -> config.coalMaxHeight,
                        newValue -> config.coalMaxHeight = newValue
                )
                .available(config.canGenerateDenseCoal)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> coalChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.coalChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        6,
                        () -> config.coalChunkOdds,
                        newValue -> config.coalChunkOdds = newValue
                )
                .available(config.canGenerateDenseCoal)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseCoal = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseCoal"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseCoal,
                        newValue -> {
                            config.canGenerateDenseCoal = newValue;
                            coalVeinSize.setAvailable(newValue);
                            coalMinHeight.setAvailable(newValue);
                            coalMaxHeight.setAvailable(newValue);
                            coalChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Dense Copper
         */
        Option<Integer> copperVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.copperVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        6,
                        () -> config.copperVeinSize,
                        newValue -> config.copperVeinSize = newValue
                )
                .available(config.canGenerateDenseCopper)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> copperMinHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.copperMinHeight"))
                .tooltip(Text.translatable("configOption.denseores.minHeight.tooltip"))
                .binding(
                        -16,
                        () -> config.copperMinHeight,
                        newValue -> config.copperMinHeight = newValue
                )
                .available(config.canGenerateDenseCopper)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> copperMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.copperMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.maxHeight.tooltip"))
                .binding(
                        112,
                        () -> config.copperMaxHeight,
                        newValue -> config.copperMaxHeight = newValue
                )
                .available(config.canGenerateDenseCopper)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> copperChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.copperChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        11,
                        () -> config.copperChunkOdds,
                        newValue -> config.copperChunkOdds = newValue
                )
                .available(config.canGenerateDenseCopper)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseCopper = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseCopper"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseCopper,
                        newValue -> {
                            config.canGenerateDenseCoal = newValue;
                            copperVeinSize.setAvailable(newValue);
                            copperMinHeight.setAvailable(newValue);
                            copperMaxHeight.setAvailable(newValue);
                            copperChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Dense Iron
         */
        Option<Integer> ironVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.ironVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        3,
                        () -> config.ironVeinSize,
                        newValue -> config.ironVeinSize = newValue
                )
                .available(config.canGenerateDenseIron)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> ironMinHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.ironMinHeight"))
                .tooltip(Text.translatable("configOption.denseores.minHeight.tooltip"))
                .binding(
                        -64,
                        () -> config.ironMinHeight,
                        newValue -> config.ironMinHeight = newValue
                )
                .available(config.canGenerateDenseIron)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> ironMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.ironMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.maxHeight.tooltip"))
                .binding(
                        72,
                        () -> config.ironMaxHeight,
                        newValue -> config.ironMaxHeight = newValue
                )
                .available(config.canGenerateDenseIron)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> ironChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.ironChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        6,
                        () -> config.ironChunkOdds,
                        newValue -> config.ironChunkOdds = newValue
                )
                .available(config.canGenerateDenseIron)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseIron = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseIron"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseIron,
                        newValue -> {
                            config.canGenerateDenseIron = newValue;
                            ironVeinSize.setAvailable(newValue);
                            ironMinHeight.setAvailable(newValue);
                            ironMaxHeight.setAvailable(newValue);
                            ironChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Dense Gold
         */
        Option<Integer> goldVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.goldVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        6,
                        () -> config.goldVeinSize,
                        newValue -> config.goldVeinSize = newValue
                )
                .available(config.canGenerateDenseGold)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> goldMinHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.goldMinHeight"))
                .tooltip(Text.translatable("configOption.denseores.minHeight.tooltip"))
                .binding(
                        -64,
                        () -> config.goldMinHeight,
                        newValue -> config.goldMinHeight = newValue
                )
                .available(config.canGenerateDenseGold)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> goldMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.goldMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.maxHeight.tooltip"))
                .binding(
                        32,
                        () -> config.goldMaxHeight,
                        newValue -> config.goldMaxHeight = newValue
                )
                .available(config.canGenerateDenseGold)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> goldChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.goldChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        3,
                        () -> config.goldChunkOdds,
                        newValue -> config.goldChunkOdds = newValue
                )
                .available(config.canGenerateDenseGold)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseGold = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseGold"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseGold,
                        newValue -> {
                            config.canGenerateDenseGold = newValue;
                            goldVeinSize.setAvailable(newValue);
                            goldMinHeight.setAvailable(newValue);
                            goldMaxHeight.setAvailable(newValue);
                            goldChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Dense Redstone
         */
        Option<Integer> redstoneVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.redstoneVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        5,
                        () -> config.redstoneVeinSize,
                        newValue -> config.redstoneVeinSize = newValue
                )
                .available(config.canGenerateDenseRedstone)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> redstoneMinHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.redstoneMinHeight"))
                .tooltip(Text.translatable("configOption.denseores.minHeight.tooltip"))
                .binding(
                        -64,
                        () -> config.redstoneMinHeight,
                        newValue -> config.redstoneMinHeight = newValue
                )
                .available(config.canGenerateDenseRedstone)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> redstoneMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.redstoneMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.maxHeight.tooltip"))
                .binding(
                        32,
                        () -> config.redstoneMaxHeight,
                        newValue -> config.redstoneMaxHeight = newValue
                )
                .available(config.canGenerateDenseRedstone)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> redstoneChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.redstoneChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        3,
                        () -> config.redstoneChunkOdds,
                        newValue -> config.redstoneChunkOdds = newValue
                )
                .available(config.canGenerateDenseRedstone)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseRedstone = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseRedstone"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseRedstone,
                        newValue -> {
                            config.canGenerateDenseRedstone = newValue;
                            redstoneVeinSize.setAvailable(newValue);
                            redstoneMinHeight.setAvailable(newValue);
                            redstoneMaxHeight.setAvailable(newValue);
                            redstoneChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();


        /*
         * Dense Lapis
         */
        Option<Integer> lapisVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.lapisVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        7,
                        () -> config.lapisVeinSize,
                        newValue -> config.lapisVeinSize = newValue
                )
                .available(config.canGenerateDenseLapis)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> lapisMinHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.lapisMinHeight"))
                .tooltip(Text.translatable("configOption.denseores.minHeight.tooltip"))
                .binding(
                        -32,
                        () -> config.lapisMinHeight,
                        newValue -> config.lapisMinHeight = newValue
                )
                .available(config.canGenerateDenseLapis)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> lapisMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.lapisMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.maxHeight.tooltip"))
                .binding(
                        32,
                        () -> config.lapisMaxHeight,
                        newValue -> config.lapisMaxHeight = newValue
                )
                .available(config.canGenerateDenseLapis)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> lapisChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.lapisChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        5,
                        () -> config.lapisChunkOdds,
                        newValue -> config.lapisChunkOdds = newValue
                )
                .available(config.canGenerateDenseLapis)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseLapis = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseLapis"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseLapis,
                        newValue -> {
                            config.canGenerateDenseLapis = newValue;
                            lapisVeinSize.setAvailable(newValue);
                            lapisMinHeight.setAvailable(newValue);
                            lapisMaxHeight.setAvailable(newValue);
                            lapisChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();


        /*
         * Dense Diamond
         */
        Option<Integer> diamondVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.diamondVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        3,
                        () -> config.diamondVeinSize,
                        newValue -> config.diamondVeinSize = newValue
                )
                .available(config.canGenerateDenseDiamond)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> diamondMinHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.diamondMinHeight"))
                .tooltip(Text.translatable("configOption.denseores.minHeight.tooltip"))
                .binding(
                        -80,
                        () -> config.diamondMinHeight,
                        newValue -> config.diamondMinHeight = newValue
                )
                .available(config.canGenerateDenseDiamond)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> diamondMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.diamondMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.maxHeight.tooltip"))
                .binding(
                        80,
                        () -> config.diamondMaxHeight,
                        newValue -> config.diamondMaxHeight = newValue
                )
                .available(config.canGenerateDenseDiamond)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> diamondChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.diamondChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        5,
                        () -> config.diamondChunkOdds,
                        newValue -> config.diamondChunkOdds = newValue
                )
                .available(config.canGenerateDenseDiamond)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseDiamond = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseDiamond"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseDiamond,
                        newValue -> {
                            config.canGenerateDenseDiamond = newValue;
                            diamondVeinSize.setAvailable(newValue);
                            diamondMinHeight.setAvailable(newValue);
                            diamondMaxHeight.setAvailable(newValue);
                            diamondChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Dense Emerald
         */
        Option<Integer> emeraldVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.emeraldVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        2,
                        () -> config.emeraldVeinSize,
                        newValue -> config.emeraldVeinSize = newValue
                )
                .available(config.canGenerateDenseEmerald)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> emeraldMinHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.emeraldMinHeight"))
                .tooltip(Text.translatable("configOption.denseores.minHeight.tooltip"))
                .binding(
                        -16,
                        () -> config.emeraldMinHeight,
                        newValue -> config.emeraldMinHeight = newValue
                )
                .available(config.canGenerateDenseEmerald)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> emeraldMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.emeraldMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.maxHeight.tooltip"))
                .binding(
                        80,
                        () -> config.emeraldMaxHeight,
                        newValue -> config.emeraldMaxHeight = newValue
                )
                .available(config.canGenerateDenseEmerald)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Integer> emeraldChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.emeraldChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        6,
                        () -> config.emeraldChunkOdds,
                        newValue -> config.emeraldChunkOdds = newValue
                )
                .available(config.canGenerateDenseEmerald)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseEmerald = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseEmerald"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseEmerald,
                        newValue -> {
                            config.canGenerateDenseEmerald = newValue;
                            emeraldVeinSize.setAvailable(newValue);
                            emeraldMinHeight.setAvailable(newValue);
                            emeraldMaxHeight.setAvailable(newValue);
                            emeraldChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();


        /*
         * Deepslate
         */
        Option<Integer> deepslateMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.deepslateMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.deepslateMaxHeight.tooltip"))
                .binding(
                        16,
                        () -> config.deepslateMaxHeight,
                        newValue -> config.deepslateMaxHeight = newValue
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, -64, 320, 2))
                .build();

        Option<Boolean> canGenerateDenseDeepslateCoal = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseDeepslateCoal"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip.2"))
                .binding(
                        false,
                        () -> config.canGenerateDenseDeepslateCoal,
                        newValue -> config.canGenerateDenseDeepslateCoal = newValue
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Boolean> canGenerateDenseDeepslateCopper = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseDeepslateCopper"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip.2"))
                .binding(
                        false,
                        () -> config.canGenerateDenseDeepslateCopper,
                        newValue -> config.canGenerateDenseDeepslateCopper = newValue
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        Option<Boolean> canGenerateDenseDeepslateEmerald = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseDeepslateEmerald"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip.2"))
                .binding(
                        false,
                        () -> config.canGenerateDenseDeepslateEmerald,
                        newValue -> config.canGenerateDenseDeepslateEmerald = newValue
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();


        /*
         * Dense Nether Quartz
         */
        Option<Integer> netherQuartzVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.netherQuartzVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        9,
                        () -> config.netherQuartzVeinSize,
                        newValue -> config.netherQuartzVeinSize = newValue
                )
                .available(config.canGenerateDenseNetherQuartz)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> netherQuartzChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.netherQuartzChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        11,
                        () -> config.netherQuartzChunkOdds,
                        newValue -> config.netherQuartzChunkOdds = newValue
                )
                .available(config.canGenerateDenseNetherQuartz)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseNetherQuartz = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseNetherQuartz"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseNetherQuartz,
                        newValue -> {
                            config.canGenerateDenseNetherQuartz = newValue;
                            netherQuartzVeinSize.setAvailable(newValue);
                            netherQuartzChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();


        /*
         * Dense Nether Gold
         */
        Option<Integer> netherGoldVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.netherGoldVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        7,
                        () -> config.netherGoldVeinSize,
                        newValue -> config.netherGoldVeinSize = newValue
                )
                .available(config.canGenerateDenseNetherGold)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> netherGoldChunkOdds = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.netherGoldChunkOdds"))
                .tooltip(Text.translatable("configOption.denseores.chunkOdds.tooltip"))
                .binding(
                        7,
                        () -> config.netherGoldChunkOdds,
                        newValue -> config.netherGoldChunkOdds = newValue
                )
                .available(config.canGenerateDenseNetherGold)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Boolean> canGenerateDenseNetherGold = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseNetherGold"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseNetherGold,
                        newValue -> {
                            config.canGenerateDenseNetherGold = newValue;
                            netherGoldVeinSize.setAvailable(newValue);
                            netherGoldChunkOdds.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        /*
         * Dense Ancient Debris
         */
        Option<Integer> ancientDebrisVeinSize = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.ancientDebrisVeinSize"))
                .tooltip(Text.translatable("configOption.denseores.veinSize.tooltip"))
                .binding(
                        1,
                        () -> config.ancientDebrisVeinSize,
                        newValue -> config.ancientDebrisVeinSize = newValue
                )
                .available(config.canGenerateDenseAncientDebris)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 2, 32, 2))
                .build();

        Option<Integer> ancientDebrisMinHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.ancientDebrisMinHeight"))
                .tooltip(Text.translatable("configOption.denseores.minHeight.tooltip"))
                .binding(
                        8,
                        () -> config.ancientDebrisMinHeight,
                        newValue -> config.ancientDebrisMinHeight = newValue
                )
                .available(config.canGenerateDenseAncientDebris)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 0, 128, 2))
                .build();

        Option<Integer> ancientDebrisMaxHeight = Option.createBuilder(Integer.class)
                .name(Text.translatable("configOption.denseores.ancientDebrisMaxHeight"))
                .tooltip(Text.translatable("configOption.denseores.maxHeight.tooltip"))
                .binding(
                        119,
                        () -> config.ancientDebrisMaxHeight,
                        newValue -> config.ancientDebrisMaxHeight = newValue
                )
                .available(config.canGenerateDenseAncientDebris)
                .flag(OptionFlag.GAME_RESTART)
                .controller((intOption) -> new IntegerSliderController(intOption, 0, 128, 2))
                .build();

        Option<Boolean> canGenerateDenseAncientDebris = Option.createBuilder(Boolean.class)
                .name(Text.translatable("configOption.denseores.canGenerateDenseAncientDebris"))
                .tooltip(Text.translatable("configOption.denseores.canGenerate.tooltip"))
                .binding(
                        true,
                        () -> config.canGenerateDenseAncientDebris,
                        newValue -> {
                            config.canGenerateDenseAncientDebris = newValue;
                            ancientDebrisVeinSize.setAvailable(newValue);
                            ancientDebrisMinHeight.setAvailable(newValue);
                            ancientDebrisMaxHeight.setAvailable(newValue);
                        }
                )
                .flag(OptionFlag.GAME_RESTART)
                .controller((booleanOption) -> new BooleanController(booleanOption, BooleanController.YES_NO_FORMATTER, true))
                .build();

        return YetAnotherConfigLib.createBuilder()
                .title(Text.translatable("itemGroup.denseores.item_group"))
                .category(
                        createOreCategory("dense_coal_ore",
                                canGenerateDenseCoal, coalVeinSize, coalMinHeight, coalMaxHeight, coalChunkOdds
                        )
                )
                .category(
                        createOreCategory("dense_copper_ore",
                                canGenerateDenseCopper, copperVeinSize, copperMinHeight, copperMaxHeight, copperChunkOdds
                        )
                )
                .category(
                        createOreCategory("dense_iron_ore",
                                canGenerateDenseIron, ironVeinSize, ironMinHeight, ironMaxHeight, ironChunkOdds
                        )
                )
                .category(
                        createOreCategory("dense_gold_ore",
                                canGenerateDenseGold, goldVeinSize, goldMinHeight, goldMaxHeight, goldChunkOdds
                        )
                )
                .category(
                        createOreCategory("dense_redstone_ore",
                                canGenerateDenseRedstone, redstoneVeinSize, redstoneMinHeight, redstoneMaxHeight, redstoneChunkOdds
                        )
                )
                .category(
                        createOreCategory("dense_lapis_ore",
                                canGenerateDenseLapis, lapisVeinSize, lapisMinHeight, lapisMaxHeight, lapisChunkOdds
                        )
                )
                .category(
                        createOreCategory("dense_diamond_ore",
                                canGenerateDenseDiamond, diamondVeinSize, diamondMinHeight, diamondMaxHeight, diamondChunkOdds
                        )
                )
                .category(
                        createOreCategory("dense_emerald_ore",
                                canGenerateDenseEmerald, emeraldVeinSize, emeraldMinHeight, emeraldMaxHeight, emeraldChunkOdds
                        )
                )
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("configCategory.denseores.deepslate_ores"))
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("configCategory.denseores.deepslate_ores"))
                                .option(deepslateMaxHeight)
                                .option(canGenerateDenseDeepslateCoal)
                                .option(canGenerateDenseDeepslateCopper)
                                .option(canGenerateDenseDeepslateEmerald)
                                .build())
                        .build())
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("configCategory.denseores.nether_ores"))
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("block.denseores.dense_nether_quartz_ore"))
                                .option(canGenerateDenseNetherQuartz)
                                .option(netherQuartzVeinSize)
                                .option(netherQuartzChunkOdds)
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("block.denseores.dense_nether_gold_ore"))
                                .option(canGenerateDenseNetherGold)
                                .option(netherGoldVeinSize)
                                .option(netherGoldChunkOdds)
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("block.denseores.dense_ancient_debris"))
                                .option(canGenerateDenseAncientDebris)
                                .option(ancientDebrisVeinSize)
                                .option(ancientDebrisMinHeight)
                                .option(ancientDebrisMaxHeight)
                                .build())
                        .build())
                .save(() -> DenseOres.saveConfig(config))
                .build()
                .generateScreen(parent);
    }


    private ConfigCategory createOreCategory(String oreName, Option<Boolean> canGenerate, Option<Integer> veinSize, Option<Integer> minHeight, Option<Integer> maxHeight, Option<Integer> chunkOdds) {
        return ConfigCategory.createBuilder()
                .name(Text.translatable("block.denseores." + oreName))
                .group(OptionGroup.createBuilder()
                        .name(Text.translatable("block.denseores." + oreName))
                        .option(canGenerate)
                        .option(veinSize)
                        .option(minHeight)
                        .option(maxHeight)
                        .option(chunkOdds)
                        .build())
                .build();
    }

}