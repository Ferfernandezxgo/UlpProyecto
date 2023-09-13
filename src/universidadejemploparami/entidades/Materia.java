/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidadejemploparami.entidades;


public class Materia {
    private int idMateria;
    private String nombre;
    private int anioMateria;
    private boolean estado;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int añoMateria, boolean estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anioMateria = añoMateria;
        this.estado = estado;
    }

    public Materia(String nombre, int añoMateria, boolean estado) {
        this.nombre = nombre;
        this.anioMateria = añoMateria;
        this.estado = estado;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoMateria() {
        return anioMateria;
    }

    public void setAñoMateria(int añoMateria) {
        this.anioMateria = añoMateria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", a\u00f1oMateria=" + anioMateria + ", estado=" + estado + '}';
    }
    
    
    
}
