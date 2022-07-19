/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoGrupo.models.idao;
import com.proyectoGrupo.models.domain.Horario;
import java.util.List;

/**
 *
 * @author Hugo Daniel Velasquez Patzan
 * Codigo Tecnico IN5BV 
 * @date 30-ago-2021
 * @time 16:48:30
 */
public interface IHorarioDao {
    public List<Horario> listar();
    public Horario encontrar(Horario horario);
    public int insertar(Horario horario);
    public int actualizar(Horario horario);
    public int eliminar(Horario horario);

}
