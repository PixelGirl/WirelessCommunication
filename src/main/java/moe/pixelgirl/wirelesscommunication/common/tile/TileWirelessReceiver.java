package moe.pixelgirl.wirelesscommunication.common.tile;
import moe.pixelgirl.wirelesscommunication.common.WirelessCommBlocks;
import moe.pixelgirl.wirelesscommunication.common.block.BlockMachineBase;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public class TileWirelessReceiver extends TileWirelessInterfaceBase {
    public TileWirelessReceiver() {
        super(BlockMachineBase.Types.RECEIVER);
        blockMachineBase = (BlockMachineBase) WirelessCommBlocks.wirelessReceiver;
    }

    @Override
    public String getInventoryName() {
        return "machine.receiver";
    }

    @Override
    public void update() {

    }

    @Override
    public boolean hasChargeSlot() {
        return false;
    }
}