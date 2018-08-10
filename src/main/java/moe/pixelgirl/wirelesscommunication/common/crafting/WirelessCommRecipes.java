package moe.pixelgirl.wirelesscommunication.common.crafting;

import cofh.api.modhelpers.ThermalFoundationHelper;
import cofh.thermalfoundation.ThermalFoundation;
import cofh.thermalfoundation.item.TFItems;
import cpw.mods.fml.common.registry.GameRegistry;
import moe.pixelgirl.wirelesscommunication.common.WirelessCommBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * WirelessCommunication
 * moe.pixelgirl.wirelesscommunication.common.crafting
 * Created by Pixel.
 */
public class WirelessCommRecipes {
    public static void preInit() {
        GameRegistry.addRecipe(new ItemStack(WirelessCommBlocks.machineFrame, 1), "ABA", "CDC", "ABA",
                'A', new ItemStack(Blocks.stone, 1),
                'B', new ItemStack(Items.iron_ingot, 1),
                'C', new ItemStack(Blocks.glass, 1),
                'D', TFItems.gearTin);
    }
}
