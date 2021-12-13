package me.luligabi.denseores.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.ToIntFunction;

@Mixin(Blocks.class)
public interface BlocksInvoker {

    @Invoker("createLightLevelFromLitBlockState")
    static ToIntFunction<BlockState> invokeCreateLightLevelFromLitBlockState(int litLevel) {
        throw new AssertionError();
    }
}