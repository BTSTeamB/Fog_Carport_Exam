package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.User;

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

    public void createUser(User user)
    {

    }

    public void deleteUser(User user)
    {

    }

    public void editUser(User user)
    {

    }

    public User getUser (User user)
    {

        return null;
    }
}
