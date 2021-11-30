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
        // return userMapper.login(email, password);
        return null;
    }

    public void createUser(String name, String address, String zipCode, String phoneNumber, String email, String password) throws Exception {
        User user = new User(name, address, zipCode, phoneNumber, email, password);
        userMapper.createUser(user);

    }
}
