package net.akki;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.akki.common.utils.Register;

public class TestMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("testmod");
	public static final Item TestItem = new Item(new FabricItemSettings());
	public static final Block TestBlock = new Block(Block.Settings.create().strength(4.0f));
	public static final Register register = new Register();

	private static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(TestItem))
			.displayName(Text.translatable("itemGroup.testmod.testmod"))
			.entries((context, entries) -> {
				entries.add(TestItem);
			})
			.build();

	@Override
	public void onInitialize() {
		register.RegisterItem("test_item", TestItem);
		register.RegisterBlock("test_block", TestBlock);
		Registry.register(Registries.ITEM_GROUP, new Identifier("testmod", "testmod"), CUSTOM_ITEM_GROUP);

		LOGGER.info("Initialized.");
	}
}
