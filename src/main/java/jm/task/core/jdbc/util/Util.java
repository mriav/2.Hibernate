package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

      private static final String URL = "jdbc:mysql://localhost:3306/bd_jdbs";
      private static final String USER = "root";
      private static final String PASSWORD = "root";

    public Util() {

    }

    public static Connection connection() throws SQLException {
          return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}
