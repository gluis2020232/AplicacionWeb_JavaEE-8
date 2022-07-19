 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.controller;

import com.proyectoGrupo.models.dao.AsignacionAlumnoDaoImpl;
import com.proyectoGrupo.models.dao.NotaDaoImpl;
import com.proyectoGrupo.models.domain.AsignacionAlumno;
import com.proyectoGrupo.models.domain.Nota;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Genrry Luis
 */                                 

@WebServlet("/ServletNota")
public class ServletNota extends HttpServlet implements Serializable {
    
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
                   insertarNotas(request, response);
                    break;
                case "actualizar":
                    actualizarNotas(request, response);
                    break;
            }
        }
    }
    
    private void actualizarNotas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        //Recuperar los valores del formulario agregar estudiante         
        int idNota = Integer.parseInt(request.getParameter("idNota"));
        String nombreActividad = request.getParameter("nombreActividad");
        int notaActividad = Integer.parseInt(request.getParameter("notaActividad"));
        Date fechaActividad = Date.valueOf(request.getParameter("fechaActividad"));
        String idAsignacion = request.getParameter("idAsignacion");
        
    //    AsignacionAlumno asignacionAlumno = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(idAsignacion));
    //    System.out.println(asignacionAlumno);

        //Crear el obejeto estudiante utilizando bean
        Nota nota = new Nota(idNota, nombreActividad, notaActividad, fechaActividad, idAsignacion);
        System.out.println(nota);
        
        //Insertar el nuevo objeto a la base de datos
        int registrosActualizados = new NotaDaoImpl().actualizar(nota);

        System.out.println("Registros insertados: " + registrosActualizados);
        
        //Redirigimos hacia listar estudiantes...
        listarNota(request, response);

    }
    
    
    private void insertarNotas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insertarNotas");
        
        String nombreActividad = request.getParameter("nombreActividad");
        int notaActividad = Integer.parseInt(request.getParameter("notaActividad"));
        Date fechaActividad =  Date.valueOf(request.getParameter("fechaActividad"));
        String idAsignacion = request.getParameter("idAsignacion");
        
    //    AsignacionAlumno asignacionAlumno = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(idAsignacion));
    //    System.out.println(asignacionAlumno);
        
        //Crear el obejeto nota utilizando bean      
        Nota nota = new Nota(nombreActividad, notaActividad, fechaActividad, idAsignacion);
        System.out.println(nota);

        //Insertar el nuevo objeto a la base de datos
        //Creamos una variable de tipo int para almacenar la cantidad de registros ingresados        
        int registrosIngresados = new NotaDaoImpl().insertar(nota);

        System.out.println("Registros insertados: " + registrosIngresados);

        //Redirigimos hacia listar notas
        listarNota(request, response);

    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarNota(request, response);
                    break;
                case "editar":
                    editarNota(request, response);
                    break;
                case "eliminar":
                    eliminarNota(request, response);
                    break;
            }
        }
    }
    
    private void editarNota(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        //Recuperar el id de Nota
        int idNota = Integer.parseInt(request.getParameter("id_nota"));
        
        //Crear el objeto de tipo nota
        Nota nota = new NotaDaoImpl().encontrar(new Nota(idNota));
        System.out.println(nota);
        
        //Enviamos la informacion al jsp que me cargue en un formulario
        request.setAttribute("nota", nota);
        
        //Redireccionar hacia un jsp
        request.getRequestDispatcher("nota/editar-notas.jsp").forward(request, response);
        
    }
    
    private void eliminarNota(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Recuperar el id de la nota, y lo almacenamos en una variable
        int idNota = Integer.parseInt(request.getParameter("id_nota"));

        //Crear el objeto de tipo nota
        Nota nota = new Nota(idNota);
 
        //Eliminar objeto de la base de datos
        int registrosEliminados = new NotaDaoImpl().eliminar(nota);

        System.out.println("Cantidas de registros eliminados:" + registrosEliminados);

        //Volvemos cargar las lista de estudiantes
        listarNota(request, response);
    }
    
    private void listarNota(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Nota> listaNotas = new NotaDaoImpl().listar();

        //Enviamos esa lista que va ir como atributo
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoNotas", listaNotas);

        response.sendRedirect("nota/listarNotas.jsp");
    }
    
}
