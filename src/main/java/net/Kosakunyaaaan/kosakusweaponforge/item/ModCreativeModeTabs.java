package net.Kosakunyaaaan.kosakusweaponforge.item;

import net.Kosakunyaaaan.kosakusweaponforge.KosakusWeaponForge;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Parameter;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KosakusWeaponForge.MOD_ID);

    public static final RegistryObject<CreativeModeTab> KOSAKUS_WEAPONS_FORGE_TAB = CREATIVE_MODE_TABS.register("kosakus_weapon_forge",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MORDRED.get()))
                    .title(Component.translatable("creativetab.kosakus_weapon_forge"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MORDRED.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
