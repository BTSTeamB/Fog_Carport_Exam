package Entities;

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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isIs_admin()
    {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin)
    {
        this.is_admin = is_admin;
    }
}
