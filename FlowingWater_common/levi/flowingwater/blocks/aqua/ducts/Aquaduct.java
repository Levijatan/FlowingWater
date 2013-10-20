package levi.flowingwater.blocks.aqua.ducts;

import levi.flowingwater.blocks.aqua.AquaBlock;
import levi.flowingwater.tileentities.aqua.duct.TileEntityAquaduct;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class Aquaduct extends AquaBlock
{
  protected FluidStack fluid;
  protected int capacity;
  protected TileEntity tile;

  public Aquaduct(int id, Material material)
  {
    super(id, material);
    setCreativeTab(CreativeTabs.tabBlock);
  }

  public TileEntity createNewTileEntity(World world)
  {
    return new TileEntityAquaduct();
  }

  public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
  {
    return false;
  }
}