package Entities;

public class Roofing
{
    int roofing_id;
    Material material;

    public Roofing(int roofing_id, Material material)
    {
        this.roofing_id = roofing_id;
        this.material = material;
    }
    public Roofing(Material material){
        this.material = material;
    }
}
