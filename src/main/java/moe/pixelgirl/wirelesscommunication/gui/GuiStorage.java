package moe.pixelgirl.wirelesscommunication.gui;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.client.gui
 * Created by Pixel.
 */
public class GuiStorage extends GuiContainer {

    static final ResourceLocation texture = new ResourceLocation(WirelessCommunication.MODID.toLowerCase(), "textures/gui/container/default.png");

    public GuiStorage(Container container) {
        super(container);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }
}
