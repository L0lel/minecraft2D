package utils.comparators;

import data.blocks.Block;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {

    @Override
    public int compare(Block b1, Block b2) {
        return Integer.compare(b1.getBlock_value(), b2.getBlock_value());
    }
}