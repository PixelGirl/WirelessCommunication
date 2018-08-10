package moe.pixelgirl.wirelesscommunication.common.tile;
import cofh.core.network.PacketCoFHBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public abstract class TileInventory extends TileWirelessCommBase implements ISidedInventory {

    public ItemStack[] inventory = new ItemStack[0];

    public TileInventory() {
        super();
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < inventory.length; i++) {
            ItemStack item = inventory[i];
            if (item == null) continue;
            NBTTagCompound tagCompound = new NBTTagCompound();
            tagCompound.setByte("Slot", (byte) i);
            inventory[i].writeToNBT(tagCompound);
            list.appendTag(tagCompound);
        }
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList list = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        inventory = new ItemStack[getSizeInventory()];
        for(int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound tagCompound = list.getCompoundTagAt(i);
            int j = tagCompound.getByte("Slot") & 0xff;
            if(j < inventory.length) inventory[j] = ItemStack.loadItemStackFromNBT(tagCompound);
        }
    }

    @Override
    public PacketCoFHBase getPacket() {
        return super.getPacket();
    }

    /* ISidedInventory */

    @Override
    public abstract String getInventoryName();

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public void openInventory(){}

    @Override
    public void closeInventory(){}

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        inventory[slot] = itemStack;
        if(itemStack != null && itemStack.stackSize > getInventoryStackLimit()) itemStack.stackSize = getInventoryStackLimit();
        markDirty();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if(inventory[slot] == null) return null;
        ItemStack itemStack = inventory[slot];
        inventory[slot] = null;
        return itemStack;
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if(inventory[slot] == null) return null;
        ItemStack itemStack;
        itemStack = inventory[slot].stackSize == amount ? inventory[slot] : inventory[slot].splitStack(amount);
        if(inventory[slot].stackSize <= 0) inventory[slot] = null;
        markDirty();
        return itemStack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack item) {
        return true;
    }

    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityPlayer.getDistanceSq((double) xCoord + .5, (double) yCoord + .5, (double) zCoord + .5) <= 64;
    }
}
