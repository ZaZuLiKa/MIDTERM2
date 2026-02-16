package Data.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    public static Connection getConnection(String connectionString) {
        Connection _connection;
        try {
            _connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return _connection;
    }

}
