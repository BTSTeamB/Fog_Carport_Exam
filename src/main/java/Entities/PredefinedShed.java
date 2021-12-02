package Entities;

public class PredefinedShed {

    int width;
    int length;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public PredefinedShed(int width, int length) {
        this.width = width;
        this.length = length;
    }
    public PredefinedShed(int id){
        this.id=id;

    }

    public PredefinedShed(int width, int length, int id) {
        this.width = width;
        this.length = length;
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}