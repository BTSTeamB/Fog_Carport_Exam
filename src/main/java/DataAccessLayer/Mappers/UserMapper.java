package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.User;

import java.sql.*;

public class UserMapper {
    private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

    public User login(String email, String password) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM user WHERE email=? AND password=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    int is_admin = rs.getInt("isAdmin");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String zipCode = rs.getString("zip_code");
                    String phoneNumber = rs.getString("phone_no");
                    String eMail = rs.getString("email");
                    String passwordUser = rs.getString("password");
                    User user = new User(user_id, is_admin, name, address, zipCode, phoneNumber, eMail, passwordUser);
                    user.setUser_id(user_id);
                    return user;
                } else {
                    throw new Exception("Du er sus");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void createUser(User user) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = " insert into user(name,address, zip_code,phone_no,email,password) values(?,?,?,?,?,MD5(?))";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, user.getName());
                ps.setString(2, user.getAddress());
                ps.setString(3, user.getZipCode());
                ps.setString(4, user.getPhoneNumber());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getPassword());
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new Exception();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteUser(User user) {

    }

    public void editUser(User user) {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE user SET name=?, address=?,zip_code=?,phone_no=?, email=?, password=MD5(?) WHERE user_id="+user.getUser_id();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, user.getName());
                ps.setString(2, user.getAddress());
                ps.setString(3, user.getZipCode());
                ps.setString(4, user.getPhoneNumber());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getPassword());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(User user) {

        return null;
    }

}

