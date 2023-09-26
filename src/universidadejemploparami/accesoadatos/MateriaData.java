/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadejemploparami.accesoadatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemploparami.entidades.Materia;



public class MateriaData {
    private Connection con=null;
    
    public MateriaData(){
        con=Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        String sql="INSERT INTO materia(idMateria,nombre,año,estado) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, materia.getIdMateria());
            ps.setString(2, materia.getNombre());
            ps.setInt(3,materia.getAñoMateria());
            ps.setBoolean(4,materia.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                materia.setIdMateria(rs.getInt("idMateria"));
                JOptionPane.showMessageDialog(null, "Materia agregada con exito");
                
            }
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        
        
    }
    
    public Materia buscarMateria(int id){
        Materia materia=null;
        String sql="SELECT nombre,año,estado from materia where idMateria=? AND estado=1";
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            
            if(rs.next()){
                materia= new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAñoMateria(rs.getInt("año"));
                materia.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "no existe la materia");
                
            }
            ps.close();
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia");
        }
        
        return materia;
        
        
        
    }
    
    public void modificarMateria(Materia materia){
        String SQL="UPDATE materia set nombre=?,año=?,estado=? WHERE idMateria=?";
        PreparedStatement ps=null;
        try{
            ps=con.prepareStatement(SQL);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAñoMateria());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());
            int exito=ps.executeUpdate();
            
            if(exito==1){
                JOptionPane.showMessageDialog(null, "La materia fue modificada con exito");
            }else{
                JOptionPane.showMessageDialog(null, "La materia no existe");
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia") ;
    }
    
}
    
    
    
    public void eliminarMateria(int id){
        
        try{
            String sql="UPDATE materia SET estado=0 WHERE idMateria= ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            int fila=ps.executeUpdate();
            
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Se elimino la materia");
                
                    }
                ps.close();
                
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
           }
    }
    
    
    
    
    public List<Materia> listarMaterias(){
        List<Materia> materias=new ArrayList<>();
        try{
            String sql="SELECT * FROM materia WHERE estado=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           while(rs.next()){
            
            Materia materia=new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAñoMateria(rs.getInt("año"));
            materia.setEstado(rs.getBoolean("estado"));
            materias.add(materia);
            
            
            
            
        }
           ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        return materias;
    }
    
}
