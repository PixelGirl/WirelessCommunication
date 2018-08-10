package moe.pixelgirl.wirelesscommunication.common.block.simple;
import cofh.core.util.CoreUtils;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import cofh.api.block.IDismantleable;
import moe.pixelgirl.wirelesscommunication.common.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block.simple
 * Created by Pixel.
 */
public class BlockFrame extends Block implements IDismantleable {

    public IIcon[] icons = new IIcon[2];

    public BlockFrame(String unlocalisedName) {
        super(Material.iron);
        this.setBlockName(unlocalisedName).setHardness(2.5f).setStepSound(soundTypeMetal).setCreativeTab(WirelessCommunication.tabWirelessComm).setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName(WirelessCommunication.MODID + ":" + unlocalisedName);
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        icons[0] = register.registerIcon(WirelessCommunication.MODID + ":machine_frame_side");
        icons[1] = register.registerIcon(WirelessCommunication.MODID + ":machine_frame_top");
    }

    public IIcon getIcon(int side, int meta) {
        return ((side == 0) || (side == 1)) ? icons[1] : icons[0];
    }

    /* IDismantleable */

    @Override
    public ArrayList<ItemStack> dismantleBlock(EntityPlayer player, World world, int x, int y, int z, boolean returnDrops) {
        return BlockHelper.dismantleBlock(player, world, x, y, z, returnDrops);
    }

    @Override
    public boolean canDismantle(EntityPlayer player, World world, int x, int y, int z) {
        return true;
    }
}
