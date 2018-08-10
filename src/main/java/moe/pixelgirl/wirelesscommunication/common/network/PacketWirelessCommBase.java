package moe.pixelgirl.wirelesscommunication.common.network;
import cofh.core.network.PacketCoFHBase;
import cofh.core.network.PacketHandler;
import net.minecraft.entity.player.EntityPlayer;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.network
 * Created by Pixel.
 */
public class PacketWirelessCommBase extends PacketCoFHBase {

    public static void initialise(){
        PacketHandler.instance.registerPacket(PacketWirelessCommBase.class);
    }

    public enum packetTypes{

    }

    @Override
    public void handlePacket(EntityPlayer player, boolean isServer) {

    }
}
