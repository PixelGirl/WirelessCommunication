package moe.pixelgirl.wirelesscommunication.common.tile;
import cofh.api.energy.EnergyStorage;
import moe.pixelgirl.wirelesscommunication.common.block.BlockMachineBase;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public abstract class TileWirelessInterfaceBase extends TileMachineBase {

    public TileWirelessInterfaceBase(BlockMachineBase.Types type) {
        super(type);
        energyStorage = new EnergyStorage(10240, maxEnergyTransfer);
        connectDirections.add(0);
        connectDirections.add(1);
        connectDirections.add(2);
        connectDirections.add(3);
        connectDirections.add(4);
        connectDirections.add(5);
    }
}
