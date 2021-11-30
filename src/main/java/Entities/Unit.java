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
}
