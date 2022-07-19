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
 * @time 14:59:05
 */
public class Alumno {
    private String carne;
    private String apellidos;
    private String nombres;
    private String email;

    public Alumno() {
    }

    public Alumno(String carne) {
        this.carne = carne;
    }

    public Alumno(String apellidos, String nombres, String email) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.email = email;
    }

    public Alumno(String carne, String apellidos, String nombres, String email) {
        this.carne = carne;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.email = email;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Alumno{" + "carne=" + carne + ", apellidos=" + apellidos + ", nombres=" + nombres + ", email=" + email + '}';
    }
    
    
    
    
    
}
