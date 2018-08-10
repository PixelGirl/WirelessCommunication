package moe.pixelgirl.wirelesscommunication.common.block;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessReceiver;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import java.util.ArrayList;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block
 * Created by Pixel.
 */
public class BlockWirelessReceiver extends BlockWirelessInterfaceBase {

    public BlockWirelessReceiver(String unlocalisedName) {
        super(unlocalisedName);
    }

    public void registerBlockIcons(IIconRegister register){
        super.registerBlockIcons(register);
        icons[2] = register.registerIcon(WirelessCommunication.MODID + ":wireless_receiver_front");
        icons[3] = register.registerIcon(WirelessCommunication.MODID + ":wireless_receiver_front_active");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileWirelessReceiver();
    }

    @Override
    int getGuiId() {
        return 2;
    }
}
