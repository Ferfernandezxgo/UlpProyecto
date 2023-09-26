/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadejemploparami.accesoadatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadejemploparami.entidades.Alumno;
import universidadejemploparami.entidades.Inscripcion;
import universidadejemploparami.entidades.Materia;

public class InscripcionData {

    private Connection con = null;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        con = Conexion.getConexion();
        matData=new MateriaData();
        aluData=new AlumnoData();
    }
        
         

    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?, ?, ?)";

    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setInt(1, insc.getAlumno().getIdAlumno());
        ps.setInt(2, insc.getMateria().getIdMateria());
        ps.setDouble(3, insc.getNota());

        int Colum = ps.executeUpdate();

        if (Colum > 0) {
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    insc.setIdInscripcion(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Inscripcion registrada");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo obtener el ID de la inscripcion registrada.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo insertar la inscripcion.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
    }

    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
    List<Inscripcion> inscripciones = new ArrayList<>();
    String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
 
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idAlumno);
        ResultSet rs = ps.executeQuery();
        
       
            
             

        while (rs.next()) {
            Inscripcion insc = new Inscripcion();
            insc.setIdInscripcion(rs.getInt("idInscripcion"));
            Alumno alu=aluData.buscarAlumno(rs.getInt("idAlumno"));
            Materia mat=matData.buscarMateria(rs.getInt("idMateria"));
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getDouble("nota"));
            inscripciones.add(insc);

            // Obtener información de alumno y materia aquí y establecerla en insc

            ps.close();
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + ex.getMessage());
    }
    return inscripciones;
}
   
    public void actualizarNota(int idInscripcion, double nota) {
    String sql = "UPDATE inscripcion SET nota = ? WHERE idInscripcion = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setDouble(2, nota);
        ps.setInt(1, idInscripcion);

        int rowsUpdated = ps.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Nota actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la nota.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + ex.getMessage());
    }
}

   public List<Inscripcion> obtenerInscripciones() {
    List<Inscripcion> inscripciones = new ArrayList<>();
    String sql = "SELECT * FROM inscripcion";

    try (PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Inscripcion insc = new Inscripcion();
            insc.setIdInscripcion(rs.getInt("idInscripcion"));
            Alumno alu=aluData.buscarAlumno(rs.getInt("idAlumno"));
            Materia mat=matData.buscarMateria(rs.getInt("idMateria"));
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getDouble("nota"));
            inscripciones.add(insc);

            // Obtener información de alumno y materia aquí y establecerla en insc

            ps.close();
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + ex.getMessage());
    }
    return inscripciones;

    
} 
   
   
  
   public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
    String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idAlumno);
        ps.setInt(2, idMateria);

        int rowsDeleted = ps.executeUpdate();

        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null, "Inscripción eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la inscripción para eliminar.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al eliminar inscripción: " + ex.getMessage());
    }
    
   }
    
    
    public List <Materia> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<Materia> materias=new ArrayList<>();
        String sql="Select inscripcion.idMateria, nombre, año FROM inscripcion,"
                +" materia WHERE inscripcion.idMateria=materia.idMateria "+
                " AND inscripcion.idAlumno=?;";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAñoMateria(rs.getInt("año"));
                materias.add(materia);
                
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder ala tabla inscripciones");
            ex.printStackTrace();
        }
        return materias;
    }
    
    
   

   public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
    List<Alumno> alumnos = new ArrayList<>();
    String sql = " SELECT a.idAlumno,dni,nombre,apellido,FechaNacimiento,estado "
            + " FROM inscripcion i,alumno a WHERE i.idAlumno=a.idAlumno AND idMateria=?";

    
    try {
        PreparedStatement ps = con.prepareCall(sql);
        ps.setInt(1, idMateria);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

                alumnos.add(alumno);
            }
            ps.close();
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener alumnos por materia: " + ex.getMessage());
    }

    return alumnos;
}
   
   
   public List<Materia> obtenerMateriasNoCursadas(int idAlumno){
       ArrayList<Materia> materias=new ArrayList<>();
       String sql="Select * FROM materia WHERE estado=1 AND idMateria not in "
               +"(SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
       try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAñoMateria(rs.getInt("año"));
                materias.add(materia);
                
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder ala tabla inscripciones");
            
        }
        return materias;
   }
}
