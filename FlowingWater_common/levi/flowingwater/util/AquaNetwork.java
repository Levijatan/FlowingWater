package levi.flowingwater.util;

import java.util.HashMap;

import levi.flowingwater.tileentities.aqua.TileEntityAquaBlock;

public class AquaNetwork {

	private HashMap<String, TileEntityAquaBlock> aquaNet = new HashMap<String, TileEntityAquaBlock>();
	private HashMap<String, String> inOut = new HashMap<String, String>();

	public void registerAquaBlock(TileEntityAquaBlock AquaEntity) {
		String key = AquaEntity.xCoord + AquaEntity.yCoord + AquaEntity.zCoord + "";
		aquaNet.put(key, AquaEntity);
	}
	
	public void removeAquaBlock(String key){
		aquaNet.remove(key);
	}
	
	public void registerInputOutput(boolean inputOutput, String key){
		if (inputOutput) {
			inOut.put(key, "input");
		}
		else {
			inOut.put(key, "output");
		}
	}
	
	public void removeInputOutput(String key){
		inOut.remove(key);
	}
}