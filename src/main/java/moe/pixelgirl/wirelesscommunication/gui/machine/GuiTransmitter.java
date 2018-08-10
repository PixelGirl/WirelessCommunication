package moe.pixelgirl.wirelesscommunication.gui.machine;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessTransmitter;
import moe.pixelgirl.wirelesscommunication.gui.container.ContainerTransmitter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.client.gui.machine
 * Created by Pixel.
 */
public class GuiTransmitter extends GuiMachine {

    static final ResourceLocation texture = new ResourceLocation(WirelessCommunication.MODID.toLowerCase(), "textures/gui/machine/transmitter.png");

    public GuiTransmitter(TileWirelessTransmitter tile, EntityPlayer player) {
        super(new ContainerTransmitter(player.inventory, tile), tile, player, texture);
    }
}
