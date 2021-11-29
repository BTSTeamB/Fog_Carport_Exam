package PersistenceLayer;

import PresentationLayer.User;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        super();
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password)
    {
        return userMapper.login(email, password);
    }

    public User createUser(String name, String address, String zipCode, String phoneNumber, String email, String password, boolean is_admin)
    {
        User user = new User(name, address, zipCode, phoneNumber, email, password, is_admin);
        userMapper.createUser(user);
        return user;
    }
}
