package moe.pixelgirl.wirelesscommunication.common.tile;
import cofh.lib.util.helpers.ServerHelper;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.block.BlockMachineBase;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.IIcon;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.tile
 * Created by Pixel.
 */
public abstract class TileMachineBase extends TilePowered implements IUpdatePlayerListBox {
    protected final byte type;
    protected BlockMachineBase blockMachineBase;

    public TileMachineBase(BlockMachineBase.Types type) {
        super();
        this.type = (byte) type.ordinal();
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String getName() {
        return "tile." + WirelessCommunication.MODID.toLowerCase() + ".machine." + BlockMachineBase.Types.values()[type].toString().toLowerCase() + ".name";
    }

    @Override
    public int getChargeSlot() {
        return inventory.length - 1;
    }

    @Override
    public boolean hasChargeSlot() {
        return true;
    }

    public void updateEntity() {
        super.updateEntity();
        if(ServerHelper.isClientWorld(worldObj)) return;
        chargeEnergy();
    }

    /* IUpdatePlayerListBox */

    @Override
    public abstract void update();

    /*  ISidedTexture */

    @Override
    public IIcon getTexture(int side, int pass) {
        BlockMachineBase block = blockMachineBase;
        if(side == 0 || side == 1) return block.icons[1];
        else if(side == facing) return block.icons[isActive ? 3 : 2];
        return block.icons[0];
    }
}
