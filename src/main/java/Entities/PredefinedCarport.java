package Entities;

public class PredefinedCarport {
    double width;
    double length;
    double price;
    String imgUrl;
    String seeMoreUrl1;
    String seeMoreUrl2;
    int id;

    //Database create constructor
    public PredefinedCarport(double width,double length, double price, String imgUrl, String seeMoreUrl1, String seeMoreUrl2){
        this.width = width;
        this.length = length;
        this.price = price;
        this.imgUrl = imgUrl;
        this.seeMoreUrl1 = seeMoreUrl1;
        this.seeMoreUrl2 = seeMoreUrl2;
    }

    //Database edit constructor
    public PredefinedCarport(int id, double width, double length, double price, String imgUrl, String seeMoreUrl1, String seeMoreUrl2) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.price = price;
        this.imgUrl = imgUrl;
        this.seeMoreUrl1 = seeMoreUrl1;
        this.seeMoreUrl2 = seeMoreUrl2;
    }

    //Database delete/receiver constructor
    public PredefinedCarport(int id){
        this.id = id;
    }


    public String getSeeMoreUrl1()
    {
        return seeMoreUrl1;
    }


    public String getSeeMoreUrl2()
    {
        return seeMoreUrl2;
    }

    public void setSeeMoreUrl2(String seeMoreUrl2)
    {
        this.seeMoreUrl2 = seeMoreUrl2;
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

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}