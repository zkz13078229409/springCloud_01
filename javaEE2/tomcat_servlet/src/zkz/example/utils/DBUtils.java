package zkz.example.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
       private static ComboPooledDataSource data =new ComboPooledDataSource();
       public static Connection openConnection(){
           Connection con=null;
           try {
               con= data.getConnection();
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return con;
       }
       public static void close(Connection con , PreparedStatement pst ,ResultSet rs){
           try{
               if(rs!=null)
                   rs.close();
               if(pst!=null)
                   pst.close();
               con.close();
           }catch(Exception e){
           }
       }
}
