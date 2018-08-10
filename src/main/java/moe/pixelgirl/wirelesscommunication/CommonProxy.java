package moe.pixelgirl.wirelesscommunication;
import moe.pixelgirl.wirelesscommunication.gui.GuiHandler;
import moe.pixelgirl.wirelesscommunication.common.WirelessCommBlocks;
import moe.pixelgirl.wirelesscommunication.common.WirelessCommItems;
import moe.pixelgirl.wirelesscommunication.common.crafting.WirelessCommRecipes;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication
 * Created by Pixel.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event){
        WirelessCommItems.preInit();
        WirelessCommBlocks.preInit();
        WirelessCommRecipes.preInit();
    }

    public void init(FMLInitializationEvent event){
        NetworkRegistry.INSTANCE.registerGuiHandler(WirelessCommunication.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent event){
    }
}
