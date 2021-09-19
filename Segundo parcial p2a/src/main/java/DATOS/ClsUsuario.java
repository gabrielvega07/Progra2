
package DATOS;

import DOMINIOS.ClsUsers;
import java.sql.*;
//import java.util.*;

/**
 *
 * @author USUARIOTC
 */
public class ClsUsuario {
    
                      
    private static final String SQL_SELECT = "select * from tb_usser";
    private static final String SQL_SELECT_VALIDACION = "select * from tb_usser where username=?"+"and password=?";
    
    
   
    
    public boolean select_validacion(ClsUsers datos){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsUsers usuario = new ClsUsers();
        boolean tiene_permiso = false;
        
        try {
            conn = ClsConexionDB.getConnection();//creamos conexion
            String condicion = SQL_SELECT + " where username='"+datos.getUsername()+"'"+" and password='"+datos.getPassword()+"'";
                     
            stmt = conn.prepareStatement(condicion);//isntruccion Select
            rs = stmt.executeQuery();//devuelve un result set
            
            while(rs.next()){
                tiene_permiso = true;
                int id_usuario = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
 
                usuario = new ClsUsers();
                usuario.setId(id_usuario);
                usuario.setUsername(username);
                usuario.setPassword(password);             
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ClsConexionDB.close(rs);
            ClsConexionDB.close(stmt);
            ClsConexionDB.close(conn);
        }
        return tiene_permiso; 
    }
    
    
    
}
