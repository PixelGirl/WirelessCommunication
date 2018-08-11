package moe.pixelgirl.wirelesscommunication.common.tile;
import cofh.core.network.PacketCoFHBase;
import net.minecraft.nbt.NBTTagCompound;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public abstract class TileActivatable extends TileInventory {

    protected boolean isActive;

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        isActive = nbt.getBoolean("Active");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setBoolean("Active", isActive);
    }

    @Override
    public PacketCoFHBase getPacket() {
        PacketCoFHBase payload = super.getPacket();
        payload.addBool(isActive);
        return payload;
    }
}
