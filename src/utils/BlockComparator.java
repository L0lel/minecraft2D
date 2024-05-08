package utils;

import data.Block;
import data.InventoryBlock;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {

    @Override
    public int compare(Block b1, Block b2) {
        return Integer.compare(b1.getBlock_value(), b2.getBlock_value());
    }
}