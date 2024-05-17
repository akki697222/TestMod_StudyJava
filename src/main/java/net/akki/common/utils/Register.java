package net.akki.common.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.akki.common.utils.Register;
public class Register {
    public static final Logger LOGGER = LoggerFactory.getLogger("testmod");
    public void RegisterItem(String path, Item item) {
        Registry.register(Registries.ITEM, new Identifier("testmod", path), item);
        LOGGER.info("Registered item '" + path + "'");
    }
    public void RegisterBlock(String path, Block block) {
        Registry.register(Registries.BLOCK, new Identifier("testmod", path), block);
        LOGGER.info("Registered block '" + path + "'");
    }
}