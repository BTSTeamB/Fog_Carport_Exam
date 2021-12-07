package Entities;

public class PredefinedCarport {
    double width;
    double length;
    double price;
    String imgUrl;
    int id;

    //Database create constructor
    public PredefinedCarport(double width,double length, double price, String imgUrl){
        this.width = width;
        this.length = length;
    }

    //Database edit constructor
    public PredefinedCarport(int id, double width, double length, double price, String imgUrl) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    //Database delete/receiver constructor
    public PredefinedCarport(int id){
        this.id = id;
    }
    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getLength() {
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