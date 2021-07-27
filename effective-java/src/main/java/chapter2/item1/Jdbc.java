package chapter2.item1;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Jdbc {
    public void jdbcExample() throws SQLException {
        /*
         *  java.sql.Driver: 서비스 제공자 인터페이스
         *  com.mysql.cj.jdbc.Driver 제공자 인터페이스를 구현하여 제공자 등록 API 를 통해 등록되고 갈아끼워진다.
         */
        Driver driver = new Driver();
        DriverManager.registerDriver(driver); // 제공자 등록 API

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC", "root", "password"); // 서비스 인터페이스

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM test");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
    }
}
