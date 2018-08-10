package moe.pixelgirl.wirelesscommunication.client.render;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.client.rendering
 * Created by Pixel.
 */
public class WirelessCommRenderingHandler implements ISimpleBlockRenderingHandler {

    public TileEntity tileEntity;
    public TileEntitySpecialRenderer tileEntityRenderer;

    public final int renderId;

    public WirelessCommRenderingHandler(TileEntitySpecialRenderer tileEntityRenderer) {
        this.tileEntityRenderer = tileEntityRenderer;
        tileEntityRenderer.func_147497_a(TileEntityRendererDispatcher.instance);
        renderId = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return false;
    }

    @Override
    public int getRenderId() {
        return 0;
    }
}
