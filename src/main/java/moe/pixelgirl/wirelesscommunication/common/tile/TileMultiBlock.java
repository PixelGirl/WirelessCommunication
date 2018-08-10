package moe.pixelgirl.wirelesscommunication.common.tile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public abstract class TileMultiBlock extends TileWirelessCommBase {
    protected boolean isMaster;
    protected boolean hasMaster;

    protected int masterX;
    protected int masterY;
    protected int masterZ;

    @Override
    public void updateEntity() {
        super.updateEntity();
        if(!worldObj.isRemote && !hasMaster && checkValidMultiBlock()) setupMultiBlock();
    }

    public abstract boolean checkValidMultiBlock();

    public abstract void setupMultiBlock();

    public abstract void resetMultiBlock();

    public void reset() {
        isMaster = false;
        hasMaster = false;
        masterX = 0;
        masterY = 0;
        masterZ = 0;
    }

    public boolean masterExists() {
        TileEntity tileEntity = worldObj.getTileEntity(masterX, masterY, masterZ);
        return tileEntity instanceof TileMultiBlock && ((TileMultiBlock) tileEntity).isMaster;
    }

    public TileMultiBlock getMaster() {
        if(!hasMaster) return null;
        return (TileMultiBlock) worldObj.getTileEntity(masterX, masterY, masterZ);
    }

    public TileMultiBlock getMaster(World world) {
        if(!hasMaster) return null;
        return (TileMultiBlock) world.getTileEntity(masterX, masterY, masterZ);
    }

    @Override
    public void writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("masterX", masterX);
        data.setInteger("masterY", masterY);
        data.setInteger("masterZ", masterZ);
        data.setBoolean("isMaster", isMaster);
        data.setBoolean("hasMaster", hasMaster);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        masterX = data.getInteger("masterX");
        masterY = data.getInteger("masterY");
        masterZ = data.getInteger("masterZ");
        isMaster = data.getBoolean("isMaster");
        hasMaster = data.getBoolean("hasMaster");
    }

    public boolean isMaster() {
        return isMaster;
    }

    public boolean hasMaster() {
        return hasMaster;
    }

    public int masterX() {
        return masterX;
    }

    public int masterY() {
        return masterY;
    }

    public int masterZ() {
        return masterZ;
    }

    public boolean getIsMaster() {
        return isMaster;
    }

    public boolean getHasMaster() {
        return hasMaster;
    }

    public int getMasterX() {
        return masterX;
    }

    public int getMasterY() {
        return masterY;
    }

    public int getMasterZ() {
        return masterZ;
    }

    public void setIsMaster(boolean isMaster) {
        this.isMaster = isMaster;
    }

    public void setHasMaster(boolean hasMaster) {
        this.hasMaster = hasMaster;
    }

    public void setMasterLocation(int x, int y, int z) {
        masterX = x;
        masterY = y;
        masterZ = z;
    }

    public void setMasterX(int x) {
        masterX = x;
    }

    public void setMasterY(int y) {
        masterY = y;
    }

    public void setMasterZ(int z) {
        masterZ = z;
    }
}
