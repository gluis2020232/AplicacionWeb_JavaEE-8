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
 * @time 15:35:39
 */
public class Curso {
    private int idCurso;
    private int ciclo;
    private int cupoMaximo; 
    private int cupoMinimo; 
    private String descripcion;
    private String codigoCarrera; 
    private int idHorario;
    private int idInstructor; 
    private int idSalon; 

    public Curso() {
    }

    public Curso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(int ciclo, int cupoMaximo, int cupoMinimo, String descripcion, String codigoCarrera, int idHorario, int idInstructor, int idSalon) {
        this.ciclo = ciclo;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
        this.descripcion = descripcion;
        this.codigoCarrera = codigoCarrera;
        this.idHorario = idHorario;
        this.idInstructor = idInstructor;
        this.idSalon = idSalon;
    }

    public Curso(int idCurso, int ciclo, int cupoMaximo, int cupoMinimo, String descripcion, String codigoCarrera, int idHorario, int idInstructor, int idSalon) {
        this.idCurso = idCurso;
        this.ciclo = ciclo;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
        this.descripcion = descripcion;
        this.codigoCarrera = codigoCarrera;
        this.idHorario = idHorario;
        this.idInstructor = idInstructor;
        this.idSalon = idSalon;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(int cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", ciclo=" + ciclo + ", cupoMaximo=" + cupoMaximo + ", cupoMinimo=" + cupoMinimo + ", descripcion=" + descripcion + ", codigoCarrera=" + codigoCarrera + ", idHorario=" + idHorario + ", idInstructor=" + idInstructor + ", idSalon=" + idSalon + '}';
    }
    
    
    
    
}
