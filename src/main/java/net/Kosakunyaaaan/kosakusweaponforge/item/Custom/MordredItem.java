package net.Kosakunyaaaan.kosakusweaponforge.item.Custom;

import net.Kosakunyaaaan.kosakusweaponforge.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MordredItem extends SwordItem {

    public MordredItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties){
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        // Shift
        if(Screen.hasShiftDown()){ pTooltipComponents.add(Component.translatable("tooltip.shift.kosakusweaponforge.mordred").withStyle(ChatFormatting.DARK_RED)); }
        // Non-Shift
        else { pTooltipComponents.add(Component.translatable("tooltip.kosakusweaponforge.mordred").withStyle(ChatFormatting.DARK_GRAY)); }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);


    }
    // On-hit effects
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        MobEffectInstance abyssal_curse = new MobEffectInstance(ModEffects.ABYSSAL_CURSE.get(), 80, 2);
        target.addEffect(abyssal_curse);
        return true;
    }



    // AOE Right-click effect
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand){
        ItemStack stack = player.getItemInHand(hand);
        if (!world.isClientSide){
            ServerLevel serverWorld = (ServerLevel) world;
            double radius = 10.0d;
            AABB area = new AABB(
                    player.getX() - radius, player.getY() - radius, player.getZ() - radius,
                    player.getX() + radius, player.getY() + radius, player.getZ() + radius);
            List<LivingEntity> targets = world.getEntitiesOfClass(LivingEntity.class, area, e -> e != player && e.isAlive());
            //player.displayClientMessage(net.minecraft.network.chat.Component.literal(targets.toString()), false);
            MobEffectInstance abyssalBind = new MobEffectInstance(ModEffects.ABYSSAL_CURSE.get(), 240, 9);
            // "for" loop: loops through every target in the array
            for (LivingEntity target : targets){
                target.addEffect(abyssalBind);

                }
            }
        return InteractionResultHolder.success(stack);
    }



}
