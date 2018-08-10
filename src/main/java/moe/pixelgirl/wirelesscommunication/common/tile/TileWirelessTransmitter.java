package moe.pixelgirl.wirelesscommunication.common.tile;
import moe.pixelgirl.wirelesscommunication.common.WirelessCommBlocks;
import moe.pixelgirl.wirelesscommunication.common.block.BlockMachineBase;
import moe.pixelgirl.wirelesscommunication.common.block.BlockWirelessTransmitter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public class TileWirelessTransmitter extends TileWirelessInterfaceBase {

    public TileWirelessTransmitter() {
        super(BlockMachineBase.Types.TRANSMITTER);
        blockMachineBase = (BlockWirelessTransmitter) WirelessCommBlocks.wirelessTransmitter;
        inventory = new ItemStack[5];
    }

    @Override
    public String getInventoryName() {
        return "machine.transmitter";
    }

    @Override
    public void update() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack item) {
        return slot == 0 || slot == 1 || slot == 2;
    }
}
