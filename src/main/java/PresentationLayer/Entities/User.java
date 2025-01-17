package PresentationLayer.Entities;

public class User
{
    private String name;
    private String address;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private String password;
    private int is_admin;
    private int is_guest;
    private int user_id;

    //Database inserter Constructor
    public User(String name, String address, String zipCode, String phoneNumber, String email, String password)
    {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public User(int user_id, String name, String address, String zipCode, String email, String password, String phoneNumber)
    {
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }



    //Database retriever Constructor
    public User( int user_id, int is_admin, int is_guest, String name, String address, String zipCode, String email, String password, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
        this.user_id = user_id;
        this.is_guest = is_guest;
    }


    //Guest constructor
    public User(String name, String address, String zipCode, String phoneNumber, String email)
    {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = "0000";
        this.is_admin = 0;
        this.is_guest = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public int getIs_guest()
    {
        return is_guest;
    }

    public void setIs_guest(int is_guest)
    {
        this.is_guest = 1;
    }
}
