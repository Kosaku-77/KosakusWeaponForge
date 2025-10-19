package net.Kosakunyaaaan.kosakusweaponforge.effect;

import net.Kosakunyaaaan.kosakusweaponforge.KosakusWeaponForge;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, KosakusWeaponForge.MOD_ID);

    public static final RegistryObject<MobEffect> ABYSSAL_CURSE = EFFECTS.register("abyssal_curse",
            () -> new AbyssalCurseEffect(MobEffectCategory.NEUTRAL, 0));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

}
