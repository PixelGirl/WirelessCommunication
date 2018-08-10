package moe.pixelgirl.wirelesscommunication.common.block;
import cofh.api.tileentity.ISecurable;
import cofh.core.block.BlockCoFHBase;
import cofh.core.block.TileCoFHBase;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import cofh.api.tileentity.ISidedTexture;
import cofh.api.block.IDismantleable;
import cofh.core.util.CoreUtils;
import cofh.lib.util.position.IRotateableTile;
import moe.pixelgirl.wirelesscommunication.common.tile.TileMachineBase;
import moe.pixelgirl.wirelesscommunication.common.tile.TileWirelessInterfaceBase;
import moe.pixelgirl.wirelesscommunication.common.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import java.util.ArrayList;
import java.util.Random;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block
 * Created by Pixel.
 */
public abstract class BlockMachineBase extends BlockWirelessCommBase implements IRotateableTile {

    public enum Types{
        TRANSMITTER,
        RECEIVER,
        TRANSCEIVER
    }

    public IIcon[] icons = new IIcon[4];
    private Random random = new Random();

    protected BlockMachineBase(String unlocalisedName) {
        super(Material.iron);
        this.setBlockName(unlocalisedName).setHardness(2.1f).setStepSound(soundTypeMetal).setCreativeTab(WirelessCommunication.tabWirelessComm).setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName(WirelessCommunication.MODID + ":" + unlocalisedName);
    }

    @Override
    public void registerBlockIcons(IIconRegister register){
        icons[0] = register.registerIcon(WirelessCommunication.MODID + ":machine_frame_side");
        icons[1] = register.registerIcon(WirelessCommunication.MODID + ":machine_frame_top");
        icons[2] = register.registerIcon(WirelessCommunication.MODID + ":wireless_interface_front");
        icons[3] = register.registerIcon(WirelessCommunication.MODID + ":wireless_interface_front");
    }

    @Override
    public IIcon getIcon(int side, int meta){
        switch(side){
            case 0:
            case 1: return icons[1];
            case 2: return icons[2];
            default: return icons[0];
        }
    }

    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        ISidedTexture tile = (ISidedTexture) world.getTileEntity(x, y, z);
        return tile != null ? tile.getTexture(side, renderPass) : null;
    }

    @Override
    public int getRenderType(){
        return 0;
    }

    @Override
    public abstract boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float lx, float ly, float lz);

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int par6) {
        super.breakBlock(world, x, y, z, block, par6);
        if(world.isRemote) return;

        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if(tileEntity instanceof TileMachineBase) {
            TileMachineBase tileMachine = (TileMachineBase) tileEntity;
            for(int i = 0; i < tileMachine.getSizeInventory(); i++) {
                ItemStack itemStack = tileMachine.getStackInSlot(i);
                if(itemStack != null) drops.add(itemStack.copy());
            }
        }

        for (ItemStack drop : drops) {
            EntityItem item = new EntityItem(world, x + .5, y + .5, z + .5, drop);
            item.setVelocity((random.nextDouble() - .5) * .25, random.nextDouble() * .125, (random.nextDouble() - .5) * .25);
            world.spawnEntityInWorld(item);
        }
    }

    /*  IInitializer */

    @Override
    public boolean initialize() {
        return true;
    }

    @Override
    public boolean postInit() {
        return true;
    }

    /* ITileEntityProvider */

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

    /* IRotateableTile */

    @Override
    public boolean canRotate() {
        return true;
    }

    @Override
    public boolean canRotate(ForgeDirection axis) {
        return true;
    }

    @Override
    public void rotate(ForgeDirection axis) {

    }

    @Override
    public void rotateDirectlyTo(int facing) {

    }

    @Override
    public ForgeDirection getDirectionFacing() {
        return null;
    }

    @Override
    public ArrayList<ItemStack> dismantleBlock(EntityPlayer player, NBTTagCompound nbt, World world, int x, int y, int z, boolean returnDrops, boolean simulate) {
        return BlockHelper.dismantleBlock(player, nbt, world, x, y, z, returnDrops, simulate);
    }

    @Override
    public boolean canDismantle(EntityPlayer player, World world, int x, int y, int z) {
        return true;
    }
}
