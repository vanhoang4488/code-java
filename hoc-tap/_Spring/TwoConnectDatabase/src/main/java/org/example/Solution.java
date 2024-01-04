package org.example;

import java.sql.*;

/**
 * Test tạo 2 kết nối tới cùng database, xem kết nối bằng JDBC có lấy được dữ liệu không?
 * ==> kết quả là có thể lấy dữ liệu thành công, kể cả với bảng information_schema.columns!
 *
 */
public class Solution {
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "mysql");
        // jdbcConnect1(connection);
        // jdbcConnect2(connection);
        // jdbcConnect3(connection);
        // jdbcConnect4(connection);
    }

    // lấy dữ liệu thành công
    private static void jdbcConnect1(Connection connection) throws SQLException {
        String sql = "select table_name, column_name from information_schema.columns " +
                "where table_schema = 'ctvdatabase' and table_name in ('blogs', 'users') " +
                "order by ordinal_position";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + ": " + resultSet.getString(2));
        }
        connection.close();
    }

    // không thể chạy do quá trình gán parameter cho table_name in (?)
    // đã xảy ra sự hiểu nhầm tham số blogs', 'users là 1 đối tượng duy nhất cần tìm kiếm trong in
    // chứ không hề xét cả câu sql.
    private static void jdbcConnect2(Connection connection) throws SQLException {
        String sql = "select TABLE_NAME, COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS " +
                "where table_schema = ? and table_name in (?) " +
                "order by ORDINAL_POSITION";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "ctvdatabase");
        String[] etities = new String[] {"blogs"};
        StringBuilder tableNameIn = new StringBuilder();
        for (String tableName : etities) {
            tableNameIn.append(tableName).append("','");
        }
        preparedStatement.setString(2, tableNameIn.substring(0, tableNameIn.toString().length() -3));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + ": " + resultSet.getString(2));
        }
        connection.close();
    }

    // không thể chạy do version của thư viện spring data jpa không hỗ trợ.
    private static void jdbcConnect3(Connection connection) throws SQLException {
        String sql = "select TABLE_NAME, COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS " +
                "where table_schema = ? and table_name in (?) " +
                "order by ORDINAL_POSITION";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "ctvdatabase");
        Array in = connection.createArrayOf("CHAR", new String[] {"blogs", "users"});
        preparedStatement.setArray(2, in);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + ": " + resultSet.getString(2));
        }
        connection.close();
    }

    // lấy dữ liệu thành công
    private static void jdbcConnect4(Connection connection) throws SQLException {
        String sql = "select TABLE_NAME, COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS " +
                "where table_schema = ? and table_name in (";
        String[] etities = new String[] {"blogs", "users"};
        for (int i = 0; i < etities.length; i++) {
            sql += "?";
            if (i < etities.length - 1) sql += ",";
        }
        sql += ") " +
                "order by ordinal_position";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "ctvdatabase");
        int pos = 2;
        for (String tableName : etities) {
            preparedStatement.setString(pos, tableName);
            pos++;
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + ": " + resultSet.getString(2));
        }
        connection.close();
    }
}
