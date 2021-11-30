package Entities;

public class Cladding
{
    int cladding_id;
    Material material;

    public Cladding(int cladding_id, Material material)
    {
        this.cladding_id = cladding_id;
        this.material = material;
    }
    public Cladding(Material material){
        this.material = material;

    }
}
