/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.models.idao;

import com.proyectoGrupo.models.domain.Nota;
import java.util.List;

/**
 *
 * @author César Luis
 */
public interface INotaDao {
    public List<Nota> listar();
    public Nota encontrar(Nota nota);
    public int insertar(Nota nota);
    public int actualizar(Nota nota);
    public int eliminar(Nota nota); 
}
