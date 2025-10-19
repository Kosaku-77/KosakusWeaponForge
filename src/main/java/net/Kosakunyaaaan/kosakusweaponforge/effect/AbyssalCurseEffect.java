package net.Kosakunyaaaan.kosakusweaponforge.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class AbyssalCurseEffect extends MobEffect {
    public AbyssalCurseEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 10, 2*pAmplifier, true, true,false));
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, pAmplifier, true, false,false));
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2, pAmplifier, true, false, false));

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
