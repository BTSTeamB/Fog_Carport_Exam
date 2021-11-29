package PersistenceLayer;

import PresentationLayer.User;

public class UserMapper
{
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public User login(String email, String password)
    {
        return null;
    }

    protected void createUser(User user)
    {

    }

    protected void deleteUser(User user)
    {

    }

    protected void editUser(User user)
    {

    }

    protected User getUser (User user)
    {

        return null;
    }
}
