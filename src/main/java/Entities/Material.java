package Entities;

public class Material
{
    int material_id;
    String name;
    String description;
    double price;
    Unit unit;
    int unit_id;
    Double length;
    Double height;
    Double width;
    String time_created;

    public Material(String name, String description, double price, Unit unit, Double length, Double height, Double width, String time_created)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.unit = unit;
        this.length = length;
        this.height = height;
        this.width = width;
        this.time_created = time_created;
    }

    //Database retriever Constructor
    public Material(int material_id, String name, String description, double price, Unit unit, Double length, Double height, Double width, String time_created)
    {
        this.material_id = material_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.unit = unit;
        this.length = length;
        this.height = height;
        this.width = width;
        this.time_created = time_created;
    }
    public Material(String name, String description, double price,int unit_id, Double length, Double height, Double width){
        this.name = name;
        this.description = description;
        this.price = price;
        this.unit_id = unit_id;
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
    //TODO: Get currentId, hvor man henter id fra database og sætter et nyt objekts id til det.
}
