package data;

public interface Block extends InventoryBlock{

    char display();

    boolean has_gravity();

    boolean does_fall_through();

    boolean is_pickable();

    int getBlock_value();

    void setBlock_value(int value);

    boolean isEntityBlock();

    String getBlockname();
}
