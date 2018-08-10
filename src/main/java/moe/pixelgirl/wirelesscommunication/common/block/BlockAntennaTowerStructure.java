package moe.pixelgirl.wirelesscommunication.common.block;
import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.tile.TileAntennaTowerStructure;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moe.pixelgirl.wirelesscommunication.common.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.block
 * Created by Pixel.
 */
public class BlockAntennaTowerStructure extends BlockContainerBase {

    public IIcon icon = null;

    public BlockAntennaTowerStructure(String unlocalisedName) {
        super(Material.iron);
        this.setBlockName(unlocalisedName).setHardness(2f).setStepSound(soundTypeMetal).setCreativeTab(WirelessCommunication.tabWirelessComm).setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName(WirelessCommunication.MODID + ":" + unlocalisedName);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        super.onNeighborBlockChange(world, x, y, z, block);
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof TileAntennaTowerStructure) {
            TileAntennaTowerStructure towerStructureEntity = (TileAntennaTowerStructure) tileEntity;

            if(!towerStructureEntity.hasMaster()) return;

            if((towerStructureEntity.isMaster() && !towerStructureEntity.checkValidMultiBlock()) || !towerStructureEntity.masterExists()) {
                towerStructureEntity.resetMultiBlock();
                return;
            }

            TileEntity masterTile = towerStructureEntity.getMaster();

            if(!(masterTile instanceof TileAntennaTowerStructure)) return;
            TileAntennaTowerStructure masterTowerTile = (TileAntennaTowerStructure) masterTile;

            if(!masterTowerTile.checkValidMultiBlock()) masterTowerTile.resetMultiBlock();
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        icon = register.registerIcon(WirelessCommunication.MODID + ":antenna_tower_structure");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileAntennaTowerStructure();
    }

    @Override
    public ArrayList<ItemStack> dismantleBlock(EntityPlayer player, NBTTagCompound nbt, World world, int x, int y, int z, boolean returnDrops, boolean simulate) {
        return BlockHelper.dismantleBlock(player, nbt, world, x, y, z, returnDrops, simulate);
    }

    /* IInitializer */

    @Override
    public boolean initialize() {
        return true;
    }

    @Override
    public boolean postInit() {
        return true;
    }
}
