package ServiceLayer.Facades;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.UserMapper;
import Entities.User;

public class UserFacade {
    UserMapper userMapper;

    public UserFacade(Database database) {

        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) {
        User user;
        return null;
    }

    public User getUser(String email, String password) throws Exception
    {
        User user = null;
        user = userMapper.getUser(email, password);
        return user;
    }

    public void createUser(String name, String address, String zipCode, String email, String password, String phoneNumber) throws Exception {
        User user = new User(name, address, zipCode, email, password, phoneNumber);
        userMapper.createUser(user);

    }
}