package levi.flowingwater.util;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import levi.flowingwater.tileentities.aqua.TileEntityAquaBlock;

public class AquaNetwork {

	private HashMap<String, TileEntityAquaBlock> aquaNet = new HashMap<String, TileEntityAquaBlock>();
	private HashMap<String, String> inOut = new HashMap<String, String>();

	protected FluidTank tank = new FluidTank(
			FluidContainerRegistry.BUCKET_VOLUME);

	public void readFromNBT(NBTTagCompound tag) {
		tank.writeToNBT(tag);
	}

	public void writeToNBT(NBTTagCompound tag) {
		tank.readFromNBT(tag);
	}

	public void registerAquaBlock(TileEntityAquaBlock AquaEntity) {
		String key = AquaEntity.xCoord + AquaEntity.yCoord + AquaEntity.zCoord
				+ "";
		aquaNet.put(key, AquaEntity);
	}

	public void removeAquaBlock(String key) {
		aquaNet.remove(key);
	}

	public void registerInputOutput(boolean inputOutput, String key) {
		if (inputOutput) {
			inOut.put(key, "input");
		} else {
			inOut.put(key, "output");
		}
	}

	public void removeInputOutput(String key) {
		inOut.remove(key);
	}

	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		// TODO Make Directional.
		return tank.fill(resource, doFill);
	}

	public FluidStack getFluid() {
		return tank.getFluid();
	}

	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		return tank.drain(resource.amount, doDrain);
	}
	
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		// TODO Make Directional.
		return tank.drain(maxDrain, doDrain);
	}
	
	public FluidTankInfo getInfo(){
		return tank.getInfo();
	}
	
	public HashMap<String, TileEntityAquaBlock> getAquaNet(){
		return aquaNet;
	}
	
	public HashMap<String, String> getInOut(){
		return inOut;
	}
}
