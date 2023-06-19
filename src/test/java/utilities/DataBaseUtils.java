package utilities;

import java.sql.*;

public class DataBaseUtils {

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement getStatement(){
        try {
            return getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet getResultSet(String query){
        try {
            return   getStatement().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
