package Entities;

public class PredefinedShed {

    int width;
    int length;
    double price;
    String imgUrl;
    int id;

    //Database edit constructor
    public PredefinedShed(int id, int width, int length, double price, String imgUrl) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    //Database inserter constructor
    public PredefinedShed(int width, int length, double price, String imgUrl)
    {
        this.width = width;
        this.length = length;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    //Database delete/receiver Constructor
    public PredefinedShed(int id){
        this.id=id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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