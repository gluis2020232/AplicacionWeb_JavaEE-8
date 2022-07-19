/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoGrupo.models.idao;
import com.proyectoGrupo.models.domain.Curso;
import java.util.List;

/**
 *
 * @author Hugo Daniel Velasquez Patzan
 * Codigo Tecnico IN5BV 
 * @date 30-ago-2021
 * @time 16:36:09
 */
public interface ICursoDao {
    public List<Curso> listar(); 
    public Curso encontrar(Curso curso);
    public int insertar(Curso curso);
    public int actualuzar(Curso curso);
    public int eliminar(Curso curso);
}
