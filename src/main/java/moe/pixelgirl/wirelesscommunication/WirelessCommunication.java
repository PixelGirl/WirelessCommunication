package moe.pixelgirl.wirelesscommunication;
import cofh.CoFHCore;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import moe.pixelgirl.wirelesscommunication.common.misc.CreativeTabWirelessComm;
import net.minecraft.creativetab.CreativeTabs;
import java.util.logging.Logger;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication
 * Created by Pixel.
 */
@Mod(useMetadata = true, name = WirelessCommunication.NAME, modid = WirelessCommunication.MODID, version = WirelessCommunication.VERSION, dependencies = "required-after:CoFHCore;required-after:ThermalFoundation")
public class WirelessCommunication {

    public static final String NAME = "Wireless Communication";
    public static final String MODID = "WirelessCommunication";
    public static final String VERSION = "1.0";

    public static Logger log;

    public static CreativeTabs tabCommon = null;
    public static CreativeTabs tabWirelessComm = new CreativeTabWirelessComm("wirelesscommunication");

    @Mod.Instance
    public static WirelessCommunication instance;

    @SidedProxy(clientSide = "moe.pixelgirl.wirelesscommunication.ClientProxy", serverSide = "moe.pixelgirl.wirelesscommunication.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
}
