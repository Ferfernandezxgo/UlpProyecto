/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadejemploparami.entidades;

import java.time.LocalDate;


public class Alumno implements Comparable<Alumno> {
    private int idAlumno;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaNac;
    private boolean estado;

    public Alumno() {
    }

    public Alumno(int idAlumno,int dni, String apellido, String nombre, LocalDate fechaNac, boolean estado) {
        this.idAlumno = idAlumno;
        this.dni=dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.estado = estado;
    }

    public Alumno( int dni,String apellido, String nombre, LocalDate fechaNac, boolean estado) {
       
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.estado = estado;
        this.dni=dni;
    }

    

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    

    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return dni+", "+apellido+", "+nombre;
    }

    @Override
    public int compareTo(Alumno otroAlumno) {
        return this.apellido.compareTo(otroAlumno.getApellido());
    }

    public void setDni(int dni) {
           this.dni=dni;    
    }

    public int getDni() {
        return dni;    
    }
    
            
}
