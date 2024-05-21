package net.akki.server;

import net.akki.common.utils.Register;
import net.minecraft.block.Block;


public class Blocks {
    public static final Block TestBlock = new Block(Block.Settings.create().strength(4.0f));
    public static final Block akkiThink = new Block(Block.Settings.create().strength(4.0f));
    private static final Register register = new Register();
    public static void RegisterAllBlocks() {
        register.RegisterBlock("test_block", TestBlock);
        register.RegisterBlock("akki_think", akkiThink);
    }
}
