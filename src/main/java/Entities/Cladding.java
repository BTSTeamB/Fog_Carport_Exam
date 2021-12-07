package Entities;

public class Cladding
{
    int cladding_id;
    String type;

    public Cladding(int cladding_id, String type)
    {
        this.cladding_id = cladding_id;
        this.type = type;
    }

    public Cladding(String type){
        this.type=type;
    }

    public Cladding(int cladding_id)
    {
        this.cladding_id = cladding_id;
    }


    public int getCladding_id() {
        return cladding_id;
    }

    public void setCladding_id(int cladding_id) {
        this.cladding_id = cladding_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}