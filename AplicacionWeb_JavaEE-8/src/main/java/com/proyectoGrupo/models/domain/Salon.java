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
 * @time 15:09:13
 */
public class Salon {
    private int idSalon;
    private int capacidad;
    private String descripcion;
    private String nombre_salon;

    public Salon() {
    }

    public Salon(int idSalon) {
        this.idSalon = idSalon;
    }

    public Salon(int capacidad, String descripcion, String nombre_salon) {
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.nombre_salon = nombre_salon;
    }

    public Salon(int idSalon, int capacidad, String descripcion, String nombre_salon) {
        this.idSalon = idSalon;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.nombre_salon = nombre_salon;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_salon() {
        return nombre_salon;
    }

    public void setNombre_salon(String nombre_salon) {
        this.nombre_salon = nombre_salon;
    }

    @Override
    public String toString() {
        return "Salon{" + "idSalon=" + idSalon + ", capacidad=" + capacidad + ", descripcion=" + descripcion + ", nombre_salon=" + nombre_salon + '}';
    }
    
    
    
}
