/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadejemploparami.accesoadatos;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadejemploparami.entidades.Alumno;
import universidadejemploparami.entidades.Materia;

public class AlumnoData {
    private Connection con=null;
    
    public AlumnoData(){
    con=Conexion.getConexion();
    }
    
    public void guardarAlumnos(Alumno alumno){
        String sql="INSERT INTO alumno (dni,apellido,nombre,fechaNacimiento,estado)"+
                " VALUES (?,?,?,?,?)";
        
        try {
              PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
              ps.setInt(1,alumno.getDni());
              ps.setString(2,alumno.getApellido());
              ps.setString(3,alumno.getNombre());
              System.out.println("algo");
              ps.setDate(4,Date.valueOf(alumno.getFechaNac())); // pasamos de LocalDate a Date
              System.out.println("algo2");
              ps.setBoolean(5,alumno.isEstado());  //if reducido
              System.out.println("algo3");
              ps.executeUpdate();
              ResultSet rs=ps.getGeneratedKeys();
              /*if(rs.next()){
                  alumno.setIdAlumno(rs.getInt("idAlumno"));
                  
                
              
              
              }*/
              
              JOptionPane.showMessageDialog(null,"Alumno añadido con exito");
              ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Alumno");
        }
        
        
    }
    
    
    public Alumno buscarAlumno(int id){
        Alumno alumno=null;
        
        String sql=" SELECT dni,apellido,nombre,fechaNacimiento FROM alumno WHERE idAlumno=? AND estado=1";
        PreparedStatement ps=null;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                alumno=new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                
                
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno"+ ex.getMessage());
            
        }
            return alumno;   
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        
        Alumno alumno= null;
        
        String sql="SELECT idAlumno,dni,apellido,nombre,fechaNacimiento FROM alumno WHERE dni=? AND estado=1";
        PreparedStatement ps=null;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
        }
        
        return alumno;
       
        
    }
    
    public List<Alumno> listarAlumnos(){
        List<Alumno> alumnos=new ArrayList<>();
        
        try {
            String sql="SELECT * FROM alumno WHERE estado= 1 ";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                alumnos.add(alumno);
                
                
            }
            ps.close();
            
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        }
        
        return alumnos;
        
    }
    
    public void modificarAlumno(Alumno alumno){
        String SQL = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=? WHERE idAlumno=?";
    PreparedStatement ps = null;
    try {
        ps = con.prepareStatement(SQL);
        ps.setInt(1, alumno.getDni());
        ps.setString(2, alumno.getApellido());
        ps.setString(3, alumno.getNombre());
        ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
        ps.setInt(5, alumno.getIdAlumno()); // Asegúrate de establecer el ID adecuado

        int exito = ps.executeUpdate();

        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "El alumno fue modificado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "El alumno no existe o no se pudo modificar");
        }
    } catch (SQLException ex) {
        // Maneja las excepciones de SQL de manera más detallada
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al modificar el alumno: " + ex.getMessage());
    } finally {
        // Cierra la PreparedStatement
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                // Maneja las excepciones de cierre si es necesario
                e.printStackTrace();
            }
        }
    }
    }
    
     public void eliminarAlumno(int id){
         try{
             String sql="UPDATE alumno SET estado = 0 WHERE idAlumno=?";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, id);
             int fila=ps.executeUpdate();
             
             if(fila==1){
                 JOptionPane.showMessageDialog(null, "se borro el alumno con exito");
                 
             }
             ps.close();
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
         }
     }
     
     

        
    
    
    
    
    
}






