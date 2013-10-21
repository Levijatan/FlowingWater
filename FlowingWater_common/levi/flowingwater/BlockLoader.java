package levi.flowingwater;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import levi.flowingwater.blocks.aqua.ducts.Aquaduct;
import levi.flowingwater.tileentities.aqua.duct.TileEntityAquaDuct;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLoader
{
  public static Block aquaDuct;

  public static void init()
  {
    aquaDuct = new Aquaduct(500, Material.rock).setUnlocalizedName("Aquaduct");
    GameRegistry.registerBlock(aquaDuct, "Levijatan_FlowingWater" + aquaDuct.getUnlocalizedName().substring(5));
  }

  public static void addNames()
  {
    LanguageRegistry.addName(aquaDuct, "Aquaduct");
  }

  public static void registerTileEntities()
  {
    GameRegistry.registerTileEntity(TileEntityAquaDuct.class, "AquaductTileEntity");
  }
}