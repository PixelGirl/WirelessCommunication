package moe.pixelgirl.wirelesscommunication.common.block;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessTransmitter;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block
 * Created by Pixel.
 */
public class BlockWirelessTransmitter extends BlockWirelessInterfaceBase {

    public BlockWirelessTransmitter(String unlocalisedName) {
        super(unlocalisedName);
    }

    @Override
    public void registerBlockIcons(IIconRegister register){
        super.registerBlockIcons(register);
        icons[2] = register.registerIcon(WirelessCommunication.MODID + ":wireless_transmitter_front");
        icons[3] = register.registerIcon(WirelessCommunication.MODID + ":wireless_transmitter_front_active");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileWirelessTransmitter();
    }

    @Override
    int getGuiId() {
        return 1;
    }
}
