/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoGrupo.models.idao;
import com.proyectoGrupo.models.domain.AsignacionAlumno;
import java.util.List;

/**
 *
 * @author Hugo Daniel Velasquez Patzan
 * Codigo Tecnico IN5BV 
 * @date 30-ago-2021
 * @time 16:24:59
 */
public interface IAsignacionAlumnoDao {
    public List<AsignacionAlumno> listar();
    public AsignacionAlumno encontrar(AsignacionAlumno asignacionAlumno);
    public int insertar(AsignacionAlumno asignacionAlumno);
    public int actualizar(AsignacionAlumno asignacionAlumno);
    public int eliminar(AsignacionAlumno asignacionAlumno);
}
