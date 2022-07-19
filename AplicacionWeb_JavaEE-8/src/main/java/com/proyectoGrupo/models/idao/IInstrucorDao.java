/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoGrupo.models.idao;
import java.util.List;
import com.proyectoGrupo.models.domain.Instructor;
/**
 *
 * @author Hugo Daniel Velasquez Patzan
 * Codigo Tecnico IN5BV 
 * @date 30-ago-2021
 * @time 16:51:43
 */
public interface IInstrucorDao {
    public List<Instructor> listar();
    public Instructor encontrar(Instructor instructor);
    public int insertar(Instructor instructor);
    public int actualizar(Instructor instructor);
    public int eliminar(Instructor instructor); 
    
}
