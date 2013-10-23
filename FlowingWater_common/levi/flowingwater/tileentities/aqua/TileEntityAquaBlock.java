package levi.flowingwater.tileentities.aqua;

import java.util.Stack;

import levi.flowingwater.util.AquaNetwork;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAquaBlock extends TileEntity {

	protected AquaNetwork net;

	public TileEntityAquaBlock() {
		createNetwork();
	}

	public void createNetwork() {
		if (net == null) {
			net = new AquaNetwork(16);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		net.writeToNBT(tag);
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		net.readFromNBT(tag);
	}

	public Stack<AquaNetwork> checkIfSutibleAquaNets() {
		Stack<TileEntityAquaBlock> ATiles = new Stack<TileEntityAquaBlock>();
		ATiles = checkAndPush(ATiles, xCoord - 1, yCoord, zCoord);
		ATiles = checkAndPush(ATiles, xCoord - 1, yCoord - 1, zCoord);
		ATiles = checkAndPush(ATiles, xCoord - 1, yCoord + 1, zCoord);
		ATiles = checkAndPush(ATiles, xCoord + 1, yCoord, zCoord);
		ATiles = checkAndPush(ATiles, xCoord + 1, yCoord - 1, zCoord);
		ATiles = checkAndPush(ATiles, xCoord + 1, yCoord + 1, zCoord);
		ATiles = checkAndPush(ATiles, xCoord, yCoord - 1, zCoord);
		ATiles = checkAndPush(ATiles, xCoord, yCoord + 1, zCoord);
		ATiles = checkAndPush(ATiles, xCoord, yCoord, zCoord - 1);
		ATiles = checkAndPush(ATiles, xCoord, yCoord - 1, zCoord - 1);
		ATiles = checkAndPush(ATiles, xCoord, yCoord + 1, zCoord - 1);
		ATiles = checkAndPush(ATiles, xCoord, yCoord, zCoord + 1);
		ATiles = checkAndPush(ATiles, xCoord, yCoord - 1, zCoord + 1);
		ATiles = checkAndPush(ATiles, xCoord, yCoord + 1, zCoord + 1);

		Stack<AquaNetwork> netStack = pickLegalNets(ATiles);

		return netStack;
	}

	public Stack<AquaNetwork> pickLegalNets(Stack<TileEntityAquaBlock> ATiles) {
		Stack<AquaNetwork> netStack = new Stack<AquaNetwork>();
		while (!ATiles.isEmpty()) {
			TileEntityAquaBlock tile = ATiles.pop();
			if (tile.getNet() != getNet()) {
				netStack.push(tile.getNet());
			}
		}
		return netStack;
	}

	public Stack<TileEntityAquaBlock> checkAndPush(
			Stack<TileEntityAquaBlock> stack, int x, int y, int z) {
		if (this.worldObj.getBlockTileEntity(x, y, z) != null) {
			TileEntity tile = this.worldObj.getBlockTileEntity(x, y, z);
			if (tile.equals(this)) {
				stack.push((TileEntityAquaBlock) tile);
			}
		}
		return stack;
	}

	public AquaNetwork getNet() {
		return net;
	}
}
