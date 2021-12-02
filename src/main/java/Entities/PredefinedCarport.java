package Entities;

public class PredefinedCarport {
    int width;
    int length;
    int id;


    public PredefinedCarport(int width,int length){
        this.width = width;
        this.length = length;
    }
    public PredefinedCarport(int id){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
