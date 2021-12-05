package Entities;

import java.sql.Timestamp;

public class Order {
    private int order_id;
    private int user_id;
    private double price;
    private int carport_length;
    private int carport_width;
    private Cladding cladding;
    private Roofing roofing;
    private int shed_width;
    private int shed_length;
    private String time_created;
    private int cladding_id;
    private int roofing_id;

    public Order(int user_id, double price, int carport_length, int carport_width, Cladding cladding, Roofing roofing, int shed_width, int shed_length, String time_created) {
        this.user_id = user_id;
        this.price = price;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.cladding = cladding;
        this.roofing = roofing;
        this.shed_width = shed_width;
        this.shed_length = shed_length;
        this.time_created = time_created;
    }

    //Database retriever Constructor
    public Order(int order_id, int user_id, double price, int carport_length, int carport_width, Cladding cladding, Roofing roofing, int shed_width, int shed_length, String time_created) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.price = price;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.cladding = cladding;
        this.roofing = roofing;
        this.shed_width = shed_width;
        this.shed_length = shed_length;
        this.time_created = time_created;
    }

    public Order(int user_id,double price, int carport_length, int carport_width, int cladding_id, int roofing_id, int shed_width, int shed_length) {
        this.user_id = user_id;
        this.price = price;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.cladding_id = cladding_id;
        this.roofing_id = roofing_id;
        this.shed_width = shed_width;
        this.shed_length = shed_length;
    }

    public Order(int user_id,double price, int carport_length, int carport_width, int cladding_id, int roofing_id) {
        this.user_id = user_id;
        this.price = price;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.cladding_id = cladding_id;
        this.roofing_id = roofing_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCarport_length() {
        return carport_length;
    }

    public void setCarport_length(int carport_length) {
        this.carport_length = carport_length;
    }

    public int getCarport_width() {
        return carport_width;
    }

    public void setCarport_width(int carport_width) {
        this.carport_width = carport_width;
    }

    public Cladding getCladding() {
        return cladding;
    }

    public void setCladding(Cladding cladding) {
        this.cladding = cladding;
    }

    public Roofing getRoofing() {
        return roofing;
    }

    public void setRoofing(Roofing roofing) {
        this.roofing = roofing;
    }

    public int getShed_width() {
        return shed_width;
    }

    public void setShed_width(int shed_width) {
        this.shed_width = shed_width;
    }

    public int getShed_length() {
        return shed_length;
    }

    public void setShed_length(int shed_length) {
        this.shed_length = shed_length;
    }

    public String getTime_created() {
        return time_created;
    }

    public void setTime_created(String time_created) {
        this.time_created = time_created;
    }

    public int getCladding_id() {
        return cladding_id;
    }

    public void setCladding_id(int cladding_id) {
        this.cladding_id = cladding_id;
    }

    public int getRoofing_id() {
        return roofing_id;
    }

    public void setRoofing_id(int roofing_id) {
        this.roofing_id = roofing_id;
    }
}