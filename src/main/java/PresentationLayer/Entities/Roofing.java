package PresentationLayer.Entities;

public class Roofing
{
    int roofing_id;
    String type;

    public Roofing(int roofing_id, String type)
    {
        this.roofing_id = roofing_id;
        this.type = type;

    }
    public Roofing(String type){
        this.type = type;
    }

    //FOOBAR
    public Roofing(int roofing_id)
    {
        this.roofing_id = roofing_id;
    }

    public int getRoofing_id() {
        return roofing_id;

    }

    public void setRoofing_id(int roofing_id) {
        this.roofing_id = roofing_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}