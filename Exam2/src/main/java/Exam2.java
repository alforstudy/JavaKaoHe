import util.ConnnectionUtil;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Exam2 {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        Properties pro = new Properties();
        try {
            pro.load(ConnnectionUtil.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
        }
        String Country_ID = pro.getProperty("Country_ID");
        try{
            conn = ConnnectionUtil.getConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "select city.city_id,city from country,city where country.country_id="+Country_ID+" and country.country_id = city.country_id; ";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("city_id");
                String c_name = rs.getString("city");

                // 输出数据
                System.out.println("ID: " + id + "-----" + "城市名称: " + c_name);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }finally{
            stmt.close();
        }
        System.out.println("Goodbye!");
    }
}
