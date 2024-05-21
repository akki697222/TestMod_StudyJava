package net.akki.server;

import net.akki.common.utils.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Items {
    public static final Item TestItem = new Item(new FabricItemSettings());
    public static final Item akki = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(20).saturationModifier(20f).build()));
    private static final Register register = new Register();
    public static void RegisterAllItems() {
        register.RegisterItem("test_item", TestItem);
        register.RegisterItem("akki", akki);
        FuelRegistry.INSTANCE.add(akki, 300);
    }
}
