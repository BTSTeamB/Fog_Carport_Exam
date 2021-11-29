package PresentationLayer;

public class Order
{
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

    public Order(int user_id, double price, int carport_length, int carport_width, Cladding cladding, Roofing roofing, int shed_width, int shed_length, String time_created)
    {
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
    public Order(int order_id, int user_id, double price, int carport_length, int carport_width, Cladding cladding, Roofing roofing, int shed_width, int shed_length, String time_created)
    {
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
}
