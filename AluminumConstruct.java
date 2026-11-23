package com.example.aluminumconstruct;

import com.example.aluminumconstruct.entity.AluminumGolemEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

public class AluminumConstruct implements ModInitializer {
    public static final String MOD_ID = "aluminum_construct";
    public static Identifier id(String path) { return Identifier.of(MOD_ID, path); }

    public static final Block ALUMINUM_ORE = registerBlock("aluminum_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
    public static final Block ALUMINUM_BLOCK = registerBlock("aluminum_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));

    public static final Item RAW_ALUMINUM = registerItem("raw_aluminum", new Item(new Item.Settings()));
    public static final Item ALUMINUM_INGOT = registerItem("aluminum_ingot", new Item(new Item.Settings()));
    public static final Item ALUMINUM_NUGGET = registerItem("aluminum_nugget", new Item(new Item.Settings()));

    public static final RegistryKey<ConfiguredFeature<?, ?>> ALUMINUM_ORE_CONFIGURED = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, id("aluminum_ore"));
    public static final RegistryKey<PlacedFeature> ALUMINUM_ORE_PLACED = RegistryKey.of(RegistryKeys.PLACED_FEATURE, id("aluminum_ore"));

    public static final EntityType<AluminumGolemEntity> ALUMINUM_GOLEM = Registry.register(
            Registries.ENTITY_TYPE, id("aluminum_golem"),
            EntityType.Builder.create(AluminumGolemEntity::new, SpawnGroup.MISC)
                    .dimensions(1.4f, 2.7f).maxTrackingRange(10).build("aluminum_construct:aluminum_golem"));

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registries.BLOCK, id(name), block);
        Registry.register(Registries.ITEM, id(name), new BlockItem(block, new Item.Settings()));
        return block;
    }
    private static Item registerItem(String name, Item item) { return Registry.register(Registries.ITEM, id(name), item); }

    @Override public void onInitialize() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ALUMINUM_ORE_PLACED);
    }
}
