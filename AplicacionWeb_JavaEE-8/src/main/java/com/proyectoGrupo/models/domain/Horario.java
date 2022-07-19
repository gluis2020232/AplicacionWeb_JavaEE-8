/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoGrupo.models.domain;
import java.sql.Time;
/**
 *
 * @author Hugo Daniel Velasquez Patzan
 * Codigo Tecnico IN5BV 
 * @date 30-ago-2021
 * @time 15:03:59
 */
public class Horario {
    private int idHorario;
    private Time horario_final;
    private Time horario_inicio;

    public Horario() {
    }

    public Horario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Horario(Time horario_final, Time horario_inicio) {
        this.horario_final = horario_final;
        this.horario_inicio = horario_inicio;
    }

    public Horario(int idHorario, Time horario_final, Time horario_inicio) {
        this.idHorario = idHorario;
        this.horario_final = horario_final;
        this.horario_inicio = horario_inicio;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Time getHorario_final() {
        return horario_final;
    }

    public void setHorario_final(Time horario_final) {
        this.horario_final = horario_final;
    }

    public Time getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(Time horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    @Override
    public String toString() {
        return "Horario{" + "idHorario=" + idHorario + ", horario_final=" + horario_final + ", horario_inicio=" + horario_inicio + '}';
    }
    
    
    
    
}
