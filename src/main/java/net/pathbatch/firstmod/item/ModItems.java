package net.pathbatch.firstmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pathbatch.firstmod.PathBatchFirstMod;

public class ModItems {
    public static final DeferredRegister.Items  ITEMS = DeferredRegister.createItems(PathBatchFirstMod.MOD_ID);

    public static DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static DeferredItem<Item> RAW_BLACK_OPAL = ITEMS.registerItem("raw_black_opal", Item::new, new Item.Properties());
    public static DeferredItem<Item> EMBER_MELON_SEEDS = ITEMS.registerSimpleItem("ember_melon_seeds");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

