package Entities;

public class Unit {
    int unit_id;
    String name;

    public Unit(int unit_id, String name) {
        this.unit_id = unit_id;
        this.name = name;
    }

    public Unit(String name) {
        this.name = name;
    }

    public Unit(int unit_id) {
        this.unit_id = unit_id;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
