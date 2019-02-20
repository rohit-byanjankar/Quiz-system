package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class DatabaseConnection {
        private final String url = "jdbc:mysql://localhost:3306/deerwalk";
        private final String user = "root";
        private final String password = "";
        public Connection connection = null;

        public DatabaseConnection() {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public PreparedStatement getPreparedStatement(String query){
            PreparedStatement preparedStatement=null;
            try{
                preparedStatement=connection.prepareStatement(query);
            } catch(Exception e){
                e.printStackTrace();
            }
            return preparedStatement;
        }
    }


