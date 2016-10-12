package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class JsonUtil {

    public static JSONObject getJsonObject(ResultSet rs) throws SQLException {
        Map<String,String> map=new HashMap<>();
        ResultSetMetaData data=rs.getMetaData();
        int count=data.getColumnCount();
        for(int i=1;i<=count;i++){
            map.put(data.getColumnLabel(i),rs.getString(i));
        }
        return JSONObject.parseObject(JSON.toJSONString(map));
    }

    public static JSONArray getJsonArray(ResultSet rs) throws SQLException {
        JSONArray jsonArray=new JSONArray();
        ResultSetMetaData data=rs.getMetaData();
        int count=data.getColumnCount();
        Map<String,String> map;
        JSONObject jsonObject=null;
        while (rs.next()){
            map=new HashMap<>();
            for(int i=1;i<=count;i++){
                map.put(data.getColumnLabel(i),rs.getString(i));
                jsonObject = JSONObject.parseObject(JSON.toJSONString(map));
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
