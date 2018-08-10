package moe.pixelgirl.wirelesscommunication.gui;
import cofh.core.gui.GuiBaseAdv;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessCommBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.gui
 * Created by Pixel.
 */
public abstract class GuiWirelessComm extends GuiBaseAdv {

    protected InventoryPlayer inventory;
    protected TileWirelessCommBase myTile;
    private ResourceLocation texture;

    public GuiWirelessComm(Container container, TileEntity tile, EntityPlayer player, ResourceLocation texture) {
        super(container, texture);
        inventory = player.inventory;
        myTile = (TileWirelessCommBase) tile;
        this.texture = texture;
    }

    public GuiWirelessComm(Container container, ResourceLocation resourceLocation) {
        super(container, resourceLocation);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
        GL11.glColor4f(1f, 1f, 1f, 1f);
        bindTexture(texture);
        drawTexturedModalRect((width - xSize) / 2, (height - ySize) / 2, 0, 0, xSize, ySize);
    }
}
