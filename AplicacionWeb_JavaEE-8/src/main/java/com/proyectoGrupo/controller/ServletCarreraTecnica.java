/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.controller;

import com.proyectoGrupo.models.dao.ProyectoGrupoDaoImpl;
import com.proyectoGrupo.models.domain.CarreraTecnica;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import com.proyectoGrupo.models.dao.CarreraTecnicaDaoImpl;
import java.util.List;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author César Luis
 */
@WebServlet("/ServletCarreraTecnica")
public class ServletCarreraTecnica extends HttpServlet implements Serializable {

    //Aceptar las peticiones doPost
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("\ndoPost");

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        System.out.println("accion: " + accion);

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCarrerasTecnicas(request, response);
                    break;
                case "actualizar":
                    actualizarCarrerasTecnicas(request, response);
                    break;
            }
        }
    }
    
    
    private void actualizarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Recuperar los valores del formulario agregar estudiante 
        String codigoCarrera = request.getParameter("codigoCarrera");
        System.out.println("codigo carrera: " + codigoCarrera);
        
        String nombre = request.getParameter("nombre");
        System.out.println("Nombre carrera: " +  nombre);

        //Crear el obejeto estudiante utilizando bean
        CarreraTecnica carreraTecnica = new CarreraTecnica(codigoCarrera, nombre);
        System.out.println(carreraTecnica); 
        
        //Insertar el nuevo objeto a la base de datos
        int registrosActualizados = new CarreraTecnicaDaoImpl().actualizar(carreraTecnica);

        System.out.println("Registros insertados: " + registrosActualizados);
        
        //Redirigimos hacia listar estudiantes...
        listarCarreraTecnica(request, response);

    }
    

    private void insertarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insertar Carrera Tecnica");

        //Recuperar los valores del formulario agregar carrerasTecnicas
        String codigoCarrera = request.getParameter("codigoCarrera");
        String nombre = request.getParameter("nombre");

        //Crear el objeto de tipo CarreraTecnica utilizando bean
        CarreraTecnica carreraTecnica = new CarreraTecnica(codigoCarrera, nombre);
        System.out.println(carreraTecnica);

        //Insertar el objeto CarreraTecnica a la base de datos
        int registrosIngresados = new CarreraTecnicaDaoImpl().insertar(carreraTecnica);

        System.out.println("Registros insertados: " + registrosIngresados);

        //Redirigimos hacia listar estudiantes...
        listarCarreraTecnica(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarCarreraTecnica(request, response);
                    break;
                case "editar":
                    editarCarreraTecnica(request, response);
                    break;
                case "eliminar":
                    eliminarCarreraTecnica(request, response);
                    break;
            }
        }
    }
    
    private void editarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        //Recuperar el id del Estudiante
        String codigoCarrera = request.getParameter("codigo_carrera");
        
        //Crear el objeto de tipo estudiante
        CarreraTecnica carreraTecnica = new CarreraTecnicaDaoImpl().encontrar(new CarreraTecnica(codigoCarrera));  
        System.out.println(carreraTecnica);
        
        //Enviamos la informacion al jsp que me cargue en un formulario
        request.setAttribute("carreraTecnica", carreraTecnica);
        
        //Redireccionar hacia un jsp
        request.getRequestDispatcher("carreras_tecnicas/editar-carreras-tecnicas.jsp").forward(request, response);
        
    }
    

    private void eliminarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigoCarrera = request.getParameter("codigo_carrera");

        CarreraTecnica carreraTecnica = new CarreraTecnica(codigoCarrera);

        int registrosEliminados = new CarreraTecnicaDaoImpl().eliminar(carreraTecnica);
        System.out.println("Registros Eliminados: " + registrosEliminados);

        listarCarreraTecnica(request, response);
    }

    private void listarCarreraTecnica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<CarreraTecnica> listaCarrerasTecnicas = new CarreraTecnicaDaoImpl().listar();

        //Enviamos esa lista que va ir como atributo
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCarrerasTecnicas", listaCarrerasTecnicas);

        response.sendRedirect("carreras_tecnicas/listarCarrerasTecnicas.jsp");
    }

}