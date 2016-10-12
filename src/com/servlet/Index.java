package com.servlet;

import com.alibaba.fastjson.JSONArray;
import com.util.DBHelper;
import com.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class Index extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String userName=request.getParameter("username");
//        System.out.println(userName);


        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        int i=1;

        try {
            conn = DBHelper.getConnection();
            String sql="SELECT * FROM futruebaby.user WHERE sex=?";
            stmt=conn.prepareStatement(sql);
            stmt.setObject(i,userName);
            rs=stmt.executeQuery();
//            while(rs.next()){
//                System.out.println(rs.getString("user_name"));
//                JSONArray jsonArray = JsonUtil.getJsonArray(rs);
//
//            }
            JSONArray jsonArray = JsonUtil.getJsonArray(rs);
            System.out.println(jsonArray);
            System.out.print(rs.next());
            out.write(jsonArray.toJSONString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
