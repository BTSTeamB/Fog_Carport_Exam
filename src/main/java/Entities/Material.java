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
    int quantity;

    public Material(String name, String description, double price, int unit_id, Double length, Double height, Double width)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.unit_id = unit_id;
        this.length = length;
        this.height = height;
        this.width = width;
    }

    //Database retriever Constructor
    public Material(int material_id, String name, String description, double price, int quantity, Unit unit, Double length, Double height, Double width)
    {
        this.material_id = material_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.length = length;
        this.height = height;
        this.width = width;
    }
    public Material(int materialId,String name, String description, double price, int quantity ,int unit_id, Double length, Double height, Double width){
        this.material_id = materialId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.unit_id = unit_id;
        this.length = length;
        this.height = height;
        this.width = width;
    }


    public Material(int material_id)
    {
        this.material_id = material_id;
    }



    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
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
}