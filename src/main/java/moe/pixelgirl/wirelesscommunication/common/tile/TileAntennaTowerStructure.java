package moe.pixelgirl.wirelesscommunication.common.tile;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import java.util.ArrayList;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public class TileAntennaTowerStructure extends TileMultiBlock implements IEnergyReceiver {

    public int tier;

    protected EnergyStorage energyStorage = new EnergyStorage(0);
    protected int maxEnergyTransfer = 720;
    protected ArrayList connectDirections = new ArrayList();

    public TileAntennaTowerStructure() {
        energyStorage = new EnergyStorage(10240, maxEnergyTransfer);
        connectDirections.add(2);
        connectDirections.add(3);
        connectDirections.add(4);
        connectDirections.add(5);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
    }

    @Override
    public boolean checkValidMultiBlock() {
        int i = 0;
        for (int y = yCoord; y < yCoord + 12; y++) {
            TileEntity tile = worldObj.getTileEntity(xCoord, y, zCoord);
            if (tile instanceof TileAntennaTowerStructure) {
                TileAntennaTowerStructure towerStructureEntity = (TileAntennaTowerStructure) tile;
                if (this.isMaster && towerStructureEntity.hasMaster) i++;
                else if (!towerStructureEntity.hasMaster) i++;
            }
        }
        return i >= 12;
    }

    @Override
    public void setupMultiBlock() {
        for (int y = yCoord; y < yCoord + 12; y++) {
            TileEntity tile = worldObj.getTileEntity(xCoord, y, zCoord);
            if (tile instanceof TileAntennaTowerStructure) {
                TileAntennaTowerStructure towerStructureEntity = (TileAntennaTowerStructure) tile;
                towerStructureEntity.setMasterLocation(xCoord, yCoord, zCoord);
                towerStructureEntity.setHasMaster(true);
                towerStructureEntity.setIsMaster(y == yCoord);
                towerStructureEntity.tier = 1;
                worldObj.setBlockMetadataWithNotify(xCoord, y, zCoord, towerStructureEntity.isMaster ? 2 : 1, 2);
            }
        }
    }

    @Override
    public void resetMultiBlock() {
        int masterXC = masterX;
        int masterYC = masterY;
        int masterZC = masterZ;

        for (int y = masterYC; y < masterYC + 12; y++) {
            TileEntity tile = worldObj.getTileEntity(masterXC, y, masterZC);
            if (tile instanceof TileAntennaTowerStructure) {
                TileAntennaTowerStructure towerStructureEntity = (TileAntennaTowerStructure) tile;
                towerStructureEntity.reset();
            }
        }
    }

    @Override
    public void reset() {
        super.reset();
        tier = 0;
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 2);
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return checkValidMultiBlock() ? AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 12, zCoord + 1) : AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
    }

    @Override
    public void writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        energyStorage.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        energyStorage.readFromNBT(data);
    }

    @Override
    public String getName() {
        return "tile." + WirelessCommunication.MODID.toLowerCase() + ".antenna.structure.name";
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return energyStorage.receiveEnergy(Math.min(maxEnergyTransfer, maxExtract), simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return energyStorage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return energyStorage.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return connectDirections.contains(from.ordinal()) && energyStorage.getMaxEnergyStored() > 0 && isMaster;
    }
}
