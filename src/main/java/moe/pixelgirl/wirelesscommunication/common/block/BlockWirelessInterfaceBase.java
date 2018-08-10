package moe.pixelgirl.wirelesscommunication.common.block;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessInterfaceBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block
 * Created by Pixel.
 */
public abstract class BlockWirelessInterfaceBase extends BlockMachineBase implements ITileEntityProvider {

    protected BlockWirelessInterfaceBase(String unlocalisedName) {
        super(unlocalisedName);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float lx, float ly, float lz) {
        if(world.isRemote) return true;

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof TileWirelessInterfaceBase) {
            player.openGui(WirelessCommunication.instance, getGuiId(), world, x, y, z);
            return true;
        }
        return false;
    }

    abstract int getGuiId();
}
