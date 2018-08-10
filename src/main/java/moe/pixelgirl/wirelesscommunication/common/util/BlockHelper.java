package moe.pixelgirl.wirelesscommunication.common.util;
import cofh.api.tileentity.ISecurable;
import cofh.core.block.TileCoFHBase;
import cofh.core.util.CoreUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import java.util.ArrayList;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.util
 * Created by Pixel.
 */
public class BlockHelper {
    public static ArrayList<ItemStack> dismantleBlock(EntityPlayer player, World world, int x, int y, int z, boolean returnDrops) {
        int metadata = world.getBlockMetadata(x, y, z);
        Block block = world.getBlock(x, y, z);
        ItemStack droppedBlock = new ItemStack(block, 1, metadata);
        world.setBlockToAir(x, y, z);

        if(!returnDrops){
            float f = 0.3F;
            double x2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double y2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            double z2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
            EntityItem entity = new EntityItem(world, x + x2, y + y2, z + z2, droppedBlock);
            entity.delayBeforeCanPickup = 10;
            world.spawnEntityInWorld(entity);

            CoreUtils.dismantleLog(player.getCommandSenderName(), block, metadata, x, y, z);
        }
        ArrayList<ItemStack> returnedItems = new ArrayList<ItemStack>();
        returnedItems.add(droppedBlock);
        return returnedItems;
    }

    public static ArrayList<ItemStack> dismantleBlock(EntityPlayer player, NBTTagCompound nbt, World world, int x, int y, int z, boolean returnDrops, boolean simulate) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

        ItemStack droppedBlock = new ItemStack(block, 1, meta);

        if(nbt != null && !nbt.hasNoTags()){
            droppedBlock.setTagCompound(nbt);
        }
        if(!simulate){
            if(tileEntity instanceof TileCoFHBase){
                ((TileCoFHBase) tileEntity).blockDismantled();
            }
            world.setBlockToAir(x, y, z);

            if (!returnDrops) {
                float f = 0.3F;
                double x2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
                double y2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
                double z2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
                EntityItem item = new EntityItem(world, x + x2, y + y2, z + z2, droppedBlock);
                item.delayBeforeCanPickup = 10;
                if (tileEntity instanceof ISecurable && !((ISecurable) tileEntity).getAccess().isPublic()) {
                    item.func_145797_a(player.getCommandSenderName());
                    // set owner (not thrower) - ensures wrenching player can pick it up first
                }
                world.spawnEntityInWorld(item);

                if (player != null) {
                    CoreUtils.dismantleLog(player.getCommandSenderName(), block, meta, x, y, z);
                }
            }
        }
        ArrayList<ItemStack> returnedItems = new ArrayList<ItemStack>();
        returnedItems.add(droppedBlock);
        return returnedItems;
    }
}
