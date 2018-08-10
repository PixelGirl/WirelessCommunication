package moe.pixelgirl.wirelesscommunication.common.misc;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.WirelessCommItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.misc
 * Created by Pixel.
 */
public class CreativeTabWirelessComm extends CreativeTabs {

    public CreativeTabWirelessComm(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return WirelessCommItems.itemPortableTransmitter;
    }
}
