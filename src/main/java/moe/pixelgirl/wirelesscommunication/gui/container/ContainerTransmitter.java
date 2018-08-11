package moe.pixelgirl.wirelesscommunication.gui.container;
import cofh.lib.gui.slot.SlotEnergy;
import cofh.lib.gui.slot.SlotRemoveOnly;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessTransmitter;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.gui.container
 * Created by Pixel.
 */
public class ContainerTransmitter extends ContainerWirelessCommBase {

    private TileWirelessTransmitter myTile;

    public ContainerTransmitter(InventoryPlayer inventory, TileEntity tile) {
        super(inventory, tile, true);

        myTile = (TileWirelessTransmitter) tile;

        for(int i = 0; i < 3; i++) {
            addSlotToContainer(new Slot(myTile, i, 44 + i * 18, 35));
        }
        addSlotToContainer(new SlotRemoveOnly(myTile, 3, 130, 35));
        addSlotToContainer(new SlotEnergy(myTile, myTile.getChargeSlot(), 8, 53));
    }
}
