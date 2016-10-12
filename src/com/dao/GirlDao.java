package com.dao;

import com.entity.GirlBean;
import com.mysql.jdbc.log.Log;
import com.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class GirlDao {

    public ArrayList<GirlBean> getAllGirl(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<GirlBean> list=new ArrayList<>();
        try {
            conn = DBHelper.getConnection();
            String sql="SELECT * FROM girl";
            stmt = conn.prepareStatement(sql);
            rs =stmt.executeQuery();
            while(rs.next()){
                GirlBean bean=new GirlBean();
                bean.setId(rs.getInt("id"));
                bean.setAge(rs.getInt("age"));
                bean.setBirthday(rs.getString("birthday"));
                bean.setEmail(rs.getString("email"));
                bean.setMobile(rs.getString("mobile"));
                bean.setUser_name(rs.getString("user_name"));
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs!=null||stmt!=null){
                try {
                    rs.close();
                    rs=null;
                    stmt.close();
                    stmt=null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
