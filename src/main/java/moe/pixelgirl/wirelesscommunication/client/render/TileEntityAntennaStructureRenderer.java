package moe.pixelgirl.wirelesscommunication.client.render;

import moe.pixelgirl.wirelesscommunication.WirelessCommunication;
import moe.pixelgirl.wirelesscommunication.common.tile.TileAntennaTowerStructure;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.client.rendering
 * Created by Pixel.
 */
@SideOnly(Side.CLIENT)
public class TileEntityAntennaStructureRenderer extends TileEntitySpecialRenderer {

    static final IModelCustom moduleBlockModel = AdvancedModelLoader.loadModel(new ResourceLocation(WirelessCommunication.MODID.toLowerCase(), "models/antenna_structure_module.obj"));
    static final ResourceLocation moduleBlockTexture = new ResourceLocation(WirelessCommunication.MODID.toLowerCase(), "textures/models/antenna_structure_module.png");

    static final IModelCustom tier1TowerModel = AdvancedModelLoader.loadModel(new ResourceLocation(WirelessCommunication.MODID.toLowerCase(), "models/antenna_tower_1.obj"));
    static final ResourceLocation tier1TowerTexture = new ResourceLocation(WirelessCommunication.MODID.toLowerCase(), "textures/models/antenna_tower_1.png");

    static final IModelCustom tier2TowerModel = null;

    public void renderTileEntityAt(TileAntennaTowerStructure antennaTowerStructure, double x, double y, double z, float partialTicks) {
        if (antennaTowerStructure == null) return;

        int metaData = antennaTowerStructure.getBlockMetadata();

        boolean doRender = true;

        IModelCustom model;
        ResourceLocation texture;

        float xOffset;
        float yOffset;
        float zOffset;

        switch (metaData) {
            case 1:
                doRender = false;
                model = moduleBlockModel;
                texture = moduleBlockTexture;
                xOffset = .5f;
                yOffset = .5f;
                zOffset = .5f;
                break;
            case 2:
                model = tier1TowerModel;
                texture = tier1TowerTexture;
                xOffset = .5f;
                yOffset = 0f;
                zOffset = .5f;
                break;
            default:
                model = moduleBlockModel;
                texture = moduleBlockTexture;
                xOffset = .5f;
                yOffset = .5f;
                zOffset = .5f;
                break;
        }

        if(!doRender) return;

        bindTexture(texture);

        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1f, 1f, 1f, 1f);
        GL11.glTranslatef((float) x + xOffset, (float) y + yOffset, (float) z + zOffset);
        GL11.glScalef(1f, 1f, 1f);

        model.renderAll();
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks) {
        renderTileEntityAt((TileAntennaTowerStructure) tileEntity, x, y, z, partialTicks);
    }
}
