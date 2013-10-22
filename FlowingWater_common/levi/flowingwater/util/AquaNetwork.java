package levi.flowingwater.util;

import java.util.HashMap;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import levi.flowingwater.tileentities.aqua.TileEntityAquaBlock;

public class AquaNetwork extends FluidTank {
	
	private HashMap<String, TileEntityAquaBlock> aquaNet = new HashMap<String, TileEntityAquaBlock>();
	private HashMap<String, String> inOut = new HashMap<String, String>();

	public AquaNetwork(int capacity) {
		super(null, capacity);
	}

	public AquaNetwork(FluidStack stack, int capacity) {
		super(stack, capacity);
	}

	public AquaNetwork(Fluid fluid, int amount, int capacity) {
		super(fluid, amount, capacity);
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

	public HashMap<String, TileEntityAquaBlock> getAquaNet() {
		return aquaNet;
	}

	public HashMap<String, String> getInOut() {
		return inOut;
	}
}
