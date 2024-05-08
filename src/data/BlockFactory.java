package data;

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
}
