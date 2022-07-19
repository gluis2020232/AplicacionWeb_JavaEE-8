/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.models.domain;

import java.sql.Date;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Genrry Luis
 */
public class Nota {

    private int idNota;
    private String nombreActividad;
    private int notaActividad;
    private Date fechaActividad;
    
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "asignacion_id", referencedColumnName = "asignacion_id")
    
//   private AsignacionAlumno idAsignacion;
    private String idAsignacion;

    public Nota() {
    }

    public Nota(int idNota) {
        this.idNota = idNota;
    }

    public Nota(String nombreActividad, int notaActividad, Date fechaActividad, String idAsignacion) {
        this.nombreActividad = nombreActividad;
        this.notaActividad = notaActividad;
        this.fechaActividad = fechaActividad;
        this.idAsignacion = idAsignacion;
    }

    public Nota(int idNota, String nombreActividad, int notaActividad, Date fechaActividad, String idAsignacion) {
        this.idNota = idNota;
        this.nombreActividad = nombreActividad;
        this.notaActividad = notaActividad;
        this.fechaActividad = fechaActividad;
        this.idAsignacion = idAsignacion;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getNotaActividad() {
        return notaActividad;
    }

    public void setNotaActividad(int notaActividad) {
        this.notaActividad = notaActividad;
    }

    public Date getFechaActividad() {
        return fechaActividad;
    }

    public void setFechaActividad(Date fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    public String getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(String idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", nombreActividad=" + nombreActividad + ", notaActividad=" + notaActividad + ", fechaActividad=" + fechaActividad + ", idAsignacion=" + idAsignacion + '}';
    }

}
