package cn.jd.sql;

import java.sql.*;
import java.util.Date;

public class DateTypeParameter {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        //1. 新建一个文件夹与src平级，导入驱动jar包，右键选择将文件夹as library
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PracticeDB", "root", "root");
        //4.定义sql语句
        Date date = new Date();
        String sql = "select * from staff where birthday <= "+date;
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        ResultSet resultSet = stmt.executeQuery(sql);
        //7.处理结果
        System.out.println(resultSet); //结果是受影响行数量
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
