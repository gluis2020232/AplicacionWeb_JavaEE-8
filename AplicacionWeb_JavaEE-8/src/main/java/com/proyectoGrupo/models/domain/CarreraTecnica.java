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
 * @time 15:13:56
 */
public class CarreraTecnica {
    private String codigoCarrera;
    private String nombre;

    public CarreraTecnica() {
    }
    
    public CarreraTecnica(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    

    public CarreraTecnica(String codigoCarrera, String nombre) {
        this.codigoCarrera = codigoCarrera;
        this.nombre = nombre;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CarreraTecnica{" + "codigoCarrera=" + codigoCarrera + ", nombre=" + nombre + '}';
    }
    
    
    
}
