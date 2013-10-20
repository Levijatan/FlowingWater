package levi.flowingwater.tileentities.aqua;

import java.util.ArrayList;

import levi.flowingwater.util.AquaNetwork;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAquaBlock extends TileEntity {

	private AquaNetwork net;

	public void createNetwork() {
		if (net == null) {
			net = new AquaNetwork();
		}
	}

	public ArrayList<TileEntity> checkIfNeighborsAquaBlock() {
		ArrayList<TileEntity> neighbors = new ArrayList<TileEntity>();
		if (this.worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) != null) {
			if (this.worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord)
					.equals(this)) {
				neighbors.add(this.worldObj.getBlockTileEntity(xCoord - 1, yCoord,
						zCoord));
			}
		}
		if (this.worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) != null) {
			if (this.worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord)
	 				.equals(this)) {
				neighbors.add(this.worldObj.getBlockTileEntity(xCoord + 1, yCoord,
						zCoord));
			}
		}
		if (this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) != null) {
			if (this.worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord)
					.equals(this)) {
				neighbors.add(this.worldObj.getBlockTileEntity(xCoord, yCoord - 1,
						zCoord));
			}
		}
		if (this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) != null) {
			if (this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord)
					.equals(this)) {
				neighbors.add(this.worldObj.getBlockTileEntity(xCoord, yCoord + 1,
						zCoord));
			}
		}
		if (this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) != null) {
			if (this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1)
					.equals(this)) {
				neighbors.add(this.worldObj.getBlockTileEntity(xCoord, yCoord,
						zCoord - 1));
			}
		}
		if (this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) != null) {
			if (this.worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1)
					.equals(this)) {
				neighbors.add(this.worldObj.getBlockTileEntity(xCoord, yCoord,
						zCoord + 1));
			}
		}
		return neighbors;
	}

	public AquaNetwork getNet() {
		return net;
	}
}
