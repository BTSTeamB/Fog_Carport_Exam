package PersistenceLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
    private Connection connection;
    private final String USER;
    private final String PASSWORD;
    private final String URL;

    public Database(String user, String password, String url) throws ClassNotFoundException
    {
            USER = "mikkel";
            PASSWORD = "Mikkel405!";
            URL = "jdbc:mysql://164.90.177.28:3306/Fog_carport?serverTimezone=CET";

            //Foo-bar (Placeholder) (To be deleted)
            Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public Connection connect() throws SQLException
    {
        Connection connection = null;
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

}
