package levi.flowingwater;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "Levijatan_FlowingWater", name = "FlowingWater", version = "0.0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class FlowingWater {
	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {
		BlockLoader.init();
		BlockLoader.addNames();
		BlockLoader.registerTileEntities();
	}
}