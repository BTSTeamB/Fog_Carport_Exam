package PresentationLayer;

public class User
{
    private String name;
    private String address;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private String password;
    private boolean is_admin;
    private int user_id;

    public User(String name, String address, String zipCode, String phoneNumber, String email, String password, boolean is_admin)
    {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    //Database retriever Constructor
    public User(String name, String address, String zipCode, String phoneNumber, String email, String password, boolean is_admin, int user_id)
    {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
        this.user_id = user_id;
    }
}
