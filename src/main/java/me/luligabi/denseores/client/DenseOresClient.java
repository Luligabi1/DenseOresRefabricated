package me.luligabi.denseores.client;

import draylar.omegaconfiggui.OmegaConfigGui;
import me.luligabi.denseores.common.DenseOres;
import net.fabricmc.api.ClientModInitializer;

public class DenseOresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        OmegaConfigGui.registerConfigScreen(DenseOres.CONFIG);
    }

}