package cn.sth.electric.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost:3306/electric_system?serverTimezone=UTC";
    public static final String DBUSER="root";
    public static final String DBPASSWARD="mysqladmin";
    public Connection conn=null;
    public DataBaseConnection(){
        try {
            Class.forName(DBDRIVER);
            this.conn= DriverManager.getConnection(DBURL,DBUSER,DBPASSWARD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
    public void close(){
        if(this.conn!=null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
