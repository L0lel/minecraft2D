package data;

import data.blocks.*;

import java.util.Random;

public class BlockFactory {

    public static AirBlock air_block(){
        return new AirBlock();
    }

    public static SandBlock sand_block(){
        return new SandBlock();
    }

    public static RawIronBlock raw_iron_block(){
        return new RawIronBlock();
    }

    public static WaterBlock water_block(){
        return new WaterBlock();
    }

    public static TorchBlock torch_block(){
        return new TorchBlock();
    }

    public static NullBlock null_block(){
        return new NullBlock();
    }

    public static Block random_block() {
        Random rand = new Random();
        int r = rand.nextInt(6);
        return switch (r) {
            case 0 -> raw_iron_block();
            case 1 -> sand_block();
            case 2 -> torch_block();
            case 3 -> water_block();
            case 4 -> air_block();
            case 5 -> sand_block().smelt();
            default -> null_block();
        };
    }
}
