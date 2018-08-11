package moe.pixelgirl.wirelesscommunication.common.util;
import cofh.api.item.IToolHammer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.util
 */
public class Utils {
    public static boolean isHoldingUsableWrench(EntityPlayer player, int x, int y, int z) {
        Item item = player.getCurrentEquippedItem() != null ? player.getCurrentEquippedItem().getItem() : null;
        if(item instanceof IToolHammer) return ((IToolHammer) item).isUsable(player.getCurrentEquippedItem(), player, x, y, z);
        return false;
    }

    public static void usedWrench(EntityPlayer player, int x, int y, int z) {
        Item item = player.getCurrentEquippedItem() != null ? player.getCurrentEquippedItem().getItem() : null;
        if(item instanceof IToolHammer) ((IToolHammer) item).toolUsed(player.getCurrentEquippedItem(), player, x, y, z);
    }
}
