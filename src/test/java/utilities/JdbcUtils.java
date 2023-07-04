package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    //1. Adım: Driver'a kaydol managementonschools.com
    //2. Adım: Datbase'e bağlan
    public static Connection connectToDataBase() {
       String hostName="managementonschools.com";
        String dbName="school_management";
        String username="select_user";
        String password="43w5ijfso";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/" + dbName, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (connection != null) {
            System.out.println("Connection Success");
        } else {
            System.out.println("Connection Fail");
        }
        return connection;
    }
    //3. Adım: Statement oluştur.
    public static Statement createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }
    //4. Adım: Query çalıştır.
    public static boolean execute(String sql) {
        boolean isExecute;
        try {
            isExecute = statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isExecute;
    }
    //5. Adım: Bağlantı ve Statement'ı kapat.
    public static void closeConnectionAndStatement() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (connection.isClosed() && statement.isClosed()) {
                System.out.println("Connection and statement closed!");
            } else {
                System.out.println("Connection and statement NOT closed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Table oluşturan method
    public static void createTable(String tableName, String... columnName_dataType) {
        StringBuilder columnName_dataValue = new StringBuilder("");
        for (String w : columnName_dataType) {
            columnName_dataValue.append(w).append(",");
        }
        columnName_dataValue.deleteCharAt(columnName_dataValue.length() - 1);
        try {
            statement.execute("CREATE TABLE " + tableName + "(" + columnName_dataValue + ")");
            System.out.println("Table " + tableName + " successfully created!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //ÖDEV:

    //ExecuteQuery methodu
    public static ResultSet executeQuery(String query) {
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    //ExecuteUpdate methodu
    public static int executeUpdate(String query) {
        int guncellenenSatirSayisi;
        try {
            guncellenenSatirSayisi = statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return guncellenenSatirSayisi;
    }
    //Table'a data girme methodu
    public static void insertDataIntoTable(String tableName, String... columnName_Value) {
        StringBuilder columnNames = new StringBuilder("");
        StringBuilder values = new StringBuilder("");
        for (String w : columnName_Value) {
            columnNames.append(w.split(" ")[0]).append(",");//Bir String değeri ikiye bölüp birinciyi sütun adı, ikinciyi sütun değeri olarak alıyorum.
            values.append(w.split(" ")[1]).append(",");
        }
        columnNames.deleteCharAt(columnNames.lastIndexOf(","));//En son virgülü siliyor.
        values.deleteCharAt(values.lastIndexOf(","));
        //"INSERT INTO      members     ( id, name, address ) VALUES(123, 'john', 'new york')"
        String query = "INSERT INTO " + tableName + "(" + columnNames + ") VALUES(" + values + ")";
        execute(query);//execute methodu üstte oluşturuldu, query'yi çalıştırıyor.
        System.out.println("Data " + tableName + " tablosuna girildi.");
    }
    //Sütun Değerlerini List içerisine alan method
    public static List<Object> getColumnList(String columnName, String tableName) {
        List<Object> columnData = new ArrayList<>();//ResultSet'ten alınan datanın koyulacağı List.
        //SELECT        id          FROM      students
        String query = "SELECT " + columnName + " FROM " + tableName;
        executeQuery(query);// => Bu method üstte oluşturuldu. Query'yi çalıştırıp alınan datayı 'resultSet' container'ı içine atama yapıyor.
        try {
            while (resultSet.next()) {
                columnData.add(resultSet.getObject(columnName));//add methodu ile alınan sütun değerlerini List'e ekliyor.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnData;
    }

}