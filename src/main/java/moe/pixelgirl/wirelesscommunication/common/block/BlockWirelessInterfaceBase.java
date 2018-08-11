package moe.pixelgirl.wirelesscommunication.common.block;
import net.minecraft.block.ITileEntityProvider;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block
 * Created by Pixel.
 */
public abstract class BlockWirelessInterfaceBase extends BlockMachineBase implements ITileEntityProvider {

    protected BlockWirelessInterfaceBase(String unlocalisedName) {
        super(unlocalisedName);
    }
}
