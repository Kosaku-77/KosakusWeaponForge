package net.Kosakunyaaaan.kosakusweaponforge.item;

import net.Kosakunyaaaan.kosakusweaponforge.KosakusWeaponForge;
import net.Kosakunyaaaan.kosakusweaponforge.item.Custom.MordredItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KosakusWeaponForge.MOD_ID);

    // public static final Item NETHERITE_SWORD = registerItem("netherite_sword", new SwordItem(Tiers.NETHERITE, 3, -2.4F, (new Item.Properties()).fireResistant()));

    public static final RegistryObject<Item> MORDRED = ITEMS.register("mordred",
            () -> new MordredItem(Tiers.NETHERITE, 10, -3.0f, new Item.Properties()
                    .rarity(KosakusWeaponForge.ABYSSAL)
                    .stacksTo(1)
                    .defaultDurability(-1)
                    .fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
