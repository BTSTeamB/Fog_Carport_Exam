package Entities;

public class Roofing
{
    int roofing_id;
    Material material;
    int material_id;

    public Roofing(int roofing_id, Material material)
    {
        this.roofing_id = roofing_id;
        this.material = material;

    }
    public Roofing(int material_id){
        this.material_id = material_id;
    }

    public int getRoofing_id() {
        return roofing_id;

    }

    public void setRoofing_id(int roofing_id) {
        this.roofing_id = roofing_id;
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
