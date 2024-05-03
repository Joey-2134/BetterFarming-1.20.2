package net.joey.betterfarming.sound;

import net.joey.betterfarming.BetterFarming;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(BetterFarming.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        BetterFarming.LOGGER.info("Registering Sounds for " + BetterFarming.MOD_ID);
    }
}
