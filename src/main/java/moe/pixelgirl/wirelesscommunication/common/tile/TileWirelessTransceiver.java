package moe.pixelgirl.wirelesscommunication.common.tile;
import moe.pixelgirl.wirelesscommunication.common.WirelessCommBlocks;
import moe.pixelgirl.wirelesscommunication.common.block.BlockMachineBase;
import moe.pixelgirl.wirelesscommunication.common.block.BlockWirelessTransceiver;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public class TileWirelessTransceiver extends TileWirelessInterfaceBase {
    public TileWirelessTransceiver() {
        super(BlockMachineBase.Types.TRANSCEIVER);
        blockMachineBase = (BlockWirelessTransceiver) WirelessCommBlocks.wirelessTransceiver;
    }

    @Override
    public String getInventoryName() {
        return "machine.transceiver";
    }

    @Override
    public void update() {

    }
}
