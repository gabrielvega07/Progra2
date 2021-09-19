
package DATOS;

import DOMINIOS.ClsEmpleados;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIOTC
 */
public class ClsVendedores {
    

//constatantes
    private static final String SQL_SELECT = "select * from tb_empleados";
    private static final String SQL_UPDATE = "update tb_empleados set nombre=?,enero=?,febrero=?, marzo=?,total=?,promedio=? where codigo=?";
    private static final String SQL_INSERT = "insert into tb_empleados(nombre,enero,febrero,marzo,total,promedio) values(?,?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from tb_empleados where codigo=?";
   
    private static final int promedio = 3;
    
    
    
    //select, update, insert, delete
    public List<ClsEmpleados> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsEmpleados vendedor = null;
        List <ClsEmpleados> vendedores = new ArrayList<ClsEmpleados>();
        
        try {
            conn = ClsConexionDB.getConnection(); //se conecta
            stmt = conn.prepareStatement(SQL_SELECT); //llamamos sql_select
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                int enero = rs.getInt("enero");
                int febrero = rs.getInt("febrero");
                int marzo = rs.getInt("marzo");
                int total = rs.getInt("total");
                double promedio = rs.getDouble("promedio");
                
                vendedor = new ClsEmpleados();
                vendedor.setCodigo(codigo);
                vendedor.setNombre(nombre);
                vendedor.setEnero(enero);
                vendedor.setFebrero(febrero);
                vendedor.setMarzo(marzo);
                vendedor.setTotal(total);
                vendedor.setPromedio(promedio);
                
                vendedores.add(vendedor);                                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ClsConexionDB.close(rs);
            ClsConexionDB.close(stmt);
            ClsConexionDB.close(conn);
        }
        return vendedores; 
    } 
    
    
    public int Update(ClsEmpleados empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;
        try {
            conn = ClsConexionDB.getConnection();//se conecta
            stmt = conn.prepareStatement(SQL_UPDATE); //llamamos sql_update
//parametros 
            stmt.setString(1, empleado.getNombre());
            stmt.setDouble(2, empleado.getEnero());
            stmt.setDouble(3, empleado.getFebrero());
            stmt.setDouble(4, empleado.getMarzo());
            stmt.setDouble(5, (empleado.getEnero() + empleado.getFebrero() + empleado.getMarzo()));
            stmt.setDouble(6, ((empleado.getEnero() + empleado.getFebrero() + empleado.getMarzo()) / promedio));
            stmt.setInt(7, empleado.getCodigo());
       
            
            System.out.println("running query... " + SQL_UPDATE); //ejecucion query 
            filas = stmt.executeUpdate();//ejecucion update
            System.out.println("data affected: " + filas);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexionDB.close(stmt);
            ClsConexionDB.close(conn);
        }        
        return filas;
    }
    
    public int insert(ClsEmpleados empleado){//inserta empleados, creamos la parte de insert y le mandamos como parametro empleado
        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;
        try {
            conn = ClsConexionDB.getConnection(); //se conecta
            stmt = conn.prepareStatement(SQL_INSERT); //llamamos aql_insert 

            stmt.setString(1, empleado.getNombre());
            stmt.setDouble(2, empleado.getEnero());
            stmt.setDouble(3, empleado.getFebrero());
            stmt.setDouble(4, empleado.getMarzo());
            stmt.setDouble(5, (empleado.getEnero() + empleado.getFebrero() + empleado.getMarzo()));
            stmt.setDouble(6, ((empleado.getEnero() + empleado.getFebrero() + empleado.getMarzo()) / promedio));
            
            System.out.println("running query... " + SQL_INSERT);
            filas = stmt.executeUpdate();
            System.out.println("data affected: " + filas);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexionDB.close(stmt);
            ClsConexionDB.close(conn);
        }       
        return filas;
    }
    

    public int deleteData(ClsEmpleados vendedor){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int filas = 0;
        try {
            conn = ClsConexionDB.getConnection();//se conecta
            stmt = conn.prepareStatement(SQL_DELETE);//llamamos sql_delete
            stmt.setInt(1, vendedor.getCodigo());
            System.out.println("Empleado eliminado correctamente " + SQL_DELETE);
            filas = stmt.executeUpdate();
            System.out.println("data affected: " + filas);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexionDB.close(stmt);
            ClsConexionDB.close(conn);
        }
        return filas;
    }
   
    
    public DefaultTableModel showInf(){
        String [] columna = {"codigo","nombre","enero","febrero","marzo","total","promedio"};
        String [] records = new String[7];
        
        DefaultTableModel titulo = new DefaultTableModel(null,columna);        
        Connection conn = null;
        PreparedStatement stmt = null;        
        ResultSet rs = null;
    
    try{
        conn = ClsConexionDB.getConnection();//se conecta
        stmt = conn.prepareStatement(SQL_SELECT); //llamamos sql_select                      
        rs = stmt.executeQuery();
        
        while(rs.next()){
            records[0] = rs.getString("codigo");
            records[1] = rs.getString("nombre");
            records[2] = rs.getString("enero");
            records[3] = rs.getString("febrero");
            records[4] = rs.getString("marzo");
            records[5] = rs.getString("total");
            records[6] = rs.getString("promedio");
                
            titulo.addRow(records);                
            }
        
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error");  
        }
        finally{
            
        try{
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,7);
            }
        }
        return titulo;
    }
}
    