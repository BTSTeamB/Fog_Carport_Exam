package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.User;

import java.sql.*;

public class UserMapper {
    private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

    public void createUser (User user) throws Exception {
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


    public void deleteUser (User user){

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

    public User getUserByID (int search_id) throws Exception
    {
        User tmpUser = null;
        try(Connection connection = database.connect())
        {

            String sql = " SELECT * FROM user WHERE user_id='"+search_id+"'";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next())
                {
                    int user_id = rs.getInt("user_id");
                    int is_admin = rs.getInt("isAdmin");
                    String userName = rs.getString("name");
                    String userAddress = rs.getString("address");
                    String userZipCode = rs.getString("zip_code");
                    String userPhoneNumber = rs.getString("phone_no");
                    String userEmail = rs.getString("email");
                    String userPassword = rs.getString("password");

                    System.out.println(userName);
                    System.out.println(userAddress);
                    System.out.println(userZipCode);
                    System.out.println(userPhoneNumber);
                    System.out.println(userEmail);
                    System.out.println(userPassword);

                    tmpUser = new User(user_id, is_admin, userName, userAddress, userZipCode, userEmail, userPassword, userPhoneNumber);
                }

            } catch (SQLIntegrityConstraintViolationException e) {
                throw new Exception();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpUser;
    }





    public User getUser (String email, String password) throws Exception
    {
        User tmpUser = null;
        try(Connection connection = database.connect())
        {
            String sql = " SELECT * FROM user WHERE email='"+email+"' AND password=MD5('"+password+"')";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next())
                {
                    int user_id = rs.getInt("user_id");
                    int is_admin = rs.getInt("isAdmin");
                    String userName = rs.getString("name");
                    String userAddress = rs.getString("address");
                    String userZipCode = rs.getString("zip_code");
                    String userPhoneNumber = rs.getString("phone_no");
                    String userEmail = rs.getString("email");
                    String userPassword = rs.getString("password");

                    System.out.println(userName);
                    System.out.println(userAddress);
                    System.out.println(userZipCode);
                    System.out.println(userPhoneNumber);
                    System.out.println(userEmail);
                    System.out.println(userPassword);

                    tmpUser = new User(user_id, is_admin, userName, userAddress, userZipCode, userEmail, userPassword, userPhoneNumber);
                }

            } catch (SQLIntegrityConstraintViolationException e) {
                throw new Exception();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmpUser;
    }

}