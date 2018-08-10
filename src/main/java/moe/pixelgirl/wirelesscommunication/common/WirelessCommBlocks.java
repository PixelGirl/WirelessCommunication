package moe.pixelgirl.wirelesscommunication.common;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.block.BlockAntennaTowerStructure;
import moe.pixelgirl.wirelesscommunication.common.block.BlockWirelessReceiver;
import moe.pixelgirl.wirelesscommunication.common.block.BlockWirelessTransceiver;
import moe.pixelgirl.wirelesscommunication.common.block.BlockWirelessTransmitter;
import moe.pixelgirl.wirelesscommunication.common.block.simple.BlockFrame;
import moe.pixelgirl.wirelesscommunication.common.tile.TileAntennaTowerStructure;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessReceiver;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessTransceiver;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessTransmitter;
import net.minecraft.block.Block;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common
 * Created by Pixel.
 */
public class WirelessCommBlocks {

    public static Block machineFrame;
    public static Block antennaTowerStructure;

    public static Block wirelessTransmitter;
    public static Block wirelessReceiver;
    public static Block wirelessTransceiver;
    
    static String modId = WirelessCommunication.MODID.toLowerCase();

    public static void preInit() {
        machineFrame = new BlockFrame("machine_frame");
        GameRegistry.registerBlock(machineFrame, "machine_frame");

        antennaTowerStructure = new BlockAntennaTowerStructure("antenna_tower_structure");
        GameRegistry.registerBlock(antennaTowerStructure, "antenna_tower_structure");
        GameRegistry.registerTileEntity(TileAntennaTowerStructure.class,  modId + "_antenna_tower_structure");

        wirelessTransmitter = new BlockWirelessTransmitter("wireless_transmitter");
        GameRegistry.registerBlock(wirelessTransmitter, "wireless_transmitter");
        GameRegistry.registerTileEntity(TileWirelessTransmitter.class, modId + "_wireless_transmitter");

        wirelessReceiver = new BlockWirelessReceiver("wireless_receiver");
        GameRegistry.registerBlock(wirelessReceiver, "wireless_receiver");
        GameRegistry.registerTileEntity(TileWirelessReceiver.class, modId + "_wireless_receiver");

        wirelessTransceiver = new BlockWirelessTransceiver("wireless_transceiver");
        GameRegistry.registerBlock(wirelessTransceiver, "wireless_transceiver");
        GameRegistry.registerTileEntity(TileWirelessTransceiver.class, modId + "_wireless_transceiver");
    }
}
