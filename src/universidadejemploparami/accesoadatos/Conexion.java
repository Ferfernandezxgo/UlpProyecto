/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadejemploparami.accesoadatos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

        
public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="universidadulp2";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Connection connection;
    
    
    private Conexion(){}
    public static Connection getConexion(){
        if (connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
                JOptionPane.showMessageDialog(null,"Conectado con exito"+ ""+JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex)   {
                JOptionPane.showMessageDialog(null,JOptionPane.ERROR_MESSAGE+"Error al cargar los drivers"+ex);
            } catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse viejo"+ ex+JOptionPane.ERROR_MESSAGE);
                
            }
        }
        return connection;
    }
    
}
