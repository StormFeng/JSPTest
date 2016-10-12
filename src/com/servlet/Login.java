package com.servlet;

import com.alibaba.fastjson.JSONObject;
import com.util.DBHelper;
import com.util.JsonUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * Created by Administrator on 2016/10/11 0011.
 */
@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        String account=request.getParameter("account");
        String password=request.getParameter("password");
        System.out.println(account+":"+password);

        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        JSONObject jsonObject=null;
        JSONObject base = new JSONObject();
        try {
            conn = DBHelper.getConnection();
            String query="SELECT user.user_id,user.name,user.phone,user.sex FROM user WHERE name=?";
            stmt=conn.prepareStatement(query);
            stmt.setObject(1,account);
            rs=stmt.executeQuery();
            if(!rs.next()){
                base.put("ret","error");
                base.put("ret_code","login_error");
                base.put("ret_info","用户不存在");
                base.put("content",jsonObject);
                out.write(base.toString());
                return;
            }
            String sql="SELECT user.user_id,user.name,user.phone,user.sex FROM user WHERE name=? AND password=?";
            stmt=conn.prepareStatement(sql);
            stmt.setObject(1,account);
            stmt.setObject(2,password);
            rs=stmt.executeQuery();
            if(rs.next()){
                jsonObject = JsonUtil.getJsonObject(rs);
                base=new JSONObject();
                base.put("ret","success");
                base.put("ret_code","login_success");
                base.put("ret_info","登录成功");
                base.put("content",jsonObject);
                out.write(base.toString());
            }else{
                base.put("ret","error");
                base.put("ret_code","login_error");
                base.put("ret_info","登录失败");
                base.put("content",jsonObject);
                out.write(base.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
