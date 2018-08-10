package moe.pixelgirl.wirelesscommunication.common.block;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessTransceiver;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block
 * Created by Pixel.
 */
public class BlockWirelessTransceiver extends BlockWirelessInterfaceBase implements ITileEntityProvider {

    public BlockWirelessTransceiver(String unlocalisedName) {
        super(unlocalisedName);
    }

    public void registerBlockIcons(IIconRegister register){
        super.registerBlockIcons(register);
        icons[2] = register.registerIcon(WirelessCommunication.MODID + ":wireless_transceiver_front");
        icons[3] = register.registerIcon(WirelessCommunication.MODID + ":wireless_transceiver_front_active");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileWirelessTransceiver();
    }

    @Override
    int getGuiId() {
        return 3;
    }
}
