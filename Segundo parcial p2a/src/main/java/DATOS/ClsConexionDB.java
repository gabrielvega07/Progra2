
package DATOS;
import java.sql.*;

/**
 *
 * @author USUARIOTC
 */
public class ClsConexionDB {
    //conecta con la base de datos
     private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dbalumnosp2a?zeroDateTimeBehavior=CONVERT_TO_NULL";
     private static final String JDBC_USER = "root";
     private static final String JDBC_PWD = "31772910Pablo/";
     
     
     public static Connection getConnection() throws SQLException{//throws si hay problema que tire el sqlexception
         return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PWD);//returnamos la conexion
         
     }
     
     public static void close(ResultSet rs){         
          try {
             rs.close();
         } 
          catch (SQLException ex) {
          ex.printStackTrace(System.out);
         }        
     }
        //prepara la sentencia 
      public static void close(PreparedStatement stmt){
          try {
             stmt.close();
         } 
          catch (SQLException ex) {
          ex.printStackTrace(System.out);
         }         
     }
      //cierra la conexion
      public static void close(Connection cn){
          try {
             cn.close();
         } 
          catch (SQLException ex) {
          ex.printStackTrace(System.out);
         }         
    }     
}
