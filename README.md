# Aluminum Construct — Fabric 1.21.1

Adds aluminum ore, aluminum materials, and a player-buildable aluminum golem.

## Implemented content

- Aluminum ore generates in Overworld biomes at Y=35–50 (uniform height distribution), in veins of 8, with 8 placement attempts per chunk.
- Mining aluminum ore drops 2–3 raw aluminum.
- Smelting 1 raw aluminum in a furnace produces 1 aluminum ingot.
- 9 aluminum nuggets craft 1 ingot; 1 ingot crafts 9 nuggets.
- 9 aluminum ingots craft 1 aluminum block; 1 block crafts 9 ingots.
- Four aluminum blocks in the iron-golem T arrangement plus a carved pumpkin on top create an aluminum golem.
- The aluminum golem uses Minecraft's vanilla iron-golem model and a custom 128×128 silver/aluminum texture.

## Build

Requires JDK 21 and internet access for Gradle to download Fabric/Minecraft dependencies.

```sh
./gradlew build
```

The distributable remapped mod JAR will be in `build/libs/` (choose the file without `-dev` or `-sources`).

This source archive does not include the Gradle wrapper JAR. Open the folder in IntelliJ IDEA or run it with a locally installed Gradle 8.x compatible with Fabric Loom 1.7, then build.

## Install

Copy the built `aluminum-construct-1.0.0.jar` into `.minecraft/mods`. Install Fabric Loader for Minecraft 1.21.1 and a matching Fabric API release.

## Summoning pattern

Place the blocks like an iron golem: one aluminum block above the center of a horizontal row of three aluminum blocks, then place a carved pumpkin on top of the upper block. The four aluminum blocks and pumpkin are consumed when the golem appears.

## Notes

- Mod ID: `aluminum_construct`
- Minecraft: `1.21.1`
- Loader: Fabric
- Java: 21
