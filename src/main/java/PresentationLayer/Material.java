package PresentationLayer;

public class Material
{
    int material_id;
    String name;
    String description;
    double price;
    Unit unit;
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

    //TODO: Get currentId, hvor man henter id fra database og sætter et nyt objekts id til det.
}
