package com.example.aluminumconstruct.entity;

import com.example.aluminumconstruct.AluminumConstruct;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.world.World;

public class AluminumGolemEntity extends IronGolemEntity {
    public AluminumGolemEntity(EntityType<? extends IronGolemEntity> type, World world) { super(type, world); }
}
