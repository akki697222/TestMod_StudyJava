package net.akki;

import net.akki.common.utils.Register;
import net.fabricmc.api.ModInitializer;
import net.akki.server.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String mod_id = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(mod_id);
	public static final Register register = new Register();
	@Override
	public void onInitialize() {
		Blocks.RegisterAllBlocks();
		Items.RegisterAllItems();
		register.RegisterItemGroup();
		LOGGER.info("Initialized.");
	}
}
