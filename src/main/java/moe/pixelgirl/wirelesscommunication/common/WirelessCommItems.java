package moe.pixelgirl.wirelesscommunication.common;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.pixelgirl.wirelesscommunication.common.item.ItemPortableTransceiver;
import moe.pixelgirl.wirelesscommunication.common.item.ItemPortableTransmitter;
import net.minecraft.item.Item;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common
 * Created by Pixel.
 */
public class WirelessCommItems {
    public static Item itemPortableTransmitter;
    public static Item itemPortableTransceiver;

    public static void preInit() {
        itemPortableTransmitter = new ItemPortableTransmitter("portable_transmitter");
        GameRegistry.registerItem(itemPortableTransmitter, "portable_transmitter");

        itemPortableTransceiver = new ItemPortableTransceiver("portable_transceiver");
        GameRegistry.registerItem(itemPortableTransceiver, "portable_transceiver");
    }
}
