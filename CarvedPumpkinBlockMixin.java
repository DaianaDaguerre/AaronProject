package com.example.aluminumconstruct.mixin;

import com.example.aluminumconstruct.AluminumConstruct;
import com.example.aluminumconstruct.entity.AluminumGolemEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CarvedPumpkinBlock.class)
public abstract class CarvedPumpkinBlockMixin {
    @Inject(method = "onBlockAdded", at = @At("TAIL"))
    private void aluminum_construct$trySpawn(BlockState state, World world, BlockPos pumpkinPos, BlockState oldState, boolean notify, CallbackInfo ci) {
        if (!(world instanceof ServerWorld serverWorld) || state.isOf(net.minecraft.block.Blocks.JACK_O_LANTERN)) return;
        BlockPos upper = pumpkinPos.down();
        BlockPos base = upper.down();
        for (Direction direction : new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST}) {
            if (world.getBlockState(upper).isOf(AluminumConstruct.ALUMINUM_BLOCK)
                    && world.getBlockState(base).isOf(AluminumConstruct.ALUMINUM_BLOCK)
                    && world.getBlockState(base.offset(direction)).isOf(AluminumConstruct.ALUMINUM_BLOCK)
                    && world.getBlockState(base.offset(direction.getOpposite())).isOf(AluminumConstruct.ALUMINUM_BLOCK)) {
                AluminumGolemEntity golem = AluminumConstruct.ALUMINUM_GOLEM.create(serverWorld, SpawnReason.TRIGGERED);
                if (golem == null) return;
                golem.refreshPositionAndAngles(base.getX() + 0.5, base.getY(), base.getZ() + 0.5, 0.0f, 0.0f);
                world.breakBlock(pumpkinPos, false);
                world.breakBlock(upper, false);
                world.breakBlock(base, false);
                world.breakBlock(base.offset(direction), false);
                world.breakBlock(base.offset(direction.getOpposite()), false);
                serverWorld.spawnEntity(golem);
                return;
            }
        }
    }
}
