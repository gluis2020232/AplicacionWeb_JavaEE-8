/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoGrupo.models.idao;
import com.proyectoGrupo.models.domain.CarreraTecnica;
import java.util.List;

/**
 *
 * @author Hugo Daniel Velasquez Patzan
 * Codigo Tecnico IN5BV 
 * @date 30-ago-2021
 * @time 16:30:46
 */
public interface ICarreraTecnicaDao {
    public List<CarreraTecnica> listar();
    public CarreraTecnica encontrar(CarreraTecnica carreraTecnica);
    public int insertar(CarreraTecnica carreraTecnica);
    public int actualizar(CarreraTecnica carreraTecnica);
    public int eliminar(CarreraTecnica carreraTecnica); 
}
