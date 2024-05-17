package net.akki.server.blocks;

import net.minecraft.block.Block;

import net.akki.common.utils.Register;

public class TestBlock extends Block {
    public static final Register register = new Register();
    public TestBlock(Settings settings) {
        super(settings);
        settings.strength(4.0f);
    }
}

