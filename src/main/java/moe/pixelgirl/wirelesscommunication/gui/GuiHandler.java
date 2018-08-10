package moe.pixelgirl.wirelesscommunication.gui;
import cpw.mods.fml.common.network.IGuiHandler;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessTransmitter;
import moe.pixelgirl.wirelesscommunication.gui.container.ContainerTransmitter;
import moe.pixelgirl.wirelesscommunication.gui.machine.GuiTransmitter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.client.gui
 * Created by Pixel.
 */
public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity == null) return null;
        switch(ID) {
            case 1: return new ContainerTransmitter(player.inventory, tileEntity);
            default: return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity == null) return null;
        switch(ID) {
            case 1: return new GuiTransmitter((TileWirelessTransmitter) tileEntity, player);
            default: return null;
        }
    }
}
