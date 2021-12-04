package Entities;

public class Cladding
{
    int cladding_id;
    Material material;
    int material_id;

    public Cladding(int cladding_id, Material material)
    {
        this.cladding_id = cladding_id;
        this.material = material;
    }
    public Cladding(int cladding_id, int material_id)
    {
        this.cladding_id = cladding_id;
        this.material_id = material_id;
    }

    public Cladding(int material_id){
        this.material_id=material_id;
    }

    //FOOBAR
    public Cladding(Material material){
        this.material = material;
    }

    public int getCladding_id() {
        return cladding_id;
    }

    public void setCladding_id(int cladding_id) {
        this.cladding_id = cladding_id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

}