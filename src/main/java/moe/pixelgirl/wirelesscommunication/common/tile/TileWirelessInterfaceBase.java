package moe.pixelgirl.wirelesscommunication.common.tile;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import moe.pixelgirl.wirelesscommunication.common.block.BlockMachineBase;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

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
