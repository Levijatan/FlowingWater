package levi.flowingwater.tileentities.aqua.duct;

import java.util.ArrayList;

import levi.flowingwater.tileentities.aqua.TileEntityAquaBlock;
import levi.flowingwater.util.AquaNetwork;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityAquaDuct extends TileEntityAquaBlock implements
		IFluidHandler {

	public TileEntityAquaDuct() {

	}

	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		// TODO Make Directional.
		return net.fill(from, resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		// TODO Make Directional.
		if (resource == null || !resource.isFluidEqual(net.getFluid())) {
			return null;
		}
		return net.drain(from, resource, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		// TODO Make Directional.
		return net.drain(from, maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		// TODO Make Directional.
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		// TODO Make Directional.
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { net.getInfo() };
	}

	public ArrayList<TileEntityAquaDuct> checkNeighborsForNet(
			ArrayList<TileEntity> neighbors) {
		ArrayList<TileEntityAquaDuct> netList = new ArrayList<TileEntityAquaDuct>();
		for (int x = 0; x < neighbors.size(); x++) {
			TileEntityAquaDuct check = (TileEntityAquaDuct) neighbors.get(x);
			if (!net.getAquaNet().equals(check.getNet().getAquaNet())) {
				if(netList.size() == 0){
					netList.add(check);
				}
				else {
					boolean isNew = false;
					for(int y = 0; y < netList.size(); y++){
						if (check != netList.get(y)){
							isNew = true;
						}
						else {
							isNew = false;
							break;
						}
					}
					if (isNew) {
						netList.add(check);
					}
				}
			}
		}
		return netList;
	}
}