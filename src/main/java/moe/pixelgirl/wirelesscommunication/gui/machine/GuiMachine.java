package moe.pixelgirl.wirelesscommunication.gui.machine;
import moe.pixelgirl.wirelesscommunication.gui.GuiWirelessComm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.client.gui
 * Created by Pixel.
 */
public abstract class GuiMachine extends GuiWirelessComm {

    public GuiMachine(Container container, TileEntity tile, EntityPlayer player, ResourceLocation texture) {
        super(container, tile, player, texture);
    }

    public GuiMachine(Container container, ResourceLocation resourceLocation) {
        super(container, resourceLocation);
    }
}
