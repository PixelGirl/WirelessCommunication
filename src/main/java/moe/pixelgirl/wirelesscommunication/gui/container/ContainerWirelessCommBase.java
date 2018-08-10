package moe.pixelgirl.wirelesscommunication.gui.container;
import cofh.lib.gui.container.ContainerBase;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessCommBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.gui.container
 * Created by Pixel.
 */
public abstract class ContainerWirelessCommBase extends Container {

    public final TileWirelessCommBase baseTile;

    protected boolean hasPlayerInvSlots = true;

    public ContainerWirelessCommBase() {
        baseTile = null;
    }

    public ContainerWirelessCommBase(TileEntity tile) {
        baseTile = (TileWirelessCommBase) tile;
    }

    public ContainerWirelessCommBase(InventoryPlayer inventory, TileEntity tile) {
        this(inventory, tile, true);
    }

    public ContainerWirelessCommBase(InventoryPlayer inventory, TileEntity tile, boolean playerInv) {
        baseTile = tile instanceof TileWirelessCommBase ? (TileWirelessCommBase) tile : null;

        hasPlayerInvSlots = playerInv;

        if(hasPlayerInvSlots) integratePlayerInventory(inventory);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotRaw) {
        ItemStack item;
        Slot slot = (Slot) inventorySlots.get(slotRaw);
        if(slot == null || !slot.getHasStack()) return null;
        ItemStack itemInSlot = slot.getStack();
        item = itemInSlot.copy();
        if(slotRaw < 3 * 9) {
            if(!mergeItemStack(itemInSlot, 3 * 9, inventorySlots.size(), true)) return null;
        }else if(!mergeItemStack(itemInSlot, 0, 3 * 9, false)) return null;
        if(itemInSlot.stackSize == 0) slot.putStack(null);
        else slot.onSlotChanged();
        return item;
    }

    protected int getPlayerInventoryVerticalOffset() {
        return 84;
    }

    protected int getPlayerInventoryHorizontalOffset() {
        return 8;
    }

    protected int getSizeInventory() {
        if(baseTile instanceof IInventory) return ((IInventory) baseTile).getSizeInventory();
        return 0;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        if(baseTile == null) return;
        for (Object crafter : crafters) {
            baseTile.sendGuiNetworkData(this, (ICrafting) crafter);
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return baseTile != null && baseTile.isUseable(entityPlayer);
    }

    public void integratePlayerInventory(InventoryPlayer inventory) {
        int xOff = getPlayerInventoryHorizontalOffset();
        int yOff = getPlayerInventoryVerticalOffset();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventory, j + i * 9 + 9, xOff + j * 18, yOff + i * 18));
            }
        }
        for(int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventory, i, xOff + i * 18,142));
        }
    }
}
