package net.pathbatch.firstmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pathbatch.firstmod.PathBatchFirstMod;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PathBatchFirstMod.MOD_ID);

    public static final Supplier<CreativeModeTab> MODDED_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("modded_items_tab", () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.firstmod.modded_items_tab"))
                            .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.BLACK_OPAL);
                                pOutput.accept(ModItems.RAW_BLACK_OPAL);
                                pOutput.accept(ModItems.EMBER_MELON_SEEDS);
                            }).build());

    public static final Supplier<CreativeModeTab> MODDED_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("modded_blocks_tab", () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.firstmod.modded_blocks_tab"))
                            .icon(() -> new ItemStack(ModItems.RAW_BLACK_OPAL.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PathBatchFirstMod.MOD_ID, "modded_items_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(Blocks.STONE);
                                pOutput.accept(Blocks.CHISELED_COPPER);
                            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
