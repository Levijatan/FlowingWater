package levi.flowingwater.tileentities.aqua;

import java.util.ArrayList;

import levi.flowingwater.util.AquaNetwork;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAquaBlock extends TileEntity {
	
	protected AquaNetwork net;

	public TileEntityAquaBlock(){
		createNetwork();
	}
	
	public void createNetwork() {
		if (net == null) {
			net = new AquaNetwork(1);
		}
	}
	
	@Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        net.writeToNBT(tag);
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        net.readFromNBT(tag);
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
