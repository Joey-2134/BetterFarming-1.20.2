package net.joey.tutorialmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
    }
}
