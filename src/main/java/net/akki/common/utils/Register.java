package net.akki.common.utils;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private static final String mod_id = "testmod"; //必要に応じて変更しやがれください
    public static final Logger LOGGER = LoggerFactory.getLogger(mod_id);
    private static final String ItemGroupId = "itemGroup." + mod_id + "." + mod_id; //langファイル作るときに必要
    public static final List<Item> items = new ArrayList<>(); //アイテムグループに追加したアイテムを入れるとき必要
    public static final List<Block> blocks = new ArrayList<>(); //アイテムグループに追加したブロック(アイテム)を入れるとき必要
    public static final ItemGroup ModGroup = FabricItemGroup.builder()
            .icon(() -> new ItemStack(net.akki.server.Items.akki))
            .displayName(Text.translatable(ItemGroupId))
            .entries((context, entries) -> {
                for (Item item : items) {
                    entries.add(new ItemStack(item));
                }
                for (Block block : blocks) {
                    entries.add(new ItemStack(block));
                }
            })
            .build();
    public void RegisterItem(String path, Item item) {
        Registry.register(Registries.ITEM, new Identifier(mod_id, path), item);
        items.add(item);
        LOGGER.info("Registered item '" + path + "'");
    }
    public void RegisterBlock(String path, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(mod_id, path), block);
        blocks.add(block);
        LOGGER.info("Registered block '" + path + "'");
        Registry.register(Registries.ITEM, new Identifier(mod_id, path), new BlockItem(block, new Item.Settings()));
        LOGGER.info("Registered blockitem '" + path + "'");
    }
    public void RegisterItemGroup() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(mod_id, mod_id), ModGroup);
    }
}
