import util.ConnnectionUtil;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Exam2 {

    public static void main(String[] args) throws SQLException {
        System.out.println("-----------------------------");
        runExam2_1();
        System.out.println("-----------------------------");
        runExam2_2();
    }


    public static void runExam2_1() throws SQLException {
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
    }

    public static void runExam2_2() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        Properties pro = new Properties();
        try {
            pro.load(ConnnectionUtil.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
        }
        String Customer_ID = pro.getProperty("Customer_ID");
        try{
            conn = ConnnectionUtil.getConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "select film.film_id,film.title,y.rental_date from film,\n" +
                    "(select x.inventory_id,x.customer_id,inventory.film_id,x.rental_date from inventory\n" +
                    "inner join (select inventory_id,customer_id,rental_date from rental where customer_id ="+Customer_ID+") as x\n" +
                    "on x.inventory_id = inventory.inventory_id)  y\n" +
                    "where film.film_id = y.film_id\n" +
                    "order by rental_date desc;\n";
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int film_id  = rs.getInt("film_id");
                String title = rs.getString("title");
                String rental_date = rs.getString("rental_date");
                System.out.println(String.format("film_id:%d\ttitle:%s\trental_date:%s",film_id,title,rental_date));
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }finally{
            stmt.close();
        }
    }
}
