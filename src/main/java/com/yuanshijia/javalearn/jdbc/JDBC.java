package com.yuanshijia.javalearn.jdbc;

import java.sql.*;

/**
 * @author yuan
 * @date 2019/9/16
 * @description
 */
public class JDBC {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://cdb-iao00u91.gz.tencentcdb.com:10134/sblog?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8", "root", "yuanshijia1997");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from tb_article");


            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
