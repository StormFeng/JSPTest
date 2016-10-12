package com.util;


import java.sql.*;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class DBHelper {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/futruebaby?useSSL=false";
    public static final String USER = "root";
    public static final String PASS = "123456";

    public static Connection conn=null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if(conn==null){
            try {
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void main(String[] args){
        Statement stmt=null;
        try {
            //1.加载驱动程序
            Class.forName(JDBC_DRIVER);
            //2.获得数据库的连接
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            conn = DBHelper.getConnection();
            //3.通过数据库的连接操作数据库，实现增删改查
            stmt = conn.createStatement();
            String sql="SELECT * FROM girl";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("user_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
