/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoGrupo.models.domain;

/**
 *
 * @author Hugo Daniel Velasquez Patzan
 * Codigo Tecnico IN5BV 
 * @date 30-ago-2021
 * @time 15:24:52
 */
public class Instructor {
    private int idInstructor;
    private String apellidos; 
    private String nombres;
    private String direccion;
    private String telefono;

    public Instructor() {
    }

    public Instructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public Instructor(String apellidos, String nombres, String direccion, String telefono) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Instructor(int idInstructor, String apellidos, String nombres, String direccion, String telefono) {
        this.idInstructor = idInstructor;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Instructor{" + "idInstructor=" + idInstructor + ", apellidos=" + apellidos + ", nombres=" + nombres + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
    
}
