package moe.pixelgirl.wirelesscommunication.common.block;
import cofh.api.block.IDismantleable;
import moe.pixelgirl.wirelesscommunication.common.util.BlockHelper;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import java.util.ArrayList;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block
 * Created by Pixel.
 */
public abstract class BlockWirelessCommBase extends BlockContainerBase implements IDismantleable {
    public BlockWirelessCommBase(Material material) {
        super(material);
    }

    /* IDismantleable */

    @Override
    public ArrayList<ItemStack> dismantleBlock(EntityPlayer player, World world, int x, int y, int z, boolean returnDrops) {
        return BlockHelper.dismantleBlock(player, world, x, y, z, returnDrops);
    }
}
