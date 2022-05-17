package source;

import entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSource {

    private static Connection connection;

//    private List<User> getPersonList() {
//    }

    public void addUser(User user) {
    }

    public void save(User user) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO users VALUES (" + user.getId() +
                    ",'" + user.getFirstName() + "',"+
                    ",'" + user.getLastName() + "'," +
                    ",'" + user.getEmail() + "',"+
                    ",'" + user.getPassword() + "'," +
                    ",'" + user.getRole() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
