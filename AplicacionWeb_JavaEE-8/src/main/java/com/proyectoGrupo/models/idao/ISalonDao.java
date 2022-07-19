/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoGrupo.models.idao;
import java.util.List;
import com.proyectoGrupo.models.domain.Salon;
/**
 *
 * @author Hugo Daniel Velasquez Patzan
 * Codigo Tecnico IN5BV 
 * @date 30-ago-2021
 * @time 16:53:54
 */
public interface ISalonDao {
    public List<Salon> listar();
    public Salon encontrar(Salon salon);
    public int insertar(Salon salon);
    public int actualizar(Salon salon);
    public int eliminar(Salon salon);
}
