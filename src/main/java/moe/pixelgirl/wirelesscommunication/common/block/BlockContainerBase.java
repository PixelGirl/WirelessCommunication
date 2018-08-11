package moe.pixelgirl.wirelesscommunication.common.block;
import cofh.core.block.BlockCoFHBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block
 * Created by Pixel.
 */
public abstract class BlockContainerBase extends BlockCoFHBase {
    public BlockContainerBase(Material material) {
        super(material);
        this.isBlockContainer = true;
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_) {
        super.breakBlock(world, x, y, z, block, p_149749_6_);
        world.removeTileEntity(x, y, z);
    }

    public boolean onBlockEventReceived(World world, int x, int y, int z, int id, int value) {
        super.onBlockEventReceived(world, x, y, z, id, value);
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        return tileEntity != null && tileEntity.receiveClientEvent(id, value);
    }
}
