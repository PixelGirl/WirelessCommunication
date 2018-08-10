package moe.pixelgirl.wirelesscommunication.common.tile;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.IEnergyReceiver;
import cofh.core.network.PacketCoFHBase;
import cofh.lib.util.helpers.EnergyHelper;
import net.minecraftforge.common.util.ForgeDirection;
import java.util.ArrayList;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public abstract class TilePowered extends TileReconfigurable implements IEnergyReceiver {
    protected EnergyStorage energyStorage = new EnergyStorage(0);
    protected int maxEnergyTransfer = 720;
    protected ArrayList connectDirections = new ArrayList();

    public TilePowered() {
        super();
    }

    @Override
    public PacketCoFHBase getPacket() {
        PacketCoFHBase payload = super.getPacket();
        payload.addInt(energyStorage.getEnergyStored());
        return payload;
    }

    public abstract int getChargeSlot();

    public abstract boolean hasChargeSlot();

    protected void chargeEnergy() {
        int chargeSlot = getChargeSlot();
        if(!hasChargeSlot() || !EnergyHelper.isEnergyContainerItem(inventory[chargeSlot])) return;
        int energyRequest = Math.min(energyStorage.getMaxReceive(), energyStorage.getMaxEnergyStored() - energyStorage.getEnergyStored());
        energyStorage.receiveEnergy(((IEnergyContainerItem) inventory[chargeSlot].getItem()).extractEnergy(inventory[chargeSlot], energyRequest, false), false);
        if(inventory[chargeSlot].stackSize <= 0) inventory[chargeSlot] = null;
    }

    /* IEnergyReceiver */

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
        return connectDirections.contains(from.ordinal()) && from.ordinal() != facing;
    }
}
