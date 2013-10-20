package levi.flowingwater.blocks.aqua;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class AquaBlock extends BlockContainer {
	public AquaBlock(int id, Material material) {
		super(id, material);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		if (super.blockMaterial == Material.glass) {
			return true;
		}
		return false;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		return false;

	}
}