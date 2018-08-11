package moe.pixelgirl.wirelesscommunication.common.tile;
import cofh.core.network.PacketCoFHBase;
import moe.pixelgirl.wirelesscommunication.common.util.SideConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cofh.api.tileentity.IReconfigurableSides;
import cofh.lib.util.helpers.BlockHelper;
import cofh.api.tileentity.IReconfigurableFacing;
import cofh.api.tileentity.ISidedTexture;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public abstract class TileReconfigurable extends TileActivatable implements IReconfigurableFacing, IReconfigurableSides, ISidedTexture {

    protected SideConfig sideConfig;

    protected byte facing = 3;
    public byte[] sideCache = { 0, 0, 0, 0, 0, 0 };

    public TileReconfigurable() {
        super();
    }

    @Override
    public boolean onWrench(EntityPlayer player, int hitSide) {
        return incrSide(hitSide);
    }

    public byte[] getDefaultSides() {
        return sideConfig.defaultSides;
    }

    public void setDefaultSides() {
        sideCache = getDefaultSides();
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        facing = nbt.hasKey("Facing") ? nbt.getByte("Facing") : 3;
        byte[] retSides = nbt.getByteArray("SideCache");
        sideCache = retSides.length < 6 ? getDefaultSides().clone() : retSides;
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setByte("Facing", facing);
        nbt.setByteArray("SideCache", sideCache);
    }

    @Override
    public PacketCoFHBase getPacket() {
        PacketCoFHBase payload = super.getPacket();
        payload.addByteArray(sideCache);
        payload.addByte(facing);
        return payload;
    }

    /* ISidedInventory */

    public int[] getAccessibleSlotsFromSide(int side) {
        return sideConfig.slotGroups[sideCache[side]];
    }

    public boolean canInsertItem(int slot, ItemStack item, int side) {
        return isItemValidForSlot(slot, item) && sideConfig.allowInsertionSide[sideCache[side]] && sideConfig.allowInsertionSlot[slot];
    }

    public boolean canExtractItem(int slot, ItemStack item, int side) {
        return sideConfig.allowExtractionSide[sideCache[side]] && sideConfig.allowExtractionSlot[slot];
    }

    /* ISidedTexture */

    @Override
    public abstract IIcon getTexture(int side, int pass);

    /* IReconfigurableFacing */

    @Override
    public int getFacing() {
        return facing;
    }

    @Override
    public boolean allowYAxisFacing() {
        return false;
    }

    @Override
    public boolean rotateBlock() {
        if(allowYAxisFacing()) {
            byte[] tempCache = new byte[6];

            switch(facing) {
                case 0:
                    for (int i = 0; i < 6; i++) {
                        tempCache[i] = sideCache[BlockHelper.INVERT_AROUND_X[i]];
                    }
                    break;
                case 1:
                    for (int i = 0; i < 6; i++) {
                        tempCache[i] = sideCache[BlockHelper.ROTATE_CLOCK_X[i]];
                    }
                    break;
                case 2:
                    for (int i = 0; i < 6; i++) {
                        tempCache[i] = sideCache[BlockHelper.INVERT_AROUND_Y[i]];
                    }
                    break;
                case 3:
                    for (int i = 0; i < 6; i++) {
                        tempCache[i] = sideCache[BlockHelper.ROTATE_CLOCK_Y[i]];
                    }
                    break;
                case 4:
                    for (int i = 0; i < 6; i++) {
                        tempCache[i] = sideCache[BlockHelper.INVERT_AROUND_Z[i]];
                    }
                    break;
                case 5:
                    for (int i = 0; i < 6; i++) {
                        tempCache[i] = sideCache[BlockHelper.ROTATE_CLOCK_Z[i]];
                    }
                    break;
            }
            sideCache = tempCache.clone();
            facing++;
            facing %= 6;
            markDirty();
            sendUpdatePacket(Side.CLIENT);
            return true;
        }
        if(isActive) return false;
        byte[] tempCache = new byte[6];
        for (int i = 0; i < 6; i++) {
            tempCache[i] = sideCache[BlockHelper.ROTATE_CLOCK_Y[i]];
        }
        sideCache = tempCache.clone();
        facing = BlockHelper.SIDE_LEFT[facing];
        markDirty();
        sendUpdatePacket(Side.CLIENT);
        return true;
    }

    @Override
    public boolean setFacing(int side) {
        if(side < 0 || side > 5 || (!allowYAxisFacing() && side < 2)) return false;
        facing = (byte) side;
        markDirty();
        sendUpdatePacket(Side.CLIENT);
        return true;
    }

    /* IReconfigurableSides */

    @Override
    public boolean decrSide(int side) {
        if(side == facing) return false;
        sideCache[side] += getNumConfig(side) - 1;
        sideCache[side] %= getNumConfig(side);
        sendUpdatePacket(Side.SERVER);
        return true;
    }

    @Override
    public boolean incrSide(int side) {
        if(side == facing) return false;
        sideCache[side] += 1;
        sideCache[side] %= getNumConfig(side);
        sendUpdatePacket(Side.SERVER);
        return true;
    }

    @Override
    public boolean setSide(int side, int config) {
        if(side == facing || sideCache[side] == config || config >= getNumConfig(side)) return false;
        sideCache[side] = (byte) config;
        sendUpdatePacket(Side.SERVER);
        return true;
    }

    @Override
    public boolean resetSides() {
        boolean update = false;
        for(int i = 0; i < sideCache.length; i++) {
            if(sideCache[i] <= 0) continue;
            sideCache[i] = 0;
            update = true;
        }
        return update;
    }

    @Override
    public int getNumConfig(int side) {
        return sideConfig.numConfig;
    }
}
