package moe.pixelgirl.wirelesscommunication;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import moe.pixelgirl.wirelesscommunication.client.render.TileEntityAntennaStructureRenderer;
import moe.pixelgirl.wirelesscommunication.common.tile.TileAntennaTowerStructure;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication
 * Created by Pixel.
 */
public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        ClientRegistry.bindTileEntitySpecialRenderer(TileAntennaTowerStructure.class, new TileEntityAntennaStructureRenderer());
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
